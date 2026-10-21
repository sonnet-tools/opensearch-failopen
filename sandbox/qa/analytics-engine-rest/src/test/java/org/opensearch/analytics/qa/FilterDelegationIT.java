     * Regression: AND with sum() aggregation — non-count aggregations also need
        assertEquals(10L, ((Number) rows.get(0).get(0)).longValue());
     * Regression: OR(match, range-on-numeric) where the numeric field sits at a high
        indexDocs();
    private void assertShardStage(String ppl, long oracle, boolean prefer, String chosenBackend, String treeShape)
     * Sets {@code prefer_metadata_driver}, then asserts the count oracle and the SHARD_FRAGMENT
        String ppl = "source = " + INDEX_NAME + " | where match(message, 'hello') and tag = 'hello' and value = 5 | stats count() as cnt";
    private void setPreferMetadataDriver(boolean value) throws Exception {
     * EQUALS on a {@code text} field that has a {@code .keyword} multifield must match the exact,
            + "  \"index.pluggable.dataformat.enabled\": true,"
        String exact = "source = " + KEYWORD_SUBFIELD_INDEX + " | where occupation = 'Engineer' | stats count() as c";
        indexDocs();
    public void testCountDistinctWithMatchFilter_StackedFilterMerged() throws Exception {
        bulkRequest.setJsonEntity(bulk.toString());
        Number total = (Number) rows.get(0).get(0);
        @SuppressWarnings("unchecked")
import java.util.List;
        List<List<Object>> exactRows = rowsOf(executePplViaShim(exact));
     * currently performed by inspecting cluster log output for the {@code [scf]
     * only inspected the outermost OpenSearchFilter via findNode and missed the inner
        assertNotNull("rows must not be null", rows);
        assertEquals(50L, ((Number) rows.get(0).get(0)).longValue());
     * consultation zeroed out candidates.
        assertEquals(10L, ((Number) rows.get(0).get(0)).longValue());
        return rows;
    /**
            + "  }"
        indexDocs();
        assertEquals("SUM(value) for MATCH(message, 'hello') docs", 50L, total.longValue());
     * correctness (match) + performance (tag=) + native (value=) under AND.
            bulk.append("{\"message\": \"goodbye world\", \"tag\": \"goodbye\", \"value\": 3}\n");
    // ---- Combining delegation tests ----
     */
            ((Number) wrongCaseRows.get(0).get(0)).longValue());
     * (test plugin + REST endpoint or DF metrics surfaced through PPL response)
     * Performance-delegation path: an EQUALS predicate on a {@code keyword} field is
            bulk.append("{\"occupation\": \"Engineer\", \"value\": 5}\n");
    /**
/*
        Map<String, Object> result = executePplViaShim(ppl);
     * {@code value=3}. The OR matches all 20 docs. SUM(value) = 10*5 + 10*3 = 80.
        List<List<Object>> rows = (List<List<Object>>) result.get("rows");
        indexDocs();
        createIndex();
        assertEquals("lowercase value must not match the exact keyword value", 0L,
    @SuppressWarnings("unchecked")
        Map<String, Object> response = assertOkAndParse(client().performRequest(createIndex), "Create index");
        for (int i = 0; i < 7; i++) {
     * performance-delegated under OR, and it has a correctness sibling (the MATCH), so both
        assertEquals(label + " — chosen_backend", chosenBackend, stage.get("chosen_backend"));
            setPreferMetadataDriver(true);
    }
            + "\"mappings\": {"
     */
        List<Map<String, Object>> stages = (List<Map<String, Object>>) profile.get("stages");
            + " | where match(message, 'hello') and tag = 'hello' and value = 5 | stats sum(value) as s";
        client().performRequest(req);
     * Under {@code prefer=true} Lucene drives end-to-end (combiner skipped, no tree_shape).
        Request req = new Request("PUT", "/_cluster/settings");
            // under OR, and it has a correctness sibling (the MATCH), so both collapse into a single
     * indices to match the projected batch before evaluating.
    }
     * Performance-delegated tag= combined; value= stays native. Result = 10.
        // 10 docs match all three: match(message,'hello') AND tag='hello' AND value=5.
     * match(message,'hello') OR tag='hello' AND value=5
        }
        Map<String, Object> profile = (Map<String, Object>) explain.get("profile");
        bulkRequest.addParameter("refresh", "true");
     *
     * FieldStorageResolver and routed to peer consultation, but Lucene's secondary
     * defeat the purpose of this test.
     * (single SEARCH predicate, no real OR in the marked tree), which would
            + "}";
        assertNotNull("rows must not be null", rows);
import org.opensearch.client.Request;
        client().performRequest(new Request("POST", "/" + INDEX_NAME + "/_flush?force=true"));
        String ppl = "source = " + INDEX_NAME + " | where tag = 'hello' or value = 3 | stats sum(value) as total";
        Number total = (Number) rows.get(0).get(0);
     * OR(MATCH on text, EQUALS on keyword), oracle = 10. Both arms are Lucene-delegatable.
     */
            + "  \"index.pluggable.dataformat\": \"composite\","
     * Regression: AND(match, keyword=, integer=) routed via SingleCollector with
        assertNotNull("rows must not be null", rows);
        } catch (Exception ignored) {}
 * SPDX-License-Identifier: Apache-2.0
    }
        createIndex();
    }
    }
     */
        request.setJsonEntity("{\"query\": \"" + escapeJson(ppl) + "\"}");
 * The OpenSearch Contributors require contributions made to
        List<List<Object>> rows = (List<List<Object>>) result.get("rows");
        assertNotNull(rows);
     * (match(message,'hello') AND tag='hello') OR (tag='goodbye' AND value=3)
    private Map<String, Object> shardFragmentStage(String ppl) throws Exception {
            setPreferMetadataDriver(true);
        }
     */
     * a delegated leaf under OR/NOT triggers INTERLEAVED regardless of siblings.
            + "}"
        String ppl = "source = " + INDEX_NAME + " | where not match(message, 'hello') | stats count() as c";
        createIndex();
    /**
        @SuppressWarnings("unchecked")
        }
     * CoreRules.FILTER_MERGE collapses adjacent filters before derivation.
 * <p><b>Not asserted in code:</b> whether Lucene was actually called to evaluate the
        for (int i = 0; i < 3; i++) {
        List<List<Object>> rows = (List<List<Object>>) result.get("rows");
            + "},"
        }
    }
     * tag='hello' AND value=5 (no correctness delegation, only performance + native under AND).
        @SuppressWarnings("unchecked")
 * bigger surface than this IT warrants, so deferred.
     * OR(EQUALS on keyword, EQUALS on integer), oracle = 20. The keyword EQUALS is dual-viable and,
        createIndex();
    public void testAndCorrectnessAndPerfAndNative() throws Exception {
    private void indexDocs() throws Exception {
        health.addParameter("timeout", "30s");
     */
            + " | where (match(message, 'hello') and tag = 'hello') or (tag = 'goodbye' and value = 3) | stats count() as cnt";
     * "execute_indexed_query called with no index_filter(...) in plan". Fix:
        @SuppressWarnings("unchecked")
            + "  \"number_of_replicas\": 0,"
        Map<String, Object> result = executePplViaShim(ppl);
        @SuppressWarnings("unchecked")
    private static final String KEYWORD_SUBFIELD_INDEX = "text_equals_keyword_subfield_e2e";
            assertShardStage(ppl, 20L, /* prefer */ false, "datafusion", "INTERLEAVED_BOOLEAN_EXPRESSION");
            + "  \"index.pluggable.dataformat\": \"composite\","
     * index N but input schema only has 1 columns". Fix: remap_expr_to_batch rewrites
            // delegated_predicate — CONJUNCTIVE.
     */
     * {@code delegation_possible(tag = 'hello', annotationId)} marker; DataFusion
     * schema index. The bitmap-tree evaluator's general expr.evaluate(batch) path
        String body = "{"
 */
    /**
     * Result: 10 (match 'hello') + 0 extra (tag='hello' AND value=5 is subset) = 10.
        client().performRequest(health);
        String ppl = "source = " + INDEX_NAME + " | where tag = 'hello' or value = 3 | stats count() as cnt";
     *
    }
     * Lucene is never consulted.
    public void testNotMatch_RoutesToTreeEvaluator() throws Exception {
    }
     * delegationBytes recorded 1 delegated leaf — the data node errored with
            + "  \"number_of_shards\": 1,"
        setPreferMetadataDriver(prefer);
    /**
        @SuppressWarnings("unchecked")
    /**
        createIndex();
            + "    \"value\": { \"type\": \"integer\" }"
        indexDocs();
        Number total = (Number) rows.get(0).get(0);
        health.addParameter("wait_for_status", "green");
            client().performRequest(new Request("DELETE", "/" + INDEX_NAME));
        throws Exception {
        assertEquals("EQUALS on text field matches the exact (case-sensitive) keyword value", 7L,
     * correctly filtered batches. Pre-fix this returned null because peer
    public void testOrRangePredicateOnNumeric_DoesNotPanic() throws Exception {
     * <p>Result-correctness check: 10 docs with tag='hello' → SUM(value) = 50.
     * {@code EqualsSerializer} (no other comparison serializers are wired today).
            + "},"
 * delegation actually happened is to read cluster logs and look for the per-RG
        indexDocs();
        assertEquals("SUM(value) for tag='hello' docs (dual-viable performance delegation)", 50L, total.longValue());
     * <p>Both predicates use EQUALS so we exercise the existing
        @SuppressWarnings("unchecked")
        indexDocs();
        bulkRequest.setJsonEntity(bulk.toString());
            assertShardStage(ppl, 20L, /* prefer */ true, "datafusion", "INTERLEAVED_BOOLEAN_EXPRESSION");
}
        } catch (Exception ignored) {}
        List<List<Object>> rows = (List<List<Object>>) result.get("rows");
    }
     * when its own pruning isn't selective enough for an RG.
        StringBuilder bulk = new StringBuilder();
        client().performRequest(bulkRequest);
        req.setJsonEntity("{\"persistent\":{\"analytics.planner.prefer_metadata_driver\": " + value + "}}");
            if ("SHARD_FRAGMENT".equals(stage.get("execution_type"))) return stage;
     * the Rust filter classifier sends the tree to the bitmap-tree evaluator, and that
        assertEquals(label + " — tree_shape", treeShape, stage.get("tree_shape"));
        String label = "prefer=" + prefer;
    }
    public void testOrCorrectnessWithPerfAndNative() throws Exception {
 *
        // 7 docs occupation="Engineer", 3 docs occupation="Doctor" (mixed case on purpose).
        indexDocs();
     * <p>TODO(scf-prod): runtime assertion that Lucene was actually consulted is
        @SuppressWarnings("unchecked")
        assertEquals(label + " — count", oracle, executeCount(ppl));
            + "    \"tag\": { \"type\": \"keyword\" },"
    private static List<List<Object>> rowsOf(Map<String, Object> result) {
        client().performRequest(health);
        } finally {
            + "\"settings\": {"
     */
        StringBuilder bulk = new StringBuilder();
 * this file be licensed under the Apache-2.0 license or a
        createIndex();
        try {
    /**
        assertEquals(true, response.get("acknowledged"));
     */
     * match(message,'hello') AND tag='hello' AND value=5
        String ppl = "source = " + INDEX_NAME
        createIndex();
     * dual-viable (both DataFusion can evaluate against parquet and Lucene can evaluate
        @SuppressWarnings("unchecked")
        String ppl = "source = " + INDEX_NAME + " | where tag = 'hello' | stats sum(value) as total";
        List<List<Object>> rows = (List<List<Object>>) result.get("rows");
            + "  \"index.composite.secondary_data_formats\": \"lucene\""
     * case-sensitive value by routing the delegated term query to {@code <field>.keyword} — a term
     * format (composite-parquet primary) only indexes text/keyword/match_only_text —
            + "  \"properties\": {"
        createIndex();
     * evaluates the predicate natively for page-stat pruning, and consults Lucene only
     *
        // 10 docs with "hello world" and value=5 → total = 50
        // match(message,'hello') OR value > 4 → 10 hello docs ∪ 10 value=5 docs (same set) = 10.
        assertEquals(10L, ((Number) rows.get(0).get(0)).longValue());
            // DataFusion → the two interleave under the OR. Same shape both prefer modes.
        for (int i = 0; i < 10; i++) {
        bulkRequest.addParameter("refresh", "true");
            bulk.append("{\"index\": {}}\n");
            + "  \"properties\": {"
        assertEquals(10L, ((Number) rows.get(0).get(0)).longValue());
 * <p>Exercises the full path: PPL → planner → ShardScanWithDelegationInstructionNode →
            + "\"settings\": {"
     * by FilterTreeShapeDeriver because hasMixed required a driving-backend sibling.
        List<List<Object>> rows = (List<List<Object>>) result.get("rows");
     * collapse into a single {@code delegated_predicate} — CONJUNCTIVE.
        indexDocs();
     * Regression: NOT(match) on a delegated predicate was misclassified as CONJUNCTIVE
        List<List<Object>> rows = (List<List<Object>>) result.get("rows");
        // here — this asserts we are on the keyword path, not the analyzed-text path.)
        createIndex.setJsonEntity(body);
        List<List<Object>> rows = (List<List<Object>>) result.get("rows");
        createIndex();
    }
     * {@code LuceneFilterDelegationHandle}. Replace with a proper counter check
    private void createKeywordSubfieldIndex() throws Exception {
        String ppl = "source = " + INDEX_NAME
    public void testOrTwoPerf() throws Exception {
    }
            // prefer=true: Lucene drives end-to-end, no delegation instruction (no tree_shape).
     */
        List<List<Object>> rows = (List<List<Object>>) result.get("rows");
        String ppl = "source = " + INDEX_NAME + " | where match(message, 'hello') or tag = 'hello' and value = 5 | stats count() as cnt";
        try {
        String ppl = "source = " + INDEX_NAME + " | where match(message, 'hello') | stats sum(value) as total";
        }
    }
        String ppl = "source = " + INDEX_NAME + " | where match(message, 'hello') | stats dc(value) as d";
    }
        Map<String, Object> response = assertOkAndParse(client().performRequest(createIndex), "Create index");
        Map<String, Object> result = executePplViaShim(ppl);
    public void testEqualsFilterUnderOr_DoesNotPanic() throws Exception {
        Map<String, Object> result = executePplViaShim(ppl);
        String ppl = "source = " + INDEX_NAME
        createKeywordSubfieldIndex();
    public void testOrOfTwoAndArms() throws Exception {
        List<List<Object>> wrongCaseRows = rowsOf(executePplViaShim(wrongCase));
    private void createIndex() throws Exception {
        @SuppressWarnings("unchecked")
        createIndex.setJsonEntity(body);
        assertEquals("scalar agg must return exactly 1 row", 1, rows.size());
    public void testTextEqualsRoutesToKeywordSubfield() throws Exception {
     * raw value (e.g. {@code "Engineer"}) to the lowercased indexed tokens ({@code "engineer"}) and
            + "    \"message\": { \"type\": \"text\" },"
        } finally {
        indexDocs();
        String body = "{"
     */
        Request health = new Request("GET", "/_cluster/health/" + INDEX_NAME);
        // 10 docs with tag='hello' → total = 50
     * OR of two AND arms: left has correctness+perf, right has perf+native.
        Request request = new Request("POST", "/_analytics/ppl/_explain");
     * <p>Correctness: 10 docs have {@code tag='hello'} (and value=5), 10 have
    /**
        Request bulkRequest = new Request("POST", "/" + INDEX_NAME + "/_bulk");
    public void testAndMatchKeywordInteger_NoEmptyPeerIntersection() throws Exception {
     * query does not analyze its input, so a term against the analyzed text field would compare the
        for (int i = 0; i < 10; i++) {
        }
        assertNotNull(rows);
        throw new AssertionError("No SHARD_FRAGMENT stage in profile: " + stages);
        createIndex();
    public void testOrCorrectnessAndPerf() throws Exception {
    }
            + "  }"
     */
        assertEquals("SUM(value) for tag='hello' OR tag='goodbye' (all 20 docs)", 80L, total.longValue());
        String ppl = "source = " + INDEX_NAME + " | where tag = 'hello' and value = 5 | stats count() as cnt";
            + "}"
    }
    /**
     * under the OR, is reclassified to correctness and shipped to Lucene; the integer EQUALS isn't
        String ppl = "source = " + INDEX_NAME + " | where match(message, 'hello') or value > 4 | stats count() as c";
        // 10 docs tag='hello' value=5 + 10 docs tag='goodbye' value=3.
        try {
     * Disjunctive shape: two dual-viable EQUALS predicates sitting under OR. Without a
 *
            client().performRequest(new Request("DELETE", "/" + KEYWORD_SUBFIELD_INDEX));
        Request createIndex = new Request("PUT", "/" + INDEX_NAME);
        Map<String, Object> explain = assertOkAndParse(client().performRequest(request), "EXPLAIN: " + ppl);
        assertNotNull("rows must not be null", rows);
        Request bulkRequest = new Request("POST", "/" + KEYWORD_SUBFIELD_INDEX + "/_bulk");
public class FilterDelegationIT extends AnalyticsRestTestCase {
        @SuppressWarnings("unchecked")
     * performance peers. The integer field was marked Lucene-indexable in
    public void testAndMatchKeywordInteger_SumAggregation() throws Exception {
     * (auto-injected IS NOT NULL on top of the user's WHERE). FilterTreeShapeDeriver
        health.addParameter("wait_for_status", "green");
        // NOT(match(message,'hello')) → 10 goodbye docs.
     * The two leaves are on <em>different</em> fields ({@code tag} keyword and
        Map<String, Object> result = executePplViaShim(ppl);
     * Lucene-filterable and stays native. The two interleave under the OR → INTERLEAVED.
     * once that infrastructure exists. Without it, this test passes even if
            + "}";
     *
        List<List<Object>> rows = (List<List<Object>>) result.get("rows");
        assertEquals("scalar agg returns 1 row", 1, exactRows.size());
        assertEquals("scalar agg must return exactly 1 row", 1, rows.size());
     * after AND-intersection. Fix: STANDARD_TYPES in LuceneAnalyticsBackendPlugin
     * — the data node panics on the FFM bridge and the query fails.
            + "  \"index.composite.primary_data_format\": \"parquet\","
            ((Number) exactRows.get(0).get(0)).longValue());
        createIndex();
    private long executeCount(String ppl) throws Exception {
     * Under {@code prefer=false} the combiner runs: the dual-viable EQUALS can't stay
        // The lowercased form must NOT match: routing to .keyword is exact/case-sensitive, so
            + "  \"index.composite.primary_data_format\": \"parquet\","
 * compatible open source license.
     * via the inverted index). The planner emits a
     * match nothing. Before the fix this returned 0 rows; after, it matches via the keyword subfield.
    private static final String INDEX_NAME = "filter_delegation_e2e";
        assertEquals(20L, ((Number) rows.get(0).get(0)).longValue());
        assertNotNull(rows);
        }
        assertEquals(1, rows.size());
            bulk.append("{\"index\": {}}\n");
     * Precedence: match OR (tag= AND value=). Correctness under OR, perf under AND.
     */
        Request health = new Request("GET", "/_cluster/health/" + KEYWORD_SUBFIELD_INDEX);
     * gate, the planner emits {@code delegation_possible(...)} markers for both leaves,
    /**
        String ppl = "source = " + INDEX_NAME + " | where match(message, 'hello') or tag = 'hello' | stats count() as cnt";
 *
        Map<String, Object> result = executePplViaShim(ppl);
/**
        String wrongCase = "source = " + KEYWORD_SUBFIELD_INDEX + " | where occupation = 'engineer' | stats count() as c";
        @SuppressWarnings("unchecked")
 */
    }
            + " | where match(message, 'hello') and tag = 'hello' and value = 5 | stats count() as c";
        assertEquals(true, response.get("acknowledged"));
     * {@code value} integer) — same-field OR collapses into a Calcite Sarg
     * SingleCollector can't invert a collector bitmap, so the query crashed. Fix:
        // 'engineer' != 'Engineer'. (A term query on the analyzed text field would wrongly match
        List<List<Object>> rows = (List<List<Object>>) result.get("rows");
        List<List<Object>> rows = (List<List<Object>>) result.get("rows");
        Map<String, Object> result = executePplViaShim(ppl);
        Map<String, Object> result = executePplViaShim(ppl);
     * Performance-delegated under OR stays native (not combined with correctness).
        client().performRequest(bulkRequest);
            assertShardStage(ppl, 10L, /* prefer */ false, "datafusion", "CONJUNCTIVE");
     * Both delegations combined separately; result = 50.
        createIndex();
        assertEquals(10L, ((Number) rows.get(0).get(0)).longValue());
        for (Map<String, Object> stage : stages) {
    /**
 * data node dispatch → Lucene FilterDelegationHandle → Rust indexed executor → results.
        assertNotNull(rows);
     * createProvider/createCollector/collectDocs} lines emitted by
     * the integer query produced a null Scorer → empty bitset → wrong zero count
        // Flush to ensure parquet files are written
        @SuppressWarnings("unchecked")
     * profile's {@code chosen_backend} / {@code tree_shape}. A {@code null} {@code treeShape} means
     */
            bulk.append("{\"message\": \"hello world\", \"tag\": \"hello\", \"value\": 5}\n");
import java.util.Map;
            // tag (keyword, dual) ships to Lucene under the OR; value (int, native) stays in
        Map<String, Object> result = executePplViaShim(ppl);
            + "\"mappings\": {"
        health.addParameter("timeout", "30s");
     * filter's delegated predicate, producing tree_shape=NO_DELEGATION while
     * only declares Lucene-indexable types.
 * {@code FilterDelegationHandle} to count calls and exposes the count via REST — a
        Request createIndex = new Request("PUT", "/" + KEYWORD_SUBFIELD_INDEX);
     * referenced columns by full-schema index, but the projected batch had a different
            bulk.append("{\"index\": {}}\n");
        assertNotNull(rows);
        @SuppressWarnings("unchecked")
    }
        createIndex();
    public void testEqualsFilterPerformanceDelegationWithAggregate() throws Exception {
            + "  \"index.composite.secondary_data_formats\": \"lucene\""
    /**
        try {
 * while DataFusion drives the scan + aggregation.
    }
        indexDocs();
     * Regression: COUNT(DISTINCT col) is converted by Calcite into a stacked Filter
        indexDocs();
        assertEquals(10L, ((Number) rows.get(0).get(0)).longValue());
        Map<String, Object> result = executePplViaShim(ppl);
package org.opensearch.analytics.qa;
        assertEquals("scalar agg must return exactly 1 row", 1, rows.size());
    }
 * "consulting peer" / "lazy provider initialized" lines emitted from the handle and
     * Result: 10 (left arm) + 10 (right arm) = 20 (but overlap → 10 + 10 = 20 distinct docs).
     * layout — DataFusion panicked with "PhysicalExpr Column references column ... at
            assertShardStage(ppl, 10L, /* prefer */ true, "lucene", null);
        // sum(value) over the 10 matching docs (value=5 each) → 50.
        indexDocs();
            + "  \"number_of_shards\": 1,"
        assertEquals(1L, ((Number) rows.get(0).get(0)).longValue());
    }
        // dc(value) over docs matching match(message,'hello') → all values are 5 → 1 distinct.
        List<List<Object>> rows = (List<List<Object>>) result.get("rows");
        client().performRequest(new Request("POST", "/" + KEYWORD_SUBFIELD_INDEX + "/_flush?force=true"));
    }
        Map<String, Object> result = executePplViaShim(ppl);
     * the field must be absent (Lucene-as-driver, or no delegation instruction).
    }
            bulk.append("{\"occupation\": \"Doctor\", \"value\": 3}\n");
        indexDocs();
     */
        Map<String, Object> result = executePplViaShim(ppl);
            + "    \"occupation\": { \"type\": \"text\", \"fields\": { \"keyword\": { \"type\": \"keyword\" } } },"
            // prefer=false: combiner runs — the dual-viable EQUALS can't stay performance-delegated
 * E2E integration test for filter delegation: a MATCH predicate is delegated to Lucene
            + "  \"index.pluggable.dataformat.enabled\": true,"
    public void testMatchFilterDelegationWithAggregate() throws Exception {
        @SuppressWarnings("unchecked")
    /**
     * evaluator hits {@code unimplemented!()} arms for {@code BoolNode::DelegationPossible}
            bulk.append("{\"index\": {}}\n");
        Map<String, Object> stage = shardFragmentStage(ppl);
 * filter natively or delegated to Lucene. The only current way to confirm Lucene
            + "    \"value\": { \"type\": \"integer\" }"
 * the Rust evaluator. Asserting it in code would need a mock test plugin that wraps
            + "  \"number_of_replicas\": 0,"
        Map<String, Object> result = executePplViaShim(ppl);
    public void testAndOnlyPerfAndNative() throws Exception {
    /**
        List<List<Object>> rows = (List<List<Object>>) result.get("rows");
        return ((Number) rows.get(0).get(0)).longValue();
        createIndex();
 * predicate. The result-correctness checks below pass whether DataFusion handled the
    /**
