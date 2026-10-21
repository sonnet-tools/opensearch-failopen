    }
                "Cell mismatch at row " + i + " for query: " + ppl,
 * <p>Provisions four small datasets ({@code spath_simple}, {@code spath_auto},
     */
            @SuppressWarnings("unchecked")
    public void testSpathAutoExtractWithWhere() throws IOException {
        List<List<Object>> actualRows = (List<List<Object>>) response.get("datarows");
    }
package org.opensearch.analytics.qa;
    /**
        assertRows(
     * GROUP BY result tables where the analytics-engine route doesn't guarantee a sort
                    got.get(j)
                    entry.getValue(),
            Map<String, Object> em = (Map<String, Object>) expected;
            row("3")
        );
     * sequence of maps (one map per row). Use {@code null} as an expected element to
    }
     * numeric-tolerant comparator.
            if (Double.compare(e, a) != 0) {
        // Numbers / booleans / nulls all stringify; null renders as the literal "null".
            row("John", "30"),
        if (expected instanceof Number && actual instanceof Number) {
 *       The MAP column drives the ITEM-on-MAP dispatch in {@code ArrayElementAdapter},
import java.util.Map;
        // schema: doc (struct); values are flattened single-key maps
     * order in the absence of an explicit {@code sort} clause.
            "source=" + CMD.indexName + " | spath input=doc | sort doc.user.name | fields doc.user.name",
 * {@link AnalyticsRestTestCase#preserveIndicesUponCompletion()} keeps them across
 * repository one-test-method-to-one so the analytics-engine path can be verified inside
     * by entry-set equality.
    private static final Dataset AUTO = new Dataset("spath_auto", "spath_auto");
            "source=" + SIMPLE.indexName + " | spath input=doc",
        // Nested objects flatten to dotted keys: user.name
        for (List<Object> want : expected) {
        // Bulk-load order: doc 1 (John), doc 2 (Alice).
                new java.util.HashSet<>(em.keySet()),
            "source=" + SIMPLE.indexName + " | spath input=doc output=result",
            row(25, "Alice"),
        for (int i = 0; i < expected.length; i++) {
        }
    }
                got.size()
            List<Object> got = actualRows.get(i);
    }
    /**
 * through {@code POST /_plugins/_ppl} (exposed by the {@code opensearch-sql}
            }
    }
    // ── helpers ─────────────────────────────────────────────────────────────────
        assertRowsInOrder(
        );
}
    public void testSpathAutoExtractWithOutput() throws IOException {
        java.util.List<List<Object>> remaining = new java.util.ArrayList<>(actualRows);
 *       the {@code map_extract} substrait wiring, and the {@code ArrowValues.MapVector}
            double e = ((Number) expected).doubleValue();
            row("2"),
            mapOf()
 */
            mapOf("user.name", "John")
        }
 * The OpenSearch Contributors require contributions made to
        // GROUP BY result is not order-stable on the analytics-engine route; assert via
        }
    }
                "Expected row not found in response for query: " + ppl + " — looking for " + want + ", remaining " + remaining,
     */
        );
        // Nested-key path and a literal dotted key both map to "a.b" → merged into a list.
        assertEquals("Row count mismatch for query: " + ppl, expected.length, actualRows.size());
            );
            "source=" + NULL_DATASET.indexName + " | spath input=doc output=result | fields result",
     * Integer/Long/Double interchangeably, so cell comparison goes through a
    private static final Dataset CMD = new Dataset("spath_cmd", "spath_cmd");
                assertCellEquals("rowsEqual", want.get(i), got.get(i));
    @Override
     * {@link java.util.Objects#equals}.
        // Malformed JSON returns the partial map (empty here — Jackson errors out before
    @SafeVarargs
                message + ": map key set mismatch",
                assertCellEquals(
    private static List<Object> row(Object... values) {
            mapOf("n", "2"),
                + " | eval doc.user.name=doc.user.name"
            mapOf("a.b", "[1, 2]")
        if (expected == null || actual == null) {
            Map<String, Object> am = (Map<String, Object>) actual;
            return;
                return false;
     * assert a row with a null cell.
    }
            DatasetProvisioner.provision(client(), SIMPLE);
        // SUM over an ITEM-extracted MAP value, GROUP BY another ITEM-extracted value.
 * compatible open source license.
 *       response marshalling — all introduced by the spath analytics-engine PR.</li>
    }
        // Same two assignments in separate eval commands.
    private static final Dataset SIMPLE = new Dataset("spath_simple", "spath_simple");
        // EQUALS on a MAP-column expression goes through the FieldType.MAP filter
            row("{\"n\": 1}", mapOf("n", "1")),
        );
                    matchIdx = i;
    public void testSpathAutoExtractWithStats() throws IOException {
    public void testSpathAutoExtractWithMultiFieldEval() throws IOException {
        assertMapRows(
            "source=" + AUTO.indexName + " | spath input=merge_doc output=result | fields result",
                + " | eval doc.user.age=doc.user.age"
            row("Alice"),
        }
        // ITEM(JSON_EXTRACT_ALL(doc), 'user.name') → scalar VARCHAR through the
        // Arrays use {} suffix; merged values use [a, b, c] format
        if (expected instanceof Map && actual instanceof Map) {
                + " | eval doc.user.name=doc.user.name, doc.user.age=doc.user.age"
            );
    }
     * Assert rows match the expected sequence. JSON parsing turns numbers into
            assertEquals(
    /**
     * map. Insertion order is not significant — {@link #assertCellEquals} compares maps
            row("John")
        // map_extract + array_element(...,1) wrap in the analytics-engine adapter.
            m.put((String) keyValuePairs[i], keyValuePairs[i + 1]);
    private static boolean dataProvisioned = false;
            remaining.remove(matchIdx);
            "source=" + CMD.indexName + " | spath input=doc | eval name = doc.user.name | fields name",
        assertEquals(message, expected, actual);
            "source=" + CMD.indexName + " | spath input=doc | stats sum(doc.user.age) by doc.user.name",
                want.size(),
            row("1"),
    }
     * Assert rows match the expected set without row-order significance. Used for
    public void testSpathAutoExtractArraySuffix() throws IOException {
                );
            DatasetProvisioner.provision(client(), CMD);
    /**
        assertRows(
 *       {@code json_extract_all(doc)} which returns a {@code MAP<VARCHAR, VARCHAR>}).
        // First row: doc parses to {n:1}. Second row: doc is null → null map.
            assertEquals(message, expected, actual);
        );
        // schema: doc (string), result (struct)
public class SpathCommandIT extends AnalyticsRestTestCase {
            "source=" + CMD.indexName + " | spath input=doc"
                    break;
                got.get(0)
    }
        if (dataProvisioned == false) {
        );
        assertNotNull("Response missing 'datarows' field for query: " + ppl, actualRows);
            "source=" + AUTO.indexName + " | spath input=malformed_doc output=result | fields result",
        assertRowsAnyOrder(
        );
    protected void onBeforeQuery() throws IOException {
     */
    }
                    message + ": map[" + entry.getKey() + "]",
        return m;
        }
     * Assert rows match the expected sequence with row-order significance (for sort tests).
 *       {@code json_extract(doc, 'N')} on the DataFusion side).</li>
            }
    @SuppressWarnings("varargs")
            row("Alice")
 * this file be licensed under the Apache-2.0 license or a
        for (int i = 0; i < expected.length; i++) {
    }
        if (keyValuePairs.length % 2 != 0) {
     */
                + " | fields doc.user.name, doc.user.age",
            double a = ((Number) actual).doubleValue();
    private final void assertMapRows(String ppl, Map<String, Object>... expected) throws IOException {
    @SuppressWarnings("varargs")
    public void testSpathAutoExtractMalformedJson() throws IOException {
        );
     * {@code client()} is not initialized until after {@code @BeforeClass}, but is
                    "Cell mismatch at row " + i + ", col " + j + " for query: " + ppl,
                + " | fields doc.user.name, doc.user.age",
    }
        );
            row("Alice", "25")
    private static boolean rowsEqual(List<Object> want, List<Object> got) {
            for (int i = 0; i < remaining.size(); i++) {
        // capability registered for the analytics-engine route.
    @SafeVarargs
            @SuppressWarnings("unchecked")
        assertRows(ppl, expected);
            throw new IllegalArgumentException("mapOf requires an even number of arguments");
    private final void assertRowsInOrder(String ppl, List<Object>... expected) throws IOException {
        assertRows(
    }
    }
    @SafeVarargs
 *
        }
    }
        assertRows(
    public void testSpathAutoExtractNestedFields() throws IOException {
        if (want.size() != got.size()) return false;
        }
 *   <li>Auto-extract mode — {@code spath input=doc} (lowers to
        }
        return Arrays.asList(values);
        List<List<Object>> actualRows = (List<List<Object>>) response.get("datarows");
        assertMapRows(
            assertTrue(
    }
 * SPDX-License-Identifier: Apache-2.0
 * {@code spath_cmd}, {@code spath_null}) once per class via {@link DatasetProvisioner};
            row("John")
    }
    }
    private static void assertCellEquals(String message, Object expected, Object actual) {
            );
            mapOf()
import org.opensearch.client.Response;
 * <ul>
        }
        );
                want,
     * Assert that a query returning a single MAP-typed column produces the expected
/*
        // set-equality.
    public void testSpathAutoExtractStringifyAndNull() throws IOException {
            return;
 *
        @SuppressWarnings("unchecked")
            "source=" + AUTO.indexName + " | spath input=nested_doc output=result | fields result",
     * Maps compare key-set + per-key recursion; everything else falls back to
 * core without cross-plugin dependencies on the SQL plugin. Each test sends a PPL query
    // ── eval / where / stats / sort with auto-extract MAP column ────────────────
    }
            dataProvisioned = true;
            row("John"),
            DatasetProvisioner.provision(client(), AUTO);
            row("{\"n\": 3}", mapOf("n", "3"))
            row("{\"n\": 2}", mapOf("n", "2")),
    }
     * Build an expected MAP cell. The auto-extract output deserializes to a Java
import java.io.IOException;
        assertMapRows(
            }
                if (rowsEqual(want, remaining.get(i))) {
    private static Map<String, Object> mapOf(Object... keyValuePairs) {
    public void testSpathAutoExtractDuplicateKeysMerge() throws IOException {
    // ── path mode ───────────────────────────────────────────────────────────────
            mapOf("n", "1"),
        // Two dotted-path assignments in a single eval (issue #5185 regression).
            for (int j = 0; j < want.size(); j++) {
            assertCellEquals(
        );
 * </ul>
            "source=" + AUTO.indexName + " | spath input=stringify_doc output=result | fields result",
        assertEquals("Row count mismatch for query: " + ppl, expected.length, actualRows.size());
        assertNotNull("Response missing 'datarows' field for query: " + ppl, actualRows);
        assertMapRows(
            row("Alice", "25")
        assertRows(
    // ── auto-extract mode ───────────────────────────────────────────────────────
        List<List<Object>> actualRows = (List<List<Object>>) response.get("datarows");
            mapOf("n", "30", "b", "true", "x", "null")
        );
            null
        }
import java.util.List;
        // Empty JSON object returns an empty map (not null).
    /** Build an expected row from positional values. */
            return;
     * reliably available inside test bodies.
            assertEquals("Column count mismatch at row " + i + " for query: " + ppl, 1, got.size());
 *   <li>Path mode — {@code spath path=N input=doc output=result} (lowers to
    /** {@code POST /_plugins/_ppl} and parse the JSON body. */
    }
    private static final Dataset NULL_DATASET = new Dataset("spath_null", "spath_null");
    public void testSimpleSpath() throws IOException {
        assertEquals("Row count mismatch for query: " + ppl, expected.length, actualRows.size());
        assertMapRows(
     * test method (not {@code setUp()}) — {@code OpenSearchRestTestCase}'s static
        assertMapRows(
                fail(message + ": expected <" + expected + "> but was <" + actual + ">");
     * Lazily provision all four datasets on first invocation. Must be called inside a
            List<Object> got = actualRows.get(i);
     * {@code Map<String, Object>} on the wire, so we compare against a built-from-pairs
 *
            "source=" + AUTO.indexName + " | spath input=empty_doc output=result | fields result",
    @SuppressWarnings("varargs")
     * Numeric-tolerant cell comparison. Numbers cross-compare via {@code doubleValue()};
    private final void assertRows(String ppl, List<Object>... expected) throws IOException {
    public void testSpathAutoExtractWithSort() throws IOException {
    public void testSpathAutoExtractEmptyJson() throws IOException {
    /**
    public void testSpathAutoExtractNullInput() throws IOException {
            }
        java.util.LinkedHashMap<String, Object> m = new java.util.LinkedHashMap<>();
     */
        // any (field-name, value) pair lands).
            row("John", "30"),
import org.opensearch.client.Request;
            );
     */
        @SuppressWarnings("unchecked")
            assertEquals(
            mapOf("n", "1"),
    public void testSpathAutoExtractWithEval() throws IOException {
        for (int i = 0; i < want.size(); i++) {
        Map<String, Object> response = executePpl(ppl);
                new java.util.HashSet<>(am.keySet())
        return true;
    /**
            } catch (AssertionError ae) {
            List<Object> want = expected[i];
            }
            "source=" + CMD.indexName + " | spath input=doc"
        );
        );
        Map<String, Object> response = executePpl(ppl);
        for (int i = 0; i < keyValuePairs.length; i += 2) {
    public void testSpathAutoExtractWithSeparateEvalCommands() throws IOException {
/**
                matchIdx >= 0
 *
        assertRows(
            row(30, "John")
 * plugin), which runs the same {@code UnifiedQueryPlanner} → {@code CalciteRelNodeVisitor}
 * → Substrait → DataFusion pipeline as the SQL plugin's force-routed analytics path.
            try {
            mapOf("n", "3")
            for (Map.Entry<String, Object> entry : em.entrySet()) {
                );
 * <p>Exercises both spath modes:
 * test methods.
    private final void assertRowsAnyOrder(String ppl, List<Object>... expected) throws IOException {
        Map<String, Object> response = executePpl(ppl);
     */
    /** Numeric-tolerant per-row equality, used by {@link #assertRowsAnyOrder}. */
    /**
        assertNotNull("Response missing 'datarows' field for query: " + ppl, actualRows);
                "Column count mismatch at row " + i + " for query: " + ppl,
            "source=" + SIMPLE.indexName + " | spath input=doc output=result path=n | fields result",
import java.util.Arrays;
        assertMapRows(
        assertMapRows(
            "source=" + AUTO.indexName + " | spath input=array_doc output=result | fields result",
                assertCellEquals(
    @SuppressWarnings("varargs")
 * <p>Mirrors {@code CalcitePPLSpathCommandIT} from the {@code opensearch-project/sql}
                    am.get(entry.getKey())
    public void testSpathAutoExtract() throws IOException {
        );
            DatasetProvisioner.provision(client(), NULL_DATASET);
        // Bulk-load order: doc 1 (John, 30), doc 2 (Alice, 25).
                }
            int matchIdx = -1;
            Map<String, Object> want = expected[i];
            mapOf("tags{}", "[java, sql]")
    @SafeVarargs
                    want.get(j),
    }
        );
 */
            "source=" + CMD.indexName + " | spath input=doc | where doc.user.name = 'John' | fields doc.user.name",
        @SuppressWarnings("unchecked")
 * Self-contained integration test for PPL {@code spath} on the analytics-engine route.
