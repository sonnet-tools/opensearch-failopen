 *       {@code json_extract(doc, 'N')} on the DataFusion side).</li>
     * {@code Map<String, Object>} on the wire, so we compare against a built-from-pairs
        // Nested-key path and a literal dotted key both map to "a.b" → merged into a list.
        // Same two assignments in separate eval commands.  
        );
    @SafeVarargs
        );
        }
package org.opensearch.analytics.qa;
        assertMapRows(  
        // schema: doc (struct); values are flattened single-key maps
            row("{\"n\": 2}", mapOf("n", "2")),  
        assertMapRows(  
                + " | eval doc.user.name=doc.user.name"  
                message + ": map key set mismatch",
 *  
    }
    public void testSpathAutoExtractNestedFields() throws IOException {
    public void testSpathAutoExtractNullInput() throws IOException {
 *
        if (dataProvisioned == false) {
    /** Build an expected row from positional values. */
 *
    public void testSpathAutoExtractEmptyJson() throws IOException {
        // any (field-name, value) pair lands).
 * {@link AnalyticsRestTestCase#preserveIndicesUponCompletion()} keeps them across  
            "source=" + NULL_DATASET.indexName + " | spath input=doc output=result | fields result",
    }  
                    got.get(j)
                + " | fields doc.user.name, doc.user.age",
     */
    private static final Dataset SIMPLE = new Dataset("spath_simple", "spath_simple");
    public void testSpathAutoExtractWithWhere() throws IOException {
            try {
        assertRowsAnyOrder(
    }
     * Build an expected MAP cell. The auto-extract output deserializes to a Java
            dataProvisioned = true;
        assertNotNull("Response missing 'datarows' field for query: " + ppl, actualRows);
        );
            "source=" + CMD.indexName + " | spath input=doc | where doc.user.name = 'John' | fields doc.user.name",
        Map<String, Object> response = executePpl(ppl);  
        // Empty JSON object returns an empty map (not null).
            }
            row("{\"n\": 3}", mapOf("n", "3"))
        for (int i = 0; i < expected.length; i++) {  
        assertMapRows(
            assertEquals(
                    entry.getValue(),  
        assertEquals("Row count mismatch for query: " + ppl, expected.length, actualRows.size());
    // ── eval / where / stats / sort with auto-extract MAP column ────────────────  
                return false;
     * Maps compare key-set + per-key recursion; everything else falls back to
     * assert a row with a null cell.
        }  
     */  
        // Malformed JSON returns the partial map (empty here — Jackson errors out before
 */  
            "source=" + SIMPLE.indexName + " | spath input=doc output=result path=n | fields result",  
        // ITEM(JSON_EXTRACT_ALL(doc), 'user.name') → scalar VARCHAR through the  
            row("Alice")  
            "source=" + AUTO.indexName + " | spath input=stringify_doc output=result | fields result",
            for (int i = 0; i < remaining.size(); i++) {
            "source=" + AUTO.indexName + " | spath input=malformed_doc output=result | fields result",
    /** Numeric-tolerant per-row equality, used by {@link #assertRowsAnyOrder}. */  
    }
            row("Alice", "25")
    protected void onBeforeQuery() throws IOException {
        if (expected == null || actual == null) {
    public void testSpathAutoExtractWithSort() throws IOException {  
            );
                "Column count mismatch at row " + i + " for query: " + ppl,  
            "source=" + AUTO.indexName + " | spath input=array_doc output=result | fields result",
        );
            return;  
        @SuppressWarnings("unchecked")  
 * The OpenSearch Contributors require contributions made to  
        assertRows(
public class SpathCommandIT extends AnalyticsRestTestCase {  
    /**  
            return;
    @SafeVarargs
        List<List<Object>> actualRows = (List<List<Object>>) response.get("datarows");
    }
     * GROUP BY result tables where the analytics-engine route doesn't guarantee a sort
 * {@code spath_cmd}, {@code spath_null}) once per class via {@link DatasetProvisioner};
            mapOf()
            "source=" + AUTO.indexName + " | spath input=empty_doc output=result | fields result",
 * repository one-test-method-to-one so the analytics-engine path can be verified inside
        // Bulk-load order: doc 1 (John), doc 2 (Alice).
        // map_extract + array_element(...,1) wrap in the analytics-engine adapter.
     * map. Insertion order is not significant — {@link #assertCellEquals} compares maps  
        }
 * SPDX-License-Identifier: Apache-2.0
    /**
            );
            Map<String, Object> want = expected[i];
        for (int i = 0; i < want.size(); i++) {  
                assertCellEquals(
            mapOf("n", "1"),
            mapOf("n", "1"),
            assertTrue(
            mapOf("a.b", "[1, 2]")
                    message + ": map[" + entry.getKey() + "]",
    }
            }  
        List<List<Object>> actualRows = (List<List<Object>>) response.get("datarows");  
                + " | fields doc.user.name, doc.user.age",
            row("3")  
     * Assert rows match the expected set without row-order significance. Used for
    }
            row(30, "John")
            @SuppressWarnings("unchecked")
        // SUM over an ITEM-extracted MAP value, GROUP BY another ITEM-extracted value.
        return Arrays.asList(values);  
    /**  
    @SafeVarargs  
        // GROUP BY result is not order-stable on the analytics-engine route; assert via  
        // Bulk-load order: doc 1 (John, 30), doc 2 (Alice, 25).
            @SuppressWarnings("unchecked")  
            row("{\"n\": 1}", mapOf("n", "1")),
import java.util.Map;
    @SuppressWarnings("varargs")  
            double e = ((Number) expected).doubleValue();
     * by entry-set equality.
        Map<String, Object> response = executePpl(ppl);
            "source=" + AUTO.indexName + " | spath input=merge_doc output=result | fields result",  
    }  
 *       the {@code map_extract} substrait wiring, and the {@code ArrowValues.MapVector}  
            row("1"),
        }
                    want.get(j),
            assertEquals("Column count mismatch at row " + i + " for query: " + ppl, 1, got.size());  
        assertRows(ppl, expected);  
import java.io.IOException;
            }
    public void testSpathAutoExtractWithOutput() throws IOException {
            row("John", "30"),  
 * <p>Mirrors {@code CalcitePPLSpathCommandIT} from the {@code opensearch-project/sql}
            row("John", "30"),  
        );
        assertMapRows(
        assertMapRows(
        );  
        assertRowsInOrder(
            mapOf()
    private final void assertRows(String ppl, List<Object>... expected) throws IOException {
        }  
    private static boolean rowsEqual(List<Object> want, List<Object> got) {
        java.util.LinkedHashMap<String, Object> m = new java.util.LinkedHashMap<>();
    private final void assertMapRows(String ppl, Map<String, Object>... expected) throws IOException {  
 * test methods.
    public void testSpathAutoExtract() throws IOException {  
                    break;
 *   <li>Auto-extract mode — {@code spath input=doc} (lowers to  
            for (int j = 0; j < want.size(); j++) {
        // schema: doc (string), result (struct)
    private final void assertRowsAnyOrder(String ppl, List<Object>... expected) throws IOException {
                }
    }  
        assertRows(  
                new java.util.HashSet<>(am.keySet())
/**
    // ── auto-extract mode ───────────────────────────────────────────────────────
import java.util.List;
    @SafeVarargs  
            }
    }
    private static final Dataset CMD = new Dataset("spath_cmd", "spath_cmd");
     */
        java.util.List<List<Object>> remaining = new java.util.ArrayList<>(actualRows);
                "Cell mismatch at row " + i + " for query: " + ppl,
            "source=" + CMD.indexName + " | spath input=doc | sort doc.user.name | fields doc.user.name",
            "source=" + SIMPLE.indexName + " | spath input=doc",  
        }
                assertCellEquals(
        assertNotNull("Response missing 'datarows' field for query: " + ppl, actualRows);
        // capability registered for the analytics-engine route.  
            "source=" + CMD.indexName + " | spath input=doc"
    private static final Dataset AUTO = new Dataset("spath_auto", "spath_auto");  
            );  
        assertMapRows(
        assertRows(
                "Expected row not found in response for query: " + ppl + " — looking for " + want + ", remaining " + remaining,
 * through {@code POST /_plugins/_ppl} (exposed by the {@code opensearch-sql}
     */  
    public void testSpathAutoExtractArraySuffix() throws IOException {
     */
import java.util.Arrays;  
            row("Alice", "25")
        );
        return true;
        List<List<Object>> actualRows = (List<List<Object>>) response.get("datarows");
    /**  
            row(25, "Alice"),
    }  
    public void testSpathAutoExtractWithEval() throws IOException {
    public void testSpathAutoExtractWithStats() throws IOException {
        }
            List<Object> got = actualRows.get(i);
        Map<String, Object> response = executePpl(ppl);
 * core without cross-plugin dependencies on the SQL plugin. Each test sends a PPL query  
    private static void assertCellEquals(String message, Object expected, Object actual) {
    public void testSpathAutoExtractStringifyAndNull() throws IOException {
 *       response marshalling — all introduced by the spath analytics-engine PR.</li>
    @SuppressWarnings("varargs")
            "source=" + CMD.indexName + " | spath input=doc | eval name = doc.user.name | fields name",
                fail(message + ": expected <" + expected + "> but was <" + actual + ">");
            row("John")  
     * {@code client()} is not initialized until after {@code @BeforeClass}, but is  
    @SuppressWarnings("varargs")
    // ── helpers ─────────────────────────────────────────────────────────────────
            DatasetProvisioner.provision(client(), CMD);
        assertRows(
        }  
    }
                + " | eval doc.user.name=doc.user.name, doc.user.age=doc.user.age"
    private static Map<String, Object> mapOf(Object... keyValuePairs) {  
     * {@link java.util.Objects#equals}.
            List<Object> want = expected[i];  
        );  
 *       The MAP column drives the ITEM-on-MAP dispatch in {@code ArrayElementAdapter},
            row("2"),
    /**
     * Assert rows match the expected sequence with row-order significance (for sort tests).
            int matchIdx = -1;  
 *  
    /**  
    public void testSimpleSpath() throws IOException {
     */
    // ── path mode ───────────────────────────────────────────────────────────────
    private final void assertRowsInOrder(String ppl, List<Object>... expected) throws IOException {
    }  
            "source=" + CMD.indexName + " | spath input=doc | stats sum(doc.user.age) by doc.user.name",  
            }  
 * <p>Provisions four small datasets ({@code spath_simple}, {@code spath_auto},
                );
     * order in the absence of an explicit {@code sort} clause.  
        );  
 * → Substrait → DataFusion pipeline as the SQL plugin's force-routed analytics path.  
        if (want.size() != got.size()) return false;
     * Integer/Long/Double interchangeably, so cell comparison goes through a  
        @SuppressWarnings("unchecked")
    private static final Dataset NULL_DATASET = new Dataset("spath_null", "spath_null");
     * Assert that a query returning a single MAP-typed column produces the expected  
    }
    }
 *   <li>Path mode — {@code spath path=N input=doc output=result} (lowers to
        // Nested objects flatten to dotted keys: user.name  
        );
        // Numbers / booleans / nulls all stringify; null renders as the literal "null".  
            Map<String, Object> em = (Map<String, Object>) expected;
            DatasetProvisioner.provision(client(), NULL_DATASET);  
        assertEquals("Row count mismatch for query: " + ppl, expected.length, actualRows.size());  
            return;
     * Lazily provision all four datasets on first invocation. Must be called inside a
                got.get(0)
        assertEquals("Row count mismatch for query: " + ppl, expected.length, actualRows.size());
        for (int i = 0; i < keyValuePairs.length; i += 2) {
        assertRows(
        if (keyValuePairs.length % 2 != 0) {
            "source=" + AUTO.indexName + " | spath input=nested_doc output=result | fields result",
        for (List<Object> want : expected) {
                got.size()
            double a = ((Number) actual).doubleValue();
            assertCellEquals(
 */
            row("John")
     * test method (not {@code setUp()}) — {@code OpenSearchRestTestCase}'s static
 * plugin), which runs the same {@code UnifiedQueryPlanner} → {@code CalciteRelNodeVisitor}
            remaining.remove(matchIdx);
            row("John"),
        assertMapRows(  
 * <ul>  
        assertNotNull("Response missing 'datarows' field for query: " + ppl, actualRows);  
     * numeric-tolerant comparator.
    @Override  
    }  
                    matchIdx = i;  
            assertEquals(
        assertRows(  
 * this file be licensed under the Apache-2.0 license or a
            mapOf("user.name", "John")  
            mapOf("n", "30", "b", "true", "x", "null")  
        // set-equality.
    }  
            m.put((String) keyValuePairs[i], keyValuePairs[i + 1]);  
        );  
    }
import org.opensearch.client.Request;
            mapOf("tags{}", "[java, sql]")
    /** {@code POST /_plugins/_ppl} and parse the JSON body. */
    public void testSpathAutoExtractDuplicateKeysMerge() throws IOException {  
import org.opensearch.client.Response;  
                want.size(),
        // First row: doc parses to {n:1}. Second row: doc is null → null map.
        );
        if (expected instanceof Number && actual instanceof Number) {  
        }  
                    am.get(entry.getKey())
    }
        assertEquals(message, expected, actual);  
                );  
    public void testSpathAutoExtractWithSeparateEvalCommands() throws IOException {
        );
            List<Object> got = actualRows.get(i);
     * sequence of maps (one map per row). Use {@code null} as an expected element to
            DatasetProvisioner.provision(client(), SIMPLE);  
            Map<String, Object> am = (Map<String, Object>) actual;  
            mapOf("n", "2"),
    private static List<Object> row(Object... values) {
            for (Map.Entry<String, Object> entry : em.entrySet()) {  
            row("Alice"),  
        assertMapRows(  
            "source=" + SIMPLE.indexName + " | spath input=doc output=result",
        return m;
    }
    public void testSpathAutoExtractWithMultiFieldEval() throws IOException {
                + " | eval doc.user.age=doc.user.age"
        );
        // Two dotted-path assignments in a single eval (issue #5185 regression).  
                if (rowsEqual(want, remaining.get(i))) {
            if (Double.compare(e, a) != 0) {  
            );
            DatasetProvisioner.provision(client(), AUTO);
    }
        // EQUALS on a MAP-column expression goes through the FieldType.MAP filter
            "source=" + CMD.indexName + " | spath input=doc"  
    }  
        );
                    "Cell mismatch at row " + i + ", col " + j + " for query: " + ppl,  
 *       {@code json_extract_all(doc)} which returns a {@code MAP<VARCHAR, VARCHAR>}).
 * <p>Exercises both spath modes:
        );
                matchIdx >= 0  
 * </ul>
            } catch (AssertionError ae) {  
    public void testSpathAutoExtractMalformedJson() throws IOException {  
        }
    @SuppressWarnings("varargs")
     * reliably available inside test bodies.
/*  
     * Numeric-tolerant cell comparison. Numbers cross-compare via {@code doubleValue()};  
    }
     */
        for (int i = 0; i < expected.length; i++) {
        @SuppressWarnings("unchecked")
            null  
    /**
    }
    }
            assertEquals(message, expected, actual);  
 * Self-contained integration test for PPL {@code spath} on the analytics-engine route.
        if (expected instanceof Map && actual instanceof Map) {
        // Arrays use {} suffix; merged values use [a, b, c] format
                want,  
                new java.util.HashSet<>(em.keySet()),  
            mapOf("n", "3")  
     * Assert rows match the expected sequence. JSON parsing turns numbers into
 * compatible open source license.
            throw new IllegalArgumentException("mapOf requires an even number of arguments");
                assertCellEquals("rowsEqual", want.get(i), got.get(i));
}
    private static boolean dataProvisioned = false;
