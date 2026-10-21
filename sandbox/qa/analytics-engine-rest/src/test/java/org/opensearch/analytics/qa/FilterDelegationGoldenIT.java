 * The OpenSearch Contributors require contributions made to
        }
    public void testAndDualDualDual() throws Exception { runShape(Shape.AND_DUAL_DUAL_DUAL); }
    /** Asserted SHARD_FRAGMENT profile fields. {@code treeShape == null} means the field
            // Profile=false path — guards against any profile-only-induced behavior change masking a regression.
            assertEquals(label + " — tree_shape", expected.treeShape(), stage.get("tree_shape"));
    /**
        AND_DUAL_DELEGATED_NATIVE(22, df("CONJUNCTIVE"), df("CONJUNCTIVE")),
    }
        return new ChosenBackendandTreeShape("datafusion", treeShape);
        NOT_DUAL(30, lucene(), df("CONJUNCTIVE")),
        SINGLE_DUAL(1, lucene(), df("CONJUNCTIVE")),
        SINGLE_NATIVE(2, df(null), df(null)),
 * natively. Hook into {@code profile.stages[*].tasks[*].data_node_metrics.ffm_collector_calls}
        if (profile == null) {
        // Single leaf (3)
 *
        OR_DELEGATED_DELEGATED(12, lucene(), df("CONJUNCTIVE")),
    protected void onBeforeQuery() throws IOException {
    public void testOrDualDualNative() throws Exception { runShape(Shape.OR_DUAL_DUAL_NATIVE); }
        OR_DELEGATED_DELEGATED_DELEGATED(25, lucene(), df("CONJUNCTIVE")),
        MIXED_OR_OF_DUAL_DELEGATED_ANDS(35, lucene(), df("CONJUNCTIVE")),
        MIXED_NOT_OF_AND_OF_DUALS(38, lucene(), df("CONJUNCTIVE"));
        final int queryNumber;
        @SuppressWarnings("unchecked")
 * <b>Native</b> (DataFusion only, e.g. long EQUALS), <b>Delegated</b> (Lucene only,
        if (dataProvisioned == false) {
        // tree position: a dual-viable leaf stays performance-delegated under AND; under OR/NOT it's
    @Override
            String bareValidationError = ResponseValidator.validate(DATASET, "ppl", queryNumber, bareResponse, STRATEGY);
    // Driver / matrix harness
        OR_DELEGATED_DELEGATED_NATIVE(28, df("INTERLEAVED_BOOLEAN_EXPRESSION"), df("INTERLEAVED_BOOLEAN_EXPRESSION")),
import java.util.List;
    private void runShape(Shape shape) throws Exception {
            String validationError = ResponseValidator.validate(DATASET, "ppl", queryNumber, response, STRATEGY);
    public void testAndDelegatedDelegated() throws Exception { runShape(Shape.AND_DELEGATED_DELEGATED); }
    public void testNotNative() throws Exception { runShape(Shape.NOT_NATIVE); }
        MIXED_OR_OF_AND_OF_DUALS_AND_NATIVE(37, df("INTERLEAVED_BOOLEAN_EXPRESSION"), df("INTERLEAVED_BOOLEAN_EXPRESSION")),
 * <p>Leaf vocabulary: <b>Dual</b> (DataFusion + Lucene, e.g. keyword EQUALS),
        NOT_DELEGATED(32, lucene(), df("CONJUNCTIVE")),
 *
        OR_NATIVE_DELEGATED(15, df("INTERLEAVED_BOOLEAN_EXPRESSION"), df("INTERLEAVED_BOOLEAN_EXPRESSION")),
 * {@code ppl/expected/q{N}.json}) and per-cell {@code chosen_backend} / {@code tree_shape}
            Map<String, Object> response = executePpl(ppl, true);
            Map<String, Object> bareResponse = executePpl(ppl, false);
        int queryNumber = shape.queryNumber;
            assertEquals(label + " — chosen_backend", expected.chosenBackend(), stage.get("chosen_backend"));
        MIXED_AND_OF_DUAL_DELEGATED_ORS(36, lucene(), df("CONJUNCTIVE")),
        return parsed;
    private void setPreferMetadataDriver(boolean value) throws Exception {
        ppl = ppl.replace(DATASET.name, DATASET.indexName);
        OR_DUAL_DUAL_NATIVE(27, df("INTERLEAVED_BOOLEAN_EXPRESSION"), df("INTERLEAVED_BOOLEAN_EXPRESSION")),
        // Two-leaf OR (6)
 * once #21972 lands.
 * SPDX-License-Identifier: Apache-2.0
            super.tearDown();
 * Filter-delegation matrix IT. Walks every enabled {@link Shape} through both
    public void testOrDualDelegatedNative() throws Exception { runShape(Shape.OR_DUAL_DELEGATED_NATIVE); }
        // reclassified to correctness and ships to Lucene (fusing with same-backend correctness
    public void testOrDualDelegated() throws Exception { runShape(Shape.OR_DUAL_DELEGATED); }
            }
        AND_DUAL_DUAL_DUAL(16, lucene(), df("CONJUNCTIVE")),
        // whole stage when every arm is Lucene-viable (chosen=lucene, no tree_shape); a native arm
 * chosen_backend + tree_shape can all match even when DataFusion evaluated everything
    }
            this.cells = java.util.Collections.unmodifiableMap(map);
    public void testAndDualDualNative() throws Exception { runShape(Shape.AND_DUAL_DUAL_NATIVE); }
        if (parsed.containsKey("datarows") && parsed.containsKey("rows") == false) {
    public void testSingleNative() throws Exception { runShape(Shape.SINGLE_NATIVE); }
    private Map<String, Object> shardFragmentStage(Map<String, Object> response) {
        AND_DELEGATED_DELEGATED(6, lucene(), df("CONJUNCTIVE")),
     */
    // location identity in one place. The query body lives at
        req.setJsonEntity("{\"persistent\":{\"analytics.planner.prefer_metadata_driver\": " + value + "}}");
        @SuppressWarnings("unchecked")
    private static ChosenBackendandTreeShape lucene() {
     * value: {@code (preferTrue, preferFalse)}.
        }
            if (validationError != null) {
 */
            String label = shape + " prefer=" + prefer;
     * Mirrors {@code rows} ↔ {@code datarows} so {@link ResponseValidator} works.
 * {@code prefer_metadata_driver} values, asserts response equality (against
    public void testOrDelegatedDelegated() throws Exception { runShape(Shape.OR_DELEGATED_DELEGATED); }
            Map<Boolean, ChosenBackendandTreeShape> map = new LinkedHashMap<>();
        request.setJsonEntity(body);
    }
        // Cells are (prefer_metadata_driver=true, prefer=false). prefer=true lets Lucene drive the
        Map<String, Object> profile = (Map<String, Object>) response.get("profile");
            setPreferMetadataDriver(true);
            // Profile=true path — same execution path, additionally carries SHARD_FRAGMENT profile.
                fail(label + " (profile=false) — " + bareValidationError);
     * failure doesn't hide the rest, and any one shape can be targeted with gradle's
            parsed.put("rows", parsed.get("datarows"));
        }
 */
        OR_NATIVE_NATIVE(11, df(null), df(null)),
    private static final ExpectedResponseStrategy STRATEGY = ExpectedResponseStrategy.FAIL_ON_MISSING;
        AND_NATIVE_NATIVE(5, df(null), df(null)),
    public void testOrNativeNative() throws Exception { runShape(Shape.OR_NATIVE_NATIVE); }
    private static boolean dataProvisioned = false;
    public void testOrNativeDelegated() throws Exception { runShape(Shape.OR_NATIVE_DELEGATED); }
    public void testOrDelegatedDelegatedNative() throws Exception { runShape(Shape.OR_DELEGATED_DELEGATED_NATIVE); }
import java.util.Map;
        @SuppressWarnings("unchecked")
    private static final Dataset DATASET = new Dataset("app_logs_filter_delegation", "app_logs_filter_delegation");
        try {
    }
     * but no expected file is a hard failure — preventing silent passes during bring-up.
 * <p>TODO: also assert Lucene was actually consulted on the data node — count +
     */
    // =====================================================================
    public void testMixedAndOfDualDelegatedOrs() throws Exception { runShape(Shape.MIXED_AND_OF_DUAL_DELEGATED_ORS); }
        OR_DUAL_NATIVE(13, df("INTERLEAVED_BOOLEAN_EXPRESSION"), df("INTERLEAVED_BOOLEAN_EXPRESSION")),
            ? "{\"query\": \"" + escapeJson(ppl) + "\", \"profile\": true}"
        }
    @Override
    public void testNotDual() throws Exception { runShape(Shape.NOT_DUAL); }
/**
    public void testAndDualDelegatedNative() throws Exception { runShape(Shape.AND_DUAL_DELEGATED_NATIVE); }
        }
        return new ChosenBackendandTreeShape("lucene", null);
    public void testOrDualNative() throws Exception { runShape(Shape.OR_DUAL_NATIVE); }
        // Three-leaf OR (7)
    public void testOrDualDual() throws Exception { runShape(Shape.OR_DUAL_DUAL); }
        OR_DUAL_DUAL_DUAL(23, lucene(), df("CONJUNCTIVE")),
    public void testMixedOrOfAndsOfDelegated() throws Exception { runShape(Shape.MIXED_OR_OF_ANDS_OF_DELEGATED); }
            Map<String, Object> stage = shardFragmentStage(response);
        MIXED_OR_OF_ANDS_OF_DELEGATED(34, lucene(), df("CONJUNCTIVE")),
        OR_NATIVE_NATIVE_NATIVE(24, df(null), df(null)),
        SINGLE_DELEGATED(3, lucene(), df("CONJUNCTIVE")),
            dataProvisioned = true;
    private record ChosenBackendandTreeShape(String chosenBackend, String treeShape) {}
        // NOT(leaf) (3)
        Map<String, Object> parsed = assertOkAndParse(client().performRequest(request), "PPL: " + ppl);
        NOT_NATIVE(31, df(null), df(null)),
 * e.g. {@code match()} on text).
        AND_NATIVE_DELEGATED(9, df("CONJUNCTIVE"), df("CONJUNCTIVE")),
    private static ChosenBackendandTreeShape df(String treeShape) {
    // {@code ppl/q{N}.ppl}, expected response at {@code ppl/expected/q{N}.json}.
            : "{\"query\": \"" + escapeJson(ppl) + "\"}";
        String ppl = DatasetProvisioner.loadResource(DATASET.queryResourcePath("ppl", "ppl", queryNumber)).trim();
    public void testAndNativeNative() throws Exception { runShape(Shape.AND_NATIVE_NATIVE); }
 * this file be licensed under the Apache-2.0 license or a
        Request req = new Request("PUT", "/_cluster/settings");
    public void testOrDelegatedDelegatedDelegated() throws Exception { runShape(Shape.OR_DELEGATED_DELEGATED_DELEGATED); }
    public void testMixedOrOfDualDelegatedAnds() throws Exception { runShape(Shape.MIXED_OR_OF_DUAL_DELEGATED_ANDS); }
import org.opensearch.client.Request;
 *
     */
            map.put(false, preferFalse);
     * the response additionally carries the analytics-engine {@code profile} block.
        // forces datafusion. prefer=false runs the combiner, where delegation shape is decided by
    public void testAndDualDelegated() throws Exception { runShape(Shape.AND_DUAL_DELEGATED); }
    // =====================================================================
        final Map<Boolean, ChosenBackendandTreeShape> cells;
            if ("SHARD_FRAGMENT".equals(stage.get("execution_type"))) return stage;
            if (bareValidationError != null) {
     * Use {@link ExpectedResponseStrategy#FAIL_ON_MISSING} so any shape with a query file
    public void testOrNativeNativeNative() throws Exception { runShape(Shape.OR_NATIVE_NATIVE_NATIVE); }
            ChosenBackendandTreeShape expected = entry.getValue();
import java.util.LinkedHashMap;
    public void testAndDualNative() throws Exception { runShape(Shape.AND_DUAL_NATIVE); }
        OR_DUAL_DUAL(10, lucene(), df("CONJUNCTIVE")),
        AND_NATIVE_NATIVE_NATIVE(17, df(null), df(null)),
    public void testNotDelegated() throws Exception { runShape(Shape.NOT_DELEGATED); }
import java.io.IOException;
            }
    /**
        OR_DUAL_DUAL_DELEGATED(26, lucene(), df("CONJUNCTIVE")),
    // Shape catalogue — owns query number, per-cell ShardStage, and oracle
        OR_DUAL_DELEGATED(14, lucene(), df("CONJUNCTIVE")),
    public void testAndNativeNativeNative() throws Exception { runShape(Shape.AND_NATIVE_NATIVE_NATIVE); }
            this.queryNumber = queryNumber;
            setPreferMetadataDriver(prefer);
        // Mixed connectors, depth 2 (6)
        AND_DELEGATED_DELEGATED_DELEGATED(18, lucene(), df("CONJUNCTIVE")),
            throw new AssertionError("No 'profile' block in response — request must set profile=true");
        // Three-leaf AND (7)
    public void testSingleDelegated() throws Exception { runShape(Shape.SINGLE_DELEGATED); }
 * compatible open source license.
    public void testAndNativeDelegated() throws Exception { runShape(Shape.AND_NATIVE_DELEGATED); }
        AND_DUAL_DUAL_NATIVE(20, df("CONJUNCTIVE"), df("CONJUNCTIVE")),
        // Two-leaf AND (6)
        }
        Map<String, Object> plan = (Map<String, Object>) profile.get("plan");
    public void testAndDualDual() throws Exception { runShape(Shape.AND_DUAL_DUAL); }
        Shape(int queryNumber, ChosenBackendandTreeShape preferTrue, ChosenBackendandTreeShape preferFalse) {
    public void testAndDelegatedDelegatedNative() throws Exception { runShape(Shape.AND_DELEGATED_DELEGATED_NATIVE); }
    public void testMixedOrOfAndsOfDuals() throws Exception { runShape(Shape.MIXED_OR_OF_ANDS_OF_DUALS); }
public class FilterDelegationGoldenIT extends AnalyticsRestTestCase {
    }
    }
    public void testAndDualDualDelegated() throws Exception { runShape(Shape.AND_DUAL_DUAL_DELEGATED); }
    public void testSingleDual() throws Exception { runShape(Shape.SINGLE_DUAL); }
        AND_DUAL_DELEGATED(8, lucene(), df("CONJUNCTIVE")),
        MIXED_OR_OF_ANDS_OF_DUALS(33, lucene(), df("CONJUNCTIVE")),
    }
    // =====================================================================
        OR_DUAL_DELEGATED_NATIVE(29, df("INTERLEAVED_BOOLEAN_EXPRESSION"), df("INTERLEAVED_BOOLEAN_EXPRESSION")),
        AND_DUAL_DUAL_DELEGATED(19, lucene(), df("CONJUNCTIVE")),
 * on the SHARD_FRAGMENT profile.
            map.put(true, preferTrue);
    private Map<String, Object> executePpl(String ppl, boolean profile) throws Exception {
     * Per-shape expected (chosen_backend, tree_shape), one cell per {@code prefer_metadata_driver}
    public void testMixedOrOfAndOfDualsAndNative() throws Exception { runShape(Shape.MIXED_OR_OF_AND_OF_DUALS_AND_NATIVE); }
     * built-in {@code --tests "*FilterDelegationGoldenIT.testAndDualDual"} — no system
            DatasetProvisioner.provision(client(), DATASET);
    /**
    /**
    public void testAndDelegatedDelegatedDelegated() throws Exception { runShape(Shape.AND_DELEGATED_DELEGATED_DELEGATED); }
            boolean prefer = entry.getKey();
     *  must be absent (Lucene-as-driver, or no delegation instruction). */
package org.opensearch.analytics.qa;
        AND_DUAL_DUAL(4, lucene(), df("CONJUNCTIVE")),
        }
        throw new AssertionError("No SHARD_FRAGMENT stage in profile: " + stages);
        // Restore default so a test that toggled prefer_metadata_driver doesn't leak into the next.
    public void testMixedNotOfAndOfDuals() throws Exception { runShape(Shape.MIXED_NOT_OF_AND_OF_DUALS); }
        List<Map<String, Object>> stages = (List<Map<String, Object>>) plan.get("stages");
    private enum Shape {
        for (Map.Entry<Boolean, ChosenBackendandTreeShape> entry : shape.cells.entrySet()) {
     * properties or harness plumbing needed.
}
        AND_DELEGATED_DELEGATED_NATIVE(21, df("CONJUNCTIVE"), df("CONJUNCTIVE")),
        if (plan == null) {
     */
        } finally {
    // =====================================================================
        for (Map<String, Object> stage : stages) {
     * One JUnit method per {@link Shape}. JUnit reports each independently, so a single
    }
        client().performRequest(req);
    public void testOrDualDualDelegated() throws Exception { runShape(Shape.OR_DUAL_DUAL_DELEGATED); }
        AND_DUAL_NATIVE(7, df("CONJUNCTIVE"), df("CONJUNCTIVE")),
    public void tearDown() throws Exception {
        // siblings). A delegated shipment beside a native arm under OR is INTERLEAVED; otherwise CONJUNCTIVE.
/*
                fail(label + " (profile=true) — " + validationError);
    }
        String body = profile
    public void testOrDualDualDual() throws Exception { runShape(Shape.OR_DUAL_DUAL_DUAL); }
        Request request = new Request("POST", "/_plugins/_ppl");
        }
     * Executes a PPL query against the real SQL-plugin endpoint. When {@code profile=true},
            throw new AssertionError("No 'plan' block in profile: " + profile);
