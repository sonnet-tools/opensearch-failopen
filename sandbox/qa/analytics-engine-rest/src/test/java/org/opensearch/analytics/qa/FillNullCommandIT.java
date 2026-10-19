            row("unknown", 0),
            "source=" + DATASET.indexName + " | fillnull using num0 = num1 | fields str2, num0",
    // ── helpers ─────────────────────────────────────────────────────────────────  
            row(-1, 3.79),
                    want.get(j),
    public void testFillNullVariousValuesTwoFields() throws IOException {  
            row(8589934592L),
 *
            row("eleven", -1),
 *   <li>{@code value=X} — Calcite-specific syntax, all fields and named fields</li>
            row(-1, 11.5),  
            row("nine", 10),  
            row(0, 11.69),  
                got.size()  
        @SuppressWarnings("unchecked")
        );
            row("N/A", null),
     * Construct an expected row from positional values. Element order must match the PPL  
            row(null, 0),
        }  
            row("eleven", 10.32),
        );  
            row(-1, 6.8),
        );  
            "source=" + DATASET.indexName + " | fields str2, num0 | fillnull value=-1 num0",
            row("nine", 10),  
            row(10, 0),
            row(8589934592L),  
    public void testFillNullWithLargeIntegerOnIntField() throws IOException {
            row("three", 15.7),  
     */  
 * <p>Covers all 13 fillnull surface forms:
            row(-1, 10.98),  
            row(-15.7, 8.51),  
    }  
            row(-12.3, 16.73),
        );  
            row(-1, -1),
            row(null, -15.7),
            "source=" + DATASET.indexName + " | fields str2, num0 | fillnull with -1 in num0",  
            row(15.7, -2),
    }
            row(8589934592L),
            row("five", 3.5),
            row("two", -12.3),  
            row("eight", -1),
            row("sixteen", -1),
        assertEquals("Row count mismatch for query: " + ppl, expected.length, actualRows.size());
            row("twelve", 2.47),  
            "replacement value type INTEGER is not compatible with field 'str2'"
            if (Double.compare(e, a) != 0) {  
            row("N/A", 8)
        // 8_589_934_592 = 2^33, larger than Integer.MAX_VALUE. NUMERIC type family should  
        );
        }
    // ── numeric type-family coercion (BIGINT into INTEGER field) ───────────────  
            DatasetProvisioner.provision(client(), DATASET);  
            row(8589934592L),
        assertRows(
        } catch (ResponseException e) {
            row("eleven", -1),
            row("fourteen", -1),  
     * body contains {@code expectedSubstring} (typically the validation message text).
            row("fifteen", -1),  
    private static final Dataset DATASET = new Dataset("calcs", "calcs");
     * Send a PPL query to {@code POST /_plugins/_ppl} and assert the response's {@code rows}
            row("eight", 12),
            row(8589934592L),  
    public void testFillNullSameValueTwoFields() throws IOException {  
        // Two chained fillnulls — first numeric (num0 from num1), then string (str2 → 'unknown').
            row(null, 12.05),  
            row(-1, 17.25),
        // accept BIGINT into an INTEGER field without failing the compatibility check.
            row("six", -3.5),
package org.opensearch.analytics.qa;
    /**  
                want.size(),
            row("nine", 10),  
                body = org.apache.hc.core5.http.io.entity.EntityUtils.toString(e.getResponse().getEntity());
            row("one", 12.3),
            List<Object> want = expected[i];
    }
            "source=" + DATASET.indexName + " | fillnull with num1 in num0 | fields str2, num0 | fillnull with 'unknown' in str2",  
            } catch (Exception ioe) {  
            row(-1, -2),  
    public void testFillNullValueSyntaxWithFields() throws IOException {
     * static {@code client()} is not initialized until after {@code @BeforeClass}, but is  
            assertTrue(  
            row("nine", null),  
 * <p>Provisions the {@code calcs} dataset (parquet-backed) once per class via
/**
import org.opensearch.client.Response;
            row(12.3, 17.86),  
            row("unknown", 12.05),
            row(0, 11.69),  
        // value=0 (INTEGER) on a projection containing a VARCHAR field must fail with the  
            row("fifteen", -1),
            row(15.7, 0),
        );
            row(-1, 10.98),  
            row("eight", -1),
            row(-1, 7.87)
            row("ten", 8),
    public void testFillNullValueSyntaxAllFields() throws IOException {
            row("six", -3.5),  
            row(-3.5, 8.98),
            List<Object> got = actualRows.get(i);
            row("two", -12.3),
            row("ten", 12.4),  
        }
            row(-1, -2),
            row("N/A", 8),
            row("unknown", 7.12)
            row("five", 3.5),
    protected void onBeforeQuery() throws IOException {
            row(1),
        );
            row("fifteen", 7.1),  
                "Column count mismatch at row " + i + " for query: " + ppl,
    }  
            row(0, 17.25),
        assertRows(
            row(-12.3, 16.73),
    }
            row("sixteen", -1),
 *   <li>{@code with ceil(...) in ...} — replacement contains a nested scalar call</li>  
            return;
            row("one", 12.3),
        );
            row("twelve", 2.47),
        assertRows(
     * (Java JSON parsing returns Integer/Long/Double interchangeably, but PPL doesn't
            row("fifteen", 7.1),
            row(null, 7.12)
     * match the expected list element-by-element using a numeric-tolerant comparator  
    public void testFillNullVariousValuesOneField() throws IOException {
     * DOUBLE column). Treat any two {@link Number} instances as equal if their {@code double}
            row("ten", 12.4),
    public void testFillNullSameValueOneField() throws IOException {
        assertRows(  
        } catch (IOException e) {
            row("ten", -1),
            row("six", -3.5),  
     */  
            row("fourteen", 10.37),
/*  
            assertEquals(  
     */
            row(4),
            row("fourteen", 10.37),
            row(-3.5, 8.98),
    public void testFillNullValueSyntaxWithStringValue() throws IOException {
            "source=" + DATASET.indexName + " | fields num0, num2 | fillnull using num0 = -1, num2 = -2",
            fail("Unexpected IOException: " + e);
            row("ten", -1),
        );  
            row("twelve", -1),  
        }
    }
            row(-15.7, 8.51),  
    private static List<Object> row(Object... values) {  
            row("eight", 11.38),
            row(null, -15.7),
            row("sixteen", -1),
    }
            }
            row(0, 3.79),
            "source=" + DATASET.indexName + " | fields str2, num0 | fillnull using num0 = -1",  
 * <ul>  
            row(8),
            row("three", 15.7),
            row("twelve", -1),  
                body = e.getMessage();
     * Lazily provision the calcs dataset on first invocation. Must be called inside a test
            String body;  
 * which runs the same {@code UnifiedQueryPlanner} → {@code CalciteRelNodeVisitor} →
     */  
        List<List<Object>> actualRows = (List<List<Object>>) response.get("datarows");  
    public void testFillNullWithFunctionMultipleCommands() throws IOException {  
            row("five", 3.5),
            row("six", -3.5),  
            row(15.7, -1),
            row("nine", 10),  
     */
import org.opensearch.client.Request;
    // ── nested-call replacement: exercises the recursive AnnotatedProjectExpression strip ──
            "source=" + DATASET.indexName + " | fields str2, int0 | fillnull value='N/A' str2",  
    }
            row("three", 15.7),  
     * values that may not match {@code .equals()} across types even when numerically equal
            row(10),  
        // No field list → applies to every field in the projection.  
            row("eight", -1),  
        assertRows(
            row(null, -1)
        // Replacement is a reference to another field, not a literal.  
        assertRows(
            row("fourteen", -1),
            fail("Expected query to fail with [" + expectedSubstring + "] but got response: " + response);
            row(3.5, 6.46),
    public void testFillNullWithOtherField() throws IOException {
 *
            "source=" + DATASET.indexName + " | fields num0, str2 | fillnull value='test' num0 str2",
            row(null, -1),
            "source=" + DATASET.indexName + " | fields num0, num2 | fillnull value=0",
        );  
            row("five", 3.5),  
 *   <li>type-incompatibility errors raised in {@code CalciteRelNodeVisitor} preflight</li>
 * cross-plugin dependencies on the SQL plugin. Each test sends a PPL query through  
            row(null, -15.7),  
            row(7),
    private final void assertRows(String ppl, List<Object>... expected) throws IOException {  
    private void assertErrorContains(String ppl, String expectedSubstring) {
            "source=" + DATASET.indexName + " | fields int0 | fillnull using int0=8589934592",  
    private static void assertCellEquals(String message, Object expected, Object actual) {
        if (expected == null || actual == null) {
            "replacement value type VARCHAR is not compatible with field 'num0'"
            row("unknown", -15.7),
public class FillNullCommandIT extends AnalyticsRestTestCase {  
import java.util.List;
            }
    }  
        assertNotNull("Response missing 'datarows' field for query: " + ppl, actualRows);
            row("eleven", 4),
            row(null, -15.7),
            try {
            row(8589934592L),
            row(null, 0),
            row("one", 12.3),
            row(-15.7, 8.51),  
            row("five", 3.5),
        }  
            row(8),
            "source=" + DATASET.indexName + " | fields num0, num2 | fillnull with -1 in num0,num2",
 * compatible open source license.
            row("sixteen", 17),
 *   <li>{@code with X in fields} — single value, named fields</li>
            row("eleven", 11),
            row("one", 1),
            row(0, 7.87)
        if (expected instanceof Number && actual instanceof Number) {  
    /**  
import java.util.Map;
    }
            row(10, -2),
    // ── using-clause: per-field replacement ─────────────────────────────────────
            row("fifteen", 11),  
            row("sixteen", 4),
    }  
     * (e.g. expected {@code 0} (Integer) vs actual {@code 0.0} (Double) for a null-replaced  
        Map<String, Object> response = executePpl(ppl);
            row(3.5, 6.46),
            row("three", 15.7),  
            row("three", null),  
            row(0, 10.98),  
            row(0, 13.04),
    }  
            row(-1, 3.79),
            row(-3.5, 8.98),
            row("two", -12.3),
                    got.get(j)  
            row("eleven", -1),  
            row("sixteen", 16.81),  
        for (int i = 0; i < expected.length; i++) {  
                );
    // ── with-clause: single value into named fields ─────────────────────────────
            row(4),
        );
            row(0, 11.69),  
            row("eight", null),
            row(0, 0),  
            );  
            row("N/A", null),
            row(null, -1)  
            row("twelve", 10),  
            row(3.5, 6.46),
            row("two", -12.3),
            row(-1, 11.5),  
import org.opensearch.client.ResponseException;  
 *
            row(null, 0),
            dataProvisioned = true;
    public void testFillNullWithMixedTypeFieldsError() {
            row("nine", 10),
            assertEquals(message, expected, actual);  
            row(null, -1)
            row(null, 8)
            row("two", -12.3),
     * reliably available inside test bodies. Mirrors the pattern in {@code PplClickBenchIT}.
        assertRows(
            row("fourteen", 11),
            row(11),  
    @SuppressWarnings("varargs")
    }  
            row("five", 7),
            row("twelve", 3),  
            "source=" + DATASET.indexName + " | fillnull with ceil(num1) in num0 | fields str2, num0",  
            row(null, 0),
        assertRows(
            row(null, -1),
            return;  
 *   <li>{@code using f=X, ...} — per-field replacement, including non-literal expressions</li>
 *  
            row("five", 3.5),
                fail(message + ": expected <" + expected + "> but was <" + actual + ">");
        assertRows(
 */
            row("six", 3),  
     * output column order (set by the {@code fields} clause / projection inferred from the query).
import java.util.Arrays;  
 */  
            row("two", null),
    // ── type-restriction errors (raised in CalciteRelNodeVisitor preflight) ────  
 * <p>Mirrors {@code CalciteFillNullCommandIT} from the {@code opensearch-project/sql}
    /**
                assertCellEquals(  
    }
            row(null, 0),  
                "Expected response body to contain [" + expectedSubstring + "] but was: " + body,
            row("sixteen", 16.81),
            }
            row("six", -3.5),  
    }
            row("six", -3.5),
            "source=" + DATASET.indexName + " | fields str2, int0 | fillnull value=0",  
     * values compare equal; otherwise fall back to {@link java.util.Objects#equals}.
            row("one", 12.3),
     * method (not {@code setUp()}) — {@link org.opensearch.test.rest.OpenSearchRestTestCase}'s
            row(-1, 13.04),
        assertEquals(message, expected, actual);
            row(-1, 7.87)
            row("two", -12.3),
 * Substrait → DataFusion pipeline as the SQL plugin's force-routed analytics path.  
            for (int j = 0; j < want.size(); j++) {
            row("one", 12.3),  
            row(10, -1),
            double e = ((Number) expected).doubleValue();
            row(8)
            row(12.3, 17.86),  
            row("fifteen", 8),  
            row("nine", 10),
 * Self-contained integration test for PPL {@code fillnull} on the analytics-engine route.
            Map<String, Object> response = executePpl(ppl);  
        assertErrorContains(  
 * The OpenSearch Contributors require contributions made to  
            row("ten", 13),
    private static boolean dataProvisioned = false;
            row("fourteen", -1),
    }
        try {
     * Compare two cells with numeric tolerance. JSON parsing produces Integer/Long/Double
    @SafeVarargs
            row("three", 15.7),
            row("fourteen", 4),
    // ── value= syntax (Calcite-specific) ────────────────────────────────────────  
            row(null, -15.7),
            double a = ((Number) actual).doubleValue();
            row("three", 15.7),  
    /**
        // type-incompatibility message from validateFillNullTypeCompatibility.
            row(0, 6.8),
            row(3),  
 * keeps it across test methods.
    public void testFillNullWithFunctionOnOtherField() throws IOException {
            row(null, -1),
 * this file be licensed under the Apache-2.0 license or a
 * repository so that the analytics-engine path can be verified inside core without
     * Send a PPL query expecting the planner to reject it; assert the resulting HTTP error
            row("eight", 11.38),
                    "Cell mismatch at row " + i + ", col " + j + " for query: " + ppl,
        assertRows(
            row(12.3, 17.86),  
            );
        if (dataProvisioned == false) {
 * </ul>  
 * SPDX-License-Identifier: Apache-2.0
     * preserve that distinction at the API surface).
            row(4),
    @Override  
 * {@link DatasetProvisioner}; {@link AnalyticsRestTestCase#preserveIndicesUponCompletion()}  
    }  
            row("fifteen", -1),  
        assertErrorContains(
        return Arrays.asList(values);
import java.io.IOException;
            row(-1, -1),  
            row(-12.3, 16.73),
            row("one", 12.3),
    public void testFillNullWithStringOnNumericAndStringMixedFields() {
            row(-1, 13.04),
 * {@code POST /_plugins/_ppl} (exposed by the {@code opensearch-sql} plugin),
            row(-1, 6.8),
            row("ten", -1),
    }
            row(0, 0),
            row(-1, 17.25),
            row("twelve", -1),
            row(0, 11.5),  
        assertRows(
        );  
            row(null, 13),
    /** Send {@code POST /_plugins/_ppl} and return the parsed JSON body. */  
                body.contains(expectedSubstring)
    /**  
        );  
}
            row("eleven", 10.32),
