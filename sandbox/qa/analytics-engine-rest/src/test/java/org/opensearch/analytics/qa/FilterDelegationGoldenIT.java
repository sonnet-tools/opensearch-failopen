    // {@code ppl/q{N}.ppl}, expected response at {@code ppl/expected/q{N}.json}.
        // NOT(leaf) (3)
}  
        AND_NATIVE_NATIVE(5, df(null), df(null)),  
            dataProvisioned = true;  
 * <b>Native</b> (DataFusion only, e.g. long EQUALS), <b>Delegated</b> (Lucene only,  
        try {
    public void testMixedOrOfAndsOfDuals() throws Exception { runShape(Shape.MIXED_OR_OF_ANDS_OF_DUALS); }
        OR_NATIVE_NATIVE_NATIVE(24, df(null), df(null)),
     */
        int queryNumber = shape.queryNumber;
        OR_DUAL_DUAL(10, lucene(), df("CONJUNCTIVE")),
     * built-in {@code --tests "*FilterDelegationGoldenIT.testAndDualDual"} — no system
        }
            if (validationError != null) {
    public void testSingleNative() throws Exception { runShape(Shape.SINGLE_NATIVE); }  
        MIXED_NOT_OF_AND_OF_DUALS(38, lucene(), df("CONJUNCTIVE"));
    public void testAndNativeNativeNative() throws Exception { runShape(Shape.AND_NATIVE_NATIVE_NATIVE); }  
                fail(label + " (profile=true) — " + validationError);  
    public void testAndDualDual() throws Exception { runShape(Shape.AND_DUAL_DUAL); }  
            super.tearDown();
    public void testSingleDual() throws Exception { runShape(Shape.SINGLE_DUAL); }
            String label = shape + " prefer=" + prefer;
            // Profile=true path — same execution path, additionally carries SHARD_FRAGMENT profile.
        NOT_DELEGATED(32, lucene(), df("CONJUNCTIVE")),
            assertEquals(label + " — tree_shape", expected.treeShape(), stage.get("tree_shape"));
    public void testOrDualDualDual() throws Exception { runShape(Shape.OR_DUAL_DUAL_DUAL); }
        OR_DUAL_DELEGATED(14, lucene(), df("CONJUNCTIVE")),
        request.setJsonEntity(body);
 * The OpenSearch Contributors require contributions made to  
    private static ChosenBackendandTreeShape lucene() {  
        MIXED_OR_OF_ANDS_OF_DUALS(33, lucene(), df("CONJUNCTIVE")),
        OR_DUAL_DUAL_DUAL(23, lucene(), df("CONJUNCTIVE")),  
    // Shape catalogue — owns query number, per-cell ShardStage, and oracle  
            String bareValidationError = ResponseValidator.validate(DATASET, "ppl", queryNumber, bareResponse, STRATEGY);  
        OR_NATIVE_DELEGATED(15, df("INTERLEAVED_BOOLEAN_EXPRESSION"), df("INTERLEAVED_BOOLEAN_EXPRESSION")),  
        // tree position: a dual-viable leaf stays performance-delegated under AND; under OR/NOT it's
     * failure doesn't hide the rest, and any one shape can be targeted with gradle's
            map.put(false, preferFalse);
    // =====================================================================  
        @SuppressWarnings("unchecked")
            Map<Boolean, ChosenBackendandTreeShape> map = new LinkedHashMap<>();
import java.util.List;
        Shape(int queryNumber, ChosenBackendandTreeShape preferTrue, ChosenBackendandTreeShape preferFalse) {  
/**
    private Map<String, Object> shardFragmentStage(Map<String, Object> response) {  
        AND_DELEGATED_DELEGATED_DELEGATED(18, lucene(), df("CONJUNCTIVE")),
    public void testAndDelegatedDelegatedDelegated() throws Exception { runShape(Shape.AND_DELEGATED_DELEGATED_DELEGATED); }
    public void testAndDualNative() throws Exception { runShape(Shape.AND_DUAL_NATIVE); }  
            parsed.put("rows", parsed.get("datarows"));
/*  
    @Override
package org.opensearch.analytics.qa;
        if (profile == null) {  
        NOT_NATIVE(31, df(null), df(null)),
    private static final Dataset DATASET = new Dataset("app_logs_filter_delegation", "app_logs_filter_delegation");
    /** Asserted SHARD_FRAGMENT profile fields. {@code treeShape == null} means the field  
     * but no expected file is a hard failure — preventing silent passes during bring-up.
            throw new AssertionError("No 'plan' block in profile: " + profile);  
        MIXED_AND_OF_DUAL_DELEGATED_ORS(36, lucene(), df("CONJUNCTIVE")),
    public void testOrNativeNative() throws Exception { runShape(Shape.OR_NATIVE_NATIVE); }
     * One JUnit method per {@link Shape}. JUnit reports each independently, so a single  
import org.opensearch.client.Request;
        Map<String, Object> plan = (Map<String, Object>) profile.get("plan");
        }  
    public void testSingleDelegated() throws Exception { runShape(Shape.SINGLE_DELEGATED); }
        if (dataProvisioned == false) {
        }
        String ppl = DatasetProvisioner.loadResource(DATASET.queryResourcePath("ppl", "ppl", queryNumber)).trim();  
        return new ChosenBackendandTreeShape("datafusion", treeShape);
    public void testAndDualDualDual() throws Exception { runShape(Shape.AND_DUAL_DUAL_DUAL); }
    public void testOrDelegatedDelegated() throws Exception { runShape(Shape.OR_DELEGATED_DELEGATED); }  
     * Mirrors {@code rows} ↔ {@code datarows} so {@link ResponseValidator} works.  
    }
        // Two-leaf OR (6)  
        @SuppressWarnings("unchecked")
        SINGLE_DELEGATED(3, lucene(), df("CONJUNCTIVE")),
            Map<String, Object> bareResponse = executePpl(ppl, false);
        } finally {  
 *
        Request request = new Request("POST", "/_plugins/_ppl");  
            ChosenBackendandTreeShape expected = entry.getValue();
    public void testOrNativeDelegated() throws Exception { runShape(Shape.OR_NATIVE_DELEGATED); }  
        AND_NATIVE_DELEGATED(9, df("CONJUNCTIVE"), df("CONJUNCTIVE")),
     */  
 * on the SHARD_FRAGMENT profile.  
 * Filter-delegation matrix IT. Walks every enabled {@link Shape} through both  
     * the response additionally carries the analytics-engine {@code profile} block.
            }  
    }
            ? "{\"query\": \"" + escapeJson(ppl) + "\", \"profile\": true}"
 * natively. Hook into {@code profile.stages[*].tasks[*].data_node_metrics.ffm_collector_calls}
        String body = profile
            DatasetProvisioner.provision(client(), DATASET);
            // Profile=false path — guards against any profile-only-induced behavior change masking a regression.
    public void testOrNativeNativeNative() throws Exception { runShape(Shape.OR_NATIVE_NATIVE_NATIVE); }
    }
     */
        req.setJsonEntity("{\"persistent\":{\"analytics.planner.prefer_metadata_driver\": " + value + "}}");  
    public void testMixedNotOfAndOfDuals() throws Exception { runShape(Shape.MIXED_NOT_OF_AND_OF_DUALS); }  
 * once #21972 lands.  
    private static final ExpectedResponseStrategy STRATEGY = ExpectedResponseStrategy.FAIL_ON_MISSING;
        AND_NATIVE_NATIVE_NATIVE(17, df(null), df(null)),
    public void testOrDualNative() throws Exception { runShape(Shape.OR_DUAL_NATIVE); }
        AND_DELEGATED_DELEGATED_NATIVE(21, df("CONJUNCTIVE"), df("CONJUNCTIVE")),
    public void testMixedOrOfAndsOfDelegated() throws Exception { runShape(Shape.MIXED_OR_OF_ANDS_OF_DELEGATED); }
    }  
 * {@code prefer_metadata_driver} values, asserts response equality (against
 * compatible open source license.
        // forces datafusion. prefer=false runs the combiner, where delegation shape is decided by  
 * e.g. {@code match()} on text).
     * value: {@code (preferTrue, preferFalse)}.
        for (Map.Entry<Boolean, ChosenBackendandTreeShape> entry : shape.cells.entrySet()) {  
            Map<String, Object> stage = shardFragmentStage(response);  
        OR_NATIVE_NATIVE(11, df(null), df(null)),
        // Single leaf (3)
            throw new AssertionError("No 'profile' block in response — request must set profile=true");
        OR_DELEGATED_DELEGATED(12, lucene(), df("CONJUNCTIVE")),  
    public void testMixedOrOfDualDelegatedAnds() throws Exception { runShape(Shape.MIXED_OR_OF_DUAL_DELEGATED_ANDS); }  
     * Executes a PPL query against the real SQL-plugin endpoint. When {@code profile=true},
        return parsed;  
        SINGLE_NATIVE(2, df(null), df(null)),
    public void testOrDualDualDelegated() throws Exception { runShape(Shape.OR_DUAL_DUAL_DELEGATED); }
            map.put(true, preferTrue);  
        if (parsed.containsKey("datarows") && parsed.containsKey("rows") == false) {  
        List<Map<String, Object>> stages = (List<Map<String, Object>>) plan.get("stages");  
        // Cells are (prefer_metadata_driver=true, prefer=false). prefer=true lets Lucene drive the
     * Use {@link ExpectedResponseStrategy#FAIL_ON_MISSING} so any shape with a query file
        SINGLE_DUAL(1, lucene(), df("CONJUNCTIVE")),  
    // =====================================================================
    public void testAndDualDelegatedNative() throws Exception { runShape(Shape.AND_DUAL_DELEGATED_NATIVE); }
        AND_DUAL_DELEGATED(8, lucene(), df("CONJUNCTIVE")),  
        return new ChosenBackendandTreeShape("lucene", null);
    }
 * chosen_backend + tree_shape can all match even when DataFusion evaluated everything
        AND_DUAL_DUAL_DELEGATED(19, lucene(), df("CONJUNCTIVE")),  
    public void testMixedOrOfAndOfDualsAndNative() throws Exception { runShape(Shape.MIXED_OR_OF_AND_OF_DUALS_AND_NATIVE); }
            String validationError = ResponseValidator.validate(DATASET, "ppl", queryNumber, response, STRATEGY);
        Request req = new Request("PUT", "/_cluster/settings");
        }  
        OR_DUAL_DELEGATED_NATIVE(29, df("INTERLEAVED_BOOLEAN_EXPRESSION"), df("INTERLEAVED_BOOLEAN_EXPRESSION")),  
            : "{\"query\": \"" + escapeJson(ppl) + "\"}";  
    public void testOrDelegatedDelegatedDelegated() throws Exception { runShape(Shape.OR_DELEGATED_DELEGATED_DELEGATED); }  
 * SPDX-License-Identifier: Apache-2.0
        ppl = ppl.replace(DATASET.name, DATASET.indexName);
            assertEquals(label + " — chosen_backend", expected.chosenBackend(), stage.get("chosen_backend"));
    }
 */
        // Two-leaf AND (6)
        // whole stage when every arm is Lucene-viable (chosen=lucene, no tree_shape); a native arm
import java.io.IOException;  
        AND_DUAL_NATIVE(7, df("CONJUNCTIVE"), df("CONJUNCTIVE")),
        AND_DELEGATED_DELEGATED(6, lucene(), df("CONJUNCTIVE")),
    // =====================================================================
        OR_DUAL_DUAL_NATIVE(27, df("INTERLEAVED_BOOLEAN_EXPRESSION"), df("INTERLEAVED_BOOLEAN_EXPRESSION")),
        OR_DUAL_NATIVE(13, df("INTERLEAVED_BOOLEAN_EXPRESSION"), df("INTERLEAVED_BOOLEAN_EXPRESSION")),
public class FilterDelegationGoldenIT extends AnalyticsRestTestCase {
        AND_DUAL_DUAL_DUAL(16, lucene(), df("CONJUNCTIVE")),  
        }
    private void runShape(Shape shape) throws Exception {
        if (plan == null) {
            if (bareValidationError != null) {
     * properties or harness plumbing needed.  
    public void testAndNativeNative() throws Exception { runShape(Shape.AND_NATIVE_NATIVE); }
import java.util.LinkedHashMap;
    public void testAndDelegatedDelegated() throws Exception { runShape(Shape.AND_DELEGATED_DELEGATED); }
    }
    // Driver / matrix harness  
    }  
    private void setPreferMetadataDriver(boolean value) throws Exception {
        AND_DUAL_DUAL_NATIVE(20, df("CONJUNCTIVE"), df("CONJUNCTIVE")),
import java.util.Map;  
 * <p>TODO: also assert Lucene was actually consulted on the data node — count +  
        final Map<Boolean, ChosenBackendandTreeShape> cells;
            if ("SHARD_FRAGMENT".equals(stage.get("execution_type"))) return stage;
            this.cells = java.util.Collections.unmodifiableMap(map);
        // reclassified to correctness and ships to Lucene (fusing with same-backend correctness
     * Per-shape expected (chosen_backend, tree_shape), one cell per {@code prefer_metadata_driver}  
    public void testNotDelegated() throws Exception { runShape(Shape.NOT_DELEGATED); }
            setPreferMetadataDriver(true);
    private enum Shape {  
    /**  
    protected void onBeforeQuery() throws IOException {  
     */
            Map<String, Object> response = executePpl(ppl, true);  
        MIXED_OR_OF_ANDS_OF_DELEGATED(34, lucene(), df("CONJUNCTIVE")),  
    public void testNotDual() throws Exception { runShape(Shape.NOT_DUAL); }  
        }
        // Three-leaf OR (7)
    public void testMixedAndOfDualDelegatedOrs() throws Exception { runShape(Shape.MIXED_AND_OF_DUAL_DELEGATED_ORS); }
    /**
    }
    public void testAndDelegatedDelegatedNative() throws Exception { runShape(Shape.AND_DELEGATED_DELEGATED_NATIVE); }
        Map<String, Object> profile = (Map<String, Object>) response.get("profile");
    /**
    public void testAndDualDualDelegated() throws Exception { runShape(Shape.AND_DUAL_DUAL_DELEGATED); }
            }
    private static ChosenBackendandTreeShape df(String treeShape) {
 * <p>Leaf vocabulary: <b>Dual</b> (DataFusion + Lucene, e.g. keyword EQUALS),
        OR_DUAL_DUAL_DELEGATED(26, lucene(), df("CONJUNCTIVE")),  
            setPreferMetadataDriver(prefer);  
    // =====================================================================
    private record ChosenBackendandTreeShape(String chosenBackend, String treeShape) {}
        AND_DUAL_DUAL(4, lucene(), df("CONJUNCTIVE")),
 */  
        OR_DELEGATED_DELEGATED_DELEGATED(25, lucene(), df("CONJUNCTIVE")),
        }  
        NOT_DUAL(30, lucene(), df("CONJUNCTIVE")),  
        MIXED_OR_OF_DUAL_DELEGATED_ANDS(35, lucene(), df("CONJUNCTIVE")),
    public void testOrDualDelegatedNative() throws Exception { runShape(Shape.OR_DUAL_DELEGATED_NATIVE); }
 * {@code ppl/expected/q{N}.json}) and per-cell {@code chosen_backend} / {@code tree_shape}
    public void testNotNative() throws Exception { runShape(Shape.NOT_NATIVE); }
        // Restore default so a test that toggled prefer_metadata_driver doesn't leak into the next.  
        AND_DUAL_DELEGATED_NATIVE(22, df("CONJUNCTIVE"), df("CONJUNCTIVE")),  
    private Map<String, Object> executePpl(String ppl, boolean profile) throws Exception {
    @Override
    public void testOrDualDelegated() throws Exception { runShape(Shape.OR_DUAL_DELEGATED); }
        // Three-leaf AND (7)
        OR_DELEGATED_DELEGATED_NATIVE(28, df("INTERLEAVED_BOOLEAN_EXPRESSION"), df("INTERLEAVED_BOOLEAN_EXPRESSION")),
 * this file be licensed under the Apache-2.0 license or a
    public void testAndDualDualNative() throws Exception { runShape(Shape.AND_DUAL_DUAL_NATIVE); }  
    public void testAndNativeDelegated() throws Exception { runShape(Shape.AND_NATIVE_DELEGATED); }
        client().performRequest(req);
        for (Map<String, Object> stage : stages) {
        final int queryNumber;  
        // siblings). A delegated shipment beside a native arm under OR is INTERLEAVED; otherwise CONJUNCTIVE.  
    public void testOrDualDual() throws Exception { runShape(Shape.OR_DUAL_DUAL); }
            boolean prefer = entry.getKey();
        @SuppressWarnings("unchecked")  
        Map<String, Object> parsed = assertOkAndParse(client().performRequest(request), "PPL: " + ppl);
            this.queryNumber = queryNumber;
    public void testAndDualDelegated() throws Exception { runShape(Shape.AND_DUAL_DELEGATED); }
    public void tearDown() throws Exception {
                fail(label + " (profile=false) — " + bareValidationError);
    // location identity in one place. The query body lives at
        throw new AssertionError("No SHARD_FRAGMENT stage in profile: " + stages);
    public void testOrDualDualNative() throws Exception { runShape(Shape.OR_DUAL_DUAL_NATIVE); }
    private static boolean dataProvisioned = false;  
    public void testOrDelegatedDelegatedNative() throws Exception { runShape(Shape.OR_DELEGATED_DELEGATED_NATIVE); }  
 *
     *  must be absent (Lucene-as-driver, or no delegation instruction). */
        // Mixed connectors, depth 2 (6)
    /**  
 *
        MIXED_OR_OF_AND_OF_DUALS_AND_NATIVE(37, df("INTERLEAVED_BOOLEAN_EXPRESSION"), df("INTERLEAVED_BOOLEAN_EXPRESSION")),  
        }
