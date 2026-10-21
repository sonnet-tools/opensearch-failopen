    public void testFillNullWithLargeIntegerOnIntField() throws IOException {
            row(-1, -1),
     * Lazily provision the calcs dataset on first invocation. Must be called inside a test
            row(-15.7, 8.51),
                "Column count mismatch at row " + i + " for query: " + ppl,
            row("eight", -1),
    // ── nested-call replacement: exercises the recursive AnnotatedProjectExpression strip ──
        } catch (ResponseException e) {
            row("five", 3.5),
    // ── numeric type-family coercion (BIGINT into INTEGER field) ───────────────
            row("fifteen", -1),
        assertRows(
    /** Send {@code POST /_plugins/_ppl} and return the parsed JSON body. */
        }
            List<Object> got = actualRows.get(i);
            row(10, 0),
            row("nine", 10),
        // Two chained fillnulls — first numeric (num0 from num1), then string (str2 → 'unknown').
        assertRows(
        );
            row(0, 13.04),
 *   <li>{@code with ceil(...) in ...} — replacement contains a nested scalar call</li>
            "source=" + DATASET.indexName + " | fields num0, str2 | fillnull value='test' num0 str2",
        assertRows(
            row(8589934592L),
 * SPDX-License-Identifier: Apache-2.0
            return;
            row("eleven", 10.32),
/*
     * (e.g. expected {@code 0} (Integer) vs actual {@code 0.0} (Double) for a null-replaced
            row("fourteen", 4),
            row("eight", null),
            "source=" + DATASET.indexName + " | fields str2, num0 | fillnull value=-1 num0",
     * values compare equal; otherwise fall back to {@link java.util.Objects#equals}.
                    want.get(j),
    }
            if (Double.compare(e, a) != 0) {
            row(15.7, 0),
 * The OpenSearch Contributors require contributions made to
    /**
            }
            row(0, 0),
    }
            row(null, -15.7),
    }
     */
        // No field list → applies to every field in the projection.
        );
            row("unknown", -15.7),
            row("five", 3.5),
    }
 * </ul>
            row("eight", -1),
     * static {@code client()} is not initialized until after {@code @BeforeClass}, but is
        assertRows(
        assertRows(
            row("sixteen", -1),
            "source=" + DATASET.indexName + " | fields num0, num2 | fillnull value=0",
            row(8589934592L),
        assertRows(
            String body;
            row(0, 10.98),
            row("three", 15.7),
            row(15.7, -2),
            row("six", -3.5),
    public void testFillNullWithFunctionMultipleCommands() throws IOException {
 * Self-contained integration test for PPL {@code fillnull} on the analytics-engine route.
            } catch (Exception ioe) {
        List<List<Object>> actualRows = (List<List<Object>>) response.get("datarows");
            row(-1, 6.8),
        }
import java.util.List;
import org.opensearch.client.Response;
    }
    }
            row(-1, 3.79),
            row("six", -3.5),
            row(null, 12.05),
            row("five", 3.5),
 *   <li>{@code with X in fields} — single value, named fields</li>
    public void testFillNullValueSyntaxWithStringValue() throws IOException {
            row("N/A", 8),
            row("eight", -1),
    public void testFillNullValueSyntaxWithFields() throws IOException {
            "source=" + DATASET.indexName + " | fields int0 | fillnull using int0=8589934592",
    }
            row(-1, 17.25),
                body = e.getMessage();
        // accept BIGINT into an INTEGER field without failing the compatibility check.
            "source=" + DATASET.indexName + " | fillnull with ceil(num1) in num0 | fields str2, num0",
        if (expected instanceof Number && actual instanceof Number) {
            row(-1, -1),
            row("three", 15.7),
        assertRows(
     * preserve that distinction at the API surface).
            row("six", -3.5),
/**
 * Substrait → DataFusion pipeline as the SQL plugin's force-routed analytics path.
            "source=" + DATASET.indexName + " | fields num0, num2 | fillnull using num0 = -1, num2 = -2",
            row("sixteen", 17),
            row(10, -1),
            }
    protected void onBeforeQuery() throws IOException {
            row("three", null),
 */
            row(-12.3, 16.73),
        // value=0 (INTEGER) on a projection containing a VARCHAR field must fail with the
            row(null, 0),
            row(10),
                body = org.apache.hc.core5.http.io.entity.EntityUtils.toString(e.getResponse().getEntity());
            row("unknown", 0),
        assertRows(
            row("twelve", -1),
            row("nine", 10),
            row("ten", -1),
 *   <li>{@code using f=X, ...} — per-field replacement, including non-literal expressions</li>
            row(3.5, 6.46),
     * values that may not match {@code .equals()} across types even when numerically equal
public class FillNullCommandIT extends AnalyticsRestTestCase {
    // ── value= syntax (Calcite-specific) ────────────────────────────────────────
     * DOUBLE column). Treat any two {@link Number} instances as equal if their {@code double}
            row("three", 15.7),
            for (int j = 0; j < want.size(); j++) {
            double e = ((Number) expected).doubleValue();
    public void testFillNullWithMixedTypeFieldsError() {
    }
            row("three", 15.7),
            row("two", -12.3),
 * repository so that the analytics-engine path can be verified inside core without
            row(0, 6.8),
            row("twelve", -1),
            row("ten", 13),
            Map<String, Object> response = executePpl(ppl);
            row("two", -12.3),
            row("fourteen", 10.37),
            row("two", -12.3),
 *
    /**
            List<Object> want = expected[i];
        );
    }
    // ── with-clause: single value into named fields ─────────────────────────────
            row(null, -1)
            row("twelve", 2.47),
            row(-1, 7.87)
            row(null, 8)
            row(-1, 3.79),
            row(3.5, 6.46),
    public void testFillNullSameValueOneField() throws IOException {
     * method (not {@code setUp()}) — {@link org.opensearch.test.rest.OpenSearchRestTestCase}'s
            row(-15.7, 8.51),
            row(3.5, 6.46),
        assertErrorContains(
    }
            row("unknown", 12.05),
            row("nine", 10),
            row(3),
            row(null, -1),
     * reliably available inside test bodies. Mirrors the pattern in {@code PplClickBenchIT}.
            row("fifteen", -1),
    // ── using-clause: per-field replacement ─────────────────────────────────────
     */
            row("eight", 11.38),
            row(null, 0),
            row(12.3, 17.86),
        );
            row("ten", 8),
 * {@link DatasetProvisioner}; {@link AnalyticsRestTestCase#preserveIndicesUponCompletion()}
            row("N/A", null),
    }
    // ── type-restriction errors (raised in CalciteRelNodeVisitor preflight) ────
 * {@code POST /_plugins/_ppl} (exposed by the {@code opensearch-sql} plugin),
    }
            row("ten", 12.4),
            dataProvisioned = true;
 * <p>Provisions the {@code calcs} dataset (parquet-backed) once per class via
 *
    private static List<Object> row(Object... values) {
            row("fourteen", 11),
        for (int i = 0; i < expected.length; i++) {
        );
            );
    public void testFillNullWithFunctionOnOtherField() throws IOException {
        assertEquals(message, expected, actual);
        // type-incompatibility message from validateFillNullTypeCompatibility.
            row("fifteen", 7.1),
    private final void assertRows(String ppl, List<Object>... expected) throws IOException {
            row(0, 17.25),
        );
            row("fifteen", -1),
    }
            row(0, 7.87)
    }
}
            row(-1, 6.8),
            row("fourteen", -1),
            row("eight", 11.38),
            row(8),
            row("twelve", 2.47),
            row("sixteen", -1),
 *
 *   <li>type-incompatibility errors raised in {@code CalciteRelNodeVisitor} preflight</li>
            row("sixteen", 16.81),
            row(-1, 7.87)
            row("twelve", 10),
            row(-1, 11.5),
            row("fourteen", -1),
            row(-3.5, 8.98),
                got.size()
            row("fifteen", 8),
            row("one", 12.3),
            row(null, -15.7),
    }
            row("one", 12.3),
            row(-1, -2),
    private void assertErrorContains(String ppl, String expectedSubstring) {
        }
                fail(message + ": expected <" + expected + "> but was <" + actual + ">");
            row(null, -1),
            "replacement value type VARCHAR is not compatible with field 'num0'"
            row("sixteen", 16.81),
            row("N/A", 8)
     * output column order (set by the {@code fields} clause / projection inferred from the query).
        if (dataProvisioned == false) {
        return Arrays.asList(values);
    public void testFillNullVariousValuesTwoFields() throws IOException {
     * Send a PPL query to {@code POST /_plugins/_ppl} and assert the response's {@code rows}
            row(12.3, 17.86),
            row(-1, 17.25),
            );
            row("ten", -1),
            row(-1, 10.98),
            row("ten", -1),
        try {
            row(-1, 10.98),
        );
            "source=" + DATASET.indexName + " | fillnull using num0 = num1 | fields str2, num0",
        );
        // Replacement is a reference to another field, not a literal.
        }
    @SafeVarargs
            row("one", 12.3),
            row(-3.5, 8.98),
            row("one", 12.3),
        assertEquals("Row count mismatch for query: " + ppl, expected.length, actualRows.size());
            row(0, 11.69),
import org.opensearch.client.Request;
            row(0, 11.5),
            row(1),
        assertRows(
            row("N/A", null),
            row("three", 15.7),
            row(8)
    }
            row("twelve", -1),
            row("unknown", 7.12)
            row(null, -1)
    // ── helpers ─────────────────────────────────────────────────────────────────
            row("eight", 12),
        );
            row("ten", 12.4),
            row(null, -15.7),
            row(null, 13),
            row(null, 0),
            row("eleven", -1),
    public void testFillNullWithOtherField() throws IOException {
     */
            row("nine", 10),
            row(8589934592L),
            row(-1, 11.5),
 * this file be licensed under the Apache-2.0 license or a
            row(-1, 13.04),
    private static final Dataset DATASET = new Dataset("calcs", "calcs");
 * <p>Mirrors {@code CalciteFillNullCommandIT} from the {@code opensearch-project/sql}
            row(7),
            row(-12.3, 16.73),
            row(12.3, 17.86),
            row(0, 3.79),
        assertNotNull("Response missing 'datarows' field for query: " + ppl, actualRows);
                assertCellEquals(
        } catch (IOException e) {
            row("twelve", 3),
            "source=" + DATASET.indexName + " | fields str2, int0 | fillnull value='N/A' str2",
            row(8589934592L),
            row("five", 3.5),
            row(-15.7, 8.51),
            row(8589934592L),
            row(8589934592L),
            row("nine", 10),
        @SuppressWarnings("unchecked")
 *   <li>{@code value=X} — Calcite-specific syntax, all fields and named fields</li>
            row("fifteen", 7.1),
 * keeps it across test methods.
            row(-12.3, 16.73),
            "source=" + DATASET.indexName + " | fields num0, num2 | fillnull with -1 in num0,num2",
            row(0, 11.69),
            "source=" + DATASET.indexName + " | fields str2, num0 | fillnull using num0 = -1",
            row("six", -3.5),
    @SuppressWarnings("varargs")
            assertEquals(message, expected, actual);
            row("sixteen", -1),
            row("two", -12.3),
            row("six", -3.5),
            row("eleven", -1),
            try {
        Map<String, Object> response = executePpl(ppl);
            row("eleven", 4),
                );
    }
 * which runs the same {@code UnifiedQueryPlanner} → {@code CalciteRelNodeVisitor} →
            row("one", 12.3),
            row("one", 12.3),
            row(10, -2),
            assertEquals(
        );
            row("eleven", -1),
            fail("Expected query to fail with [" + expectedSubstring + "] but got response: " + response);
            row(null, -1),
            row("eleven", 10.32),
    /**
            row("nine", null),
            return;
            row("two", null),
        );
import java.io.IOException;
     * match the expected list element-by-element using a numeric-tolerant comparator
            row(-1, 13.04),
            row("six", -3.5),
            }
import java.util.Map;
        assertErrorContains(
            row(-3.5, 8.98),
            row(null, -15.7),
            row("two", -12.3),
 * cross-plugin dependencies on the SQL plugin. Each test sends a PPL query through
            double a = ((Number) actual).doubleValue();
            row(11),
    /**
            assertTrue(
        assertRows(
    /**
     * body contains {@code expectedSubstring} (typically the validation message text).
    private static boolean dataProvisioned = false;
        );
import java.util.Arrays;
 */
            row(0, 0),
            "source=" + DATASET.indexName + " | fields str2, num0 | fillnull with -1 in num0",
    public void testFillNullVariousValuesOneField() throws IOException {
            row("one", 1),
 * <ul>
            row("eleven", 11),
            row(4),
            row(null, 7.12)
     */
            row(null, -1)
            fail("Unexpected IOException: " + e);
                    got.get(j)
            row("five", 7),
 *
            row("five", 3.5),
    public void testFillNullValueSyntaxAllFields() throws IOException {
                want.size(),
 * <p>Covers all 13 fillnull surface forms:
            row(0, 11.69),
        // 8_589_934_592 = 2^33, larger than Integer.MAX_VALUE. NUMERIC type family should
    public void testFillNullWithStringOnNumericAndStringMixedFields() {
            row(null, -15.7),
            row(4),
     * Construct an expected row from positional values. Element order must match the PPL
        if (expected == null || actual == null) {
                "Expected response body to contain [" + expectedSubstring + "] but was: " + body,
            row("fourteen", -1),
            DatasetProvisioner.provision(client(), DATASET);
        );
        }
                    "Cell mismatch at row " + i + ", col " + j + " for query: " + ppl,
            row("six", 3),
            "source=" + DATASET.indexName + " | fillnull with num1 in num0 | fields str2, num0 | fillnull with 'unknown' in str2",
            row(null, 0),
     * Compare two cells with numeric tolerance. JSON parsing produces Integer/Long/Double
            row("nine", 10),
            row("five", 3.5),
            row(4),
            "replacement value type INTEGER is not compatible with field 'str2'"
 * compatible open source license.
            "source=" + DATASET.indexName + " | fields str2, int0 | fillnull value=0",
            row(-1, -2),
package org.opensearch.analytics.qa;
                body.contains(expectedSubstring)
            row("fifteen", 11),
            row(null, 0),
            row("fourteen", 10.37),
            row("two", -12.3),
            row(8),
            row(15.7, -1),
     * Send a PPL query expecting the planner to reject it; assert the resulting HTTP error
        assertRows(
     * (Java JSON parsing returns Integer/Long/Double interchangeably, but PPL doesn't
    }
     */
    public void testFillNullSameValueTwoFields() throws IOException {
            row("sixteen", 4),
            row("three", 15.7),
import org.opensearch.client.ResponseException;
    @Override
    private static void assertCellEquals(String message, Object expected, Object actual) {
