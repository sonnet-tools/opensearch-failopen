     * index N but input schema only has 1 columns". Fix: remap_expr_to_batch rewrites
     * Under {@code prefer=true} Lucene drives end-to-end (combiner skipped, no tree_shape).
import org.opensearch.client.Request;
        client().performRequest(bulkRequest);
        return rows;
    public void testAndMatchKeywordInteger_SumAggregation() throws Exception {  
            // DataFusion → the two interleave under the OR. Same shape both prefer modes.  
        createIndex();  
        List<List<Object>> rows = (List<List<Object>>) result.get("rows");  
        }
            + "  \"number_of_shards\": 1,"
        Map<String, Object> profile = (Map<String, Object>) explain.get("profile");
    }  
     * consultation zeroed out candidates.
        assertEquals("lowercase value must not match the exact keyword value", 0L,
 * E2E integration test for filter delegation: a MATCH predicate is delegated to Lucene
import java.util.Map;
        @SuppressWarnings("unchecked")  
        assertEquals(10L, ((Number) rows.get(0).get(0)).longValue());
    public void testEqualsFilterPerformanceDelegationWithAggregate() throws Exception {
        assertNotNull(rows);  
        } finally {  
        Number total = (Number) rows.get(0).get(0);  
    /**
     * EQUALS on a {@code text} field that has a {@code .keyword} multifield must match the exact,
        throws Exception {
        List<List<Object>> rows = (List<List<Object>>) result.get("rows");
    }  
     * only declares Lucene-indexable types.
     */  
 * filter natively or delegated to Lucene. The only current way to confirm Lucene  
     * gate, the planner emits {@code delegation_possible(...)} markers for both leaves,
     * OR(EQUALS on keyword, EQUALS on integer), oracle = 20. The keyword EQUALS is dual-viable and,
        Number total = (Number) rows.get(0).get(0);
        String label = "prefer=" + prefer;
        createIndex();  
        String ppl = "source = " + INDEX_NAME + " | where match(message, 'hello') or tag = 'hello' and value = 5 | stats count() as cnt";
            + " | where match(message, 'hello') and tag = 'hello' and value = 5 | stats count() as c";
        Map<String, Object> result = executePplViaShim(ppl);  
    }
            + "  }"
        String ppl = "source = " + INDEX_NAME + " | where tag = 'hello' and value = 5 | stats count() as cnt";  
        assertEquals(label + " — chosen_backend", chosenBackend, stage.get("chosen_backend"));
     * — the data node panics on the FFM bridge and the query fails.
        }
        @SuppressWarnings("unchecked")
        Map<String, Object> result = executePplViaShim(ppl);  
            // under OR, and it has a correctness sibling (the MATCH), so both collapse into a single
        try {
    public void testAndCorrectnessAndPerfAndNative() throws Exception {
        bulkRequest.setJsonEntity(bulk.toString());
        } catch (Exception ignored) {}
            assertShardStage(ppl, 10L, /* prefer */ true, "lucene", null);
        indexDocs();
        StringBuilder bulk = new StringBuilder();  
            + "\"settings\": {"
        @SuppressWarnings("unchecked")  
        @SuppressWarnings("unchecked")
    /**  
        List<List<Object>> exactRows = rowsOf(executePplViaShim(exact));
 *
package org.opensearch.analytics.qa;
        Map<String, Object> result = executePplViaShim(ppl);
        bulkRequest.addParameter("refresh", "true");  
    }  
    public void testAndMatchKeywordInteger_NoEmptyPeerIntersection() throws Exception {
            bulk.append("{\"index\": {}}\n");
     * Sets {@code prefer_metadata_driver}, then asserts the count oracle and the SHARD_FRAGMENT  
     * match(message,'hello') OR tag='hello' AND value=5
    }
        Number total = (Number) rows.get(0).get(0);
            setPreferMetadataDriver(true);
        try {
        assertEquals(10L, ((Number) rows.get(0).get(0)).longValue());
        assertEquals("scalar agg must return exactly 1 row", 1, rows.size());
        @SuppressWarnings("unchecked")
    private void createIndex() throws Exception {
        indexDocs();
     * layout — DataFusion panicked with "PhysicalExpr Column references column ... at
     * by FilterTreeShapeDeriver because hasMixed required a driving-backend sibling.
        assertNotNull(rows);
            + "  \"index.pluggable.dataformat\": \"composite\","
 * SPDX-License-Identifier: Apache-2.0
        indexDocs();
     * The two leaves are on <em>different</em> fields ({@code tag} keyword and  
        Request bulkRequest = new Request("POST", "/" + INDEX_NAME + "/_bulk");
     */
     * currently performed by inspecting cluster log output for the {@code [scf]  
        Map<String, Object> result = executePplViaShim(ppl);
     * Result: 10 (match 'hello') + 0 extra (tag='hello' AND value=5 is subset) = 10.
     * CoreRules.FILTER_MERGE collapses adjacent filters before derivation.  
     */  
     * tag='hello' AND value=5 (no correctness delegation, only performance + native under AND).  
     * OR(MATCH on text, EQUALS on keyword), oracle = 10. Both arms are Lucene-delegatable.
            + "},"
        createIndex.setJsonEntity(body);  
     * performance peers. The integer field was marked Lucene-indexable in  
    /**
     * (single SEARCH predicate, no real OR in the marked tree), which would
            + "  \"index.pluggable.dataformat.enabled\": true,"
            + "  \"number_of_replicas\": 0,"  
        client().performRequest(health);
     */
        assertEquals(label + " — tree_shape", treeShape, stage.get("tree_shape"));
        @SuppressWarnings("unchecked")  
        List<List<Object>> rows = (List<List<Object>>) result.get("rows");
     * filter's delegated predicate, producing tree_shape=NO_DELEGATION while  
     * createProvider/createCollector/collectDocs} lines emitted by
            + "    \"occupation\": { \"type\": \"text\", \"fields\": { \"keyword\": { \"type\": \"keyword\" } } },"
            + "  \"index.pluggable.dataformat.enabled\": true,"
        // Flush to ensure parquet files are written  
    public void testOrCorrectnessAndPerf() throws Exception {
        for (int i = 0; i < 7; i++) {
     */  
     */  
        @SuppressWarnings("unchecked")
    public void testTextEqualsRoutesToKeywordSubfield() throws Exception {
    public void testOrOfTwoAndArms() throws Exception {
            + "    \"value\": { \"type\": \"integer\" }"
        createIndex();
        String ppl = "source = " + INDEX_NAME + " | where tag = 'hello' | stats sum(value) as total";
        indexDocs();
    }
        assertEquals("scalar agg must return exactly 1 row", 1, rows.size());  
        createIndex();
public class FilterDelegationIT extends AnalyticsRestTestCase {
        health.addParameter("wait_for_status", "green");  
     * correctness (match) + performance (tag=) + native (value=) under AND.
        StringBuilder bulk = new StringBuilder();  
        health.addParameter("timeout", "30s");
    /**
     * the Rust filter classifier sends the tree to the bitmap-tree evaluator, and that  
        try {
        createIndex();
        List<List<Object>> wrongCaseRows = rowsOf(executePplViaShim(wrongCase));
            // tag (keyword, dual) ships to Lucene under the OR; value (int, native) stays in
        String wrongCase = "source = " + KEYWORD_SUBFIELD_INDEX + " | where occupation = 'engineer' | stats count() as c";  
 * the Rust evaluator. Asserting it in code would need a mock test plugin that wraps  
        String ppl = "source = " + INDEX_NAME
    public void testNotMatch_RoutesToTreeEvaluator() throws Exception {  
            bulk.append("{\"index\": {}}\n");
     */
            + "  \"number_of_shards\": 1,"
        createKeywordSubfieldIndex();  
            + "\"settings\": {"
        indexDocs();
        String ppl = "source = " + INDEX_NAME + " | where match(message, 'hello') or tag = 'hello' | stats count() as cnt";
     */
        client().performRequest(new Request("POST", "/" + INDEX_NAME + "/_flush?force=true"));
    // ---- Combining delegation tests ----  
        // 'engineer' != 'Engineer'. (A term query on the analyzed text field would wrongly match
     * case-sensitive value by routing the delegated term query to {@code <field>.keyword} — a term  
        assertNotNull(rows);  
        // 10 docs tag='hello' value=5 + 10 docs tag='goodbye' value=3.  
            + "  \"properties\": {"
     * Performance-delegated tag= combined; value= stays native. Result = 10.
        Map<String, Object> result = executePplViaShim(ppl);  
            + "\"mappings\": {"  
        assertNotNull(rows);
        assertNotNull("rows must not be null", rows);
 *  
        }
    private void assertShardStage(String ppl, long oracle, boolean prefer, String chosenBackend, String treeShape)
        Map<String, Object> result = executePplViaShim(ppl);
        String body = "{"  
        createIndex.setJsonEntity(body);
        assertEquals(10L, ((Number) rows.get(0).get(0)).longValue());
        assertEquals(1, rows.size());
        Map<String, Object> result = executePplViaShim(ppl);  
     * match nothing. Before the fix this returned 0 rows; after, it matches via the keyword subfield.  
            if ("SHARD_FRAGMENT".equals(stage.get("execution_type"))) return stage;  
     * a delegated leaf under OR/NOT triggers INTERLEAVED regardless of siblings.
     */
 *  
        String ppl = "source = " + INDEX_NAME + " | where match(message, 'hello') or value > 4 | stats count() as c";
    }
        createIndex();
    }
        // 7 docs occupation="Engineer", 3 docs occupation="Doctor" (mixed case on purpose).
        List<List<Object>> rows = (List<List<Object>>) result.get("rows");
     * <p>Correctness: 10 docs have {@code tag='hello'} (and value=5), 10 have
        List<List<Object>> rows = (List<List<Object>>) result.get("rows");  
     * performance-delegated under OR, and it has a correctness sibling (the MATCH), so both
     * Regression: OR(match, range-on-numeric) where the numeric field sits at a high
     * via the inverted index). The planner emits a
        assertEquals("scalar agg returns 1 row", 1, exactRows.size());
    public void testEqualsFilterUnderOr_DoesNotPanic() throws Exception {
    }
     */  
            + "    \"message\": { \"type\": \"text\" },"
    }
     * defeat the purpose of this test.  
        indexDocs();  
        // dc(value) over docs matching match(message,'hello') → all values are 5 → 1 distinct.  
        // The lowercased form must NOT match: routing to .keyword is exact/case-sensitive, so  
        Map<String, Object> response = assertOkAndParse(client().performRequest(createIndex), "Create index");
        createIndex();
     * raw value (e.g. {@code "Engineer"}) to the lowercased indexed tokens ({@code "engineer"}) and
            bulk.append("{\"occupation\": \"Doctor\", \"value\": 3}\n");
     *
        // sum(value) over the 10 matching docs (value=5 each) → 50.
        assertEquals(10L, ((Number) rows.get(0).get(0)).longValue());  
     * Performance-delegation path: an EQUALS predicate on a {@code keyword} field is
        String body = "{"  
    private Map<String, Object> shardFragmentStage(String ppl) throws Exception {  
        // match(message,'hello') OR value > 4 → 10 hello docs ∪ 10 value=5 docs (same set) = 10.
    }
            + "  \"index.composite.primary_data_format\": \"parquet\","  
        List<Map<String, Object>> stages = (List<Map<String, Object>>) profile.get("stages");
        createIndex();  
        Request health = new Request("GET", "/_cluster/health/" + INDEX_NAME);
        List<List<Object>> rows = (List<List<Object>>) result.get("rows");
     * delegationBytes recorded 1 delegated leaf — the data node errored with
    /**
     * only inspected the outermost OpenSearchFilter via findNode and missed the inner
            client().performRequest(new Request("DELETE", "/" + KEYWORD_SUBFIELD_INDEX));  
     * Disjunctive shape: two dual-viable EQUALS predicates sitting under OR. Without a
            + "}"  
    }
        String exact = "source = " + KEYWORD_SUBFIELD_INDEX + " | where occupation = 'Engineer' | stats count() as c";  
     * {@code value=3}. The OR matches all 20 docs. SUM(value) = 10*5 + 10*3 = 80.  
    }
            + "},"
        assertEquals("scalar agg must return exactly 1 row", 1, rows.size());  
        assertEquals("SUM(value) for tag='hello' OR tag='goodbye' (all 20 docs)", 80L, total.longValue());  
}
    public void testOrRangePredicateOnNumeric_DoesNotPanic() throws Exception {
            + " | where (match(message, 'hello') and tag = 'hello') or (tag = 'goodbye' and value = 3) | stats count() as cnt";
    }  
    /**  
            + "    \"tag\": { \"type\": \"keyword\" },"  
        // 10 docs match all three: match(message,'hello') AND tag='hello' AND value=5.
     * the field must be absent (Lucene-as-driver, or no delegation instruction).
        Map<String, Object> result = executePplViaShim(ppl);  
        }
        }  
    private void setPreferMetadataDriver(boolean value) throws Exception {
        client().performRequest(bulkRequest);  
            client().performRequest(new Request("DELETE", "/" + INDEX_NAME));  
 * <p>Exercises the full path: PPL → planner → ShardScanWithDelegationInstructionNode →
        @SuppressWarnings("unchecked")  
        assertEquals(label + " — count", oracle, executeCount(ppl));
        createIndex();
     * once that infrastructure exists. Without it, this test passes even if
     * Performance-delegated under OR stays native (not combined with correctness).
     * when its own pruning isn't selective enough for an RG.
        indexDocs();  
     *
        assertEquals("EQUALS on text field matches the exact (case-sensitive) keyword value", 7L,  
        List<List<Object>> rows = (List<List<Object>>) result.get("rows");
        Map<String, Object> result = executePplViaShim(ppl);
            setPreferMetadataDriver(true);
 * predicate. The result-correctness checks below pass whether DataFusion handled the
     * profile's {@code chosen_backend} / {@code tree_shape}. A {@code null} {@code treeShape} means
            // delegated_predicate — CONJUNCTIVE.
    public void testAndOnlyPerfAndNative() throws Exception {  
        @SuppressWarnings("unchecked")
    /**  
 * <p><b>Not asserted in code:</b> whether Lucene was actually called to evaluate the
     *  
     * evaluator hits {@code unimplemented!()} arms for {@code BoolNode::DelegationPossible}
     *
        assertNotNull("rows must not be null", rows);
            + "}"
        @SuppressWarnings("unchecked")
     * under the OR, is reclassified to correctness and shipped to Lucene; the integer EQUALS isn't
        assertNotNull(rows);
        assertEquals("SUM(value) for MATCH(message, 'hello') docs", 50L, total.longValue());
     * indices to match the projected batch before evaluating.  
        String ppl = "source = " + INDEX_NAME + " | where tag = 'hello' or value = 3 | stats count() as cnt";  
        String ppl = "source = " + INDEX_NAME + " | where match(message, 'hello') | stats sum(value) as total";  
     * {@code delegation_possible(tag = 'hello', annotationId)} marker; DataFusion
        List<List<Object>> rows = (List<List<Object>>) result.get("rows");  
     * {@code value} integer) — same-field OR collapses into a Calcite Sarg
     * Result: 10 (left arm) + 10 (right arm) = 20 (but overlap → 10 + 10 = 20 distinct docs).
     * Precedence: match OR (tag= AND value=). Correctness under OR, perf under AND.  
            + "  \"properties\": {"
    private void createKeywordSubfieldIndex() throws Exception {
        String ppl = "source = " + INDEX_NAME + " | where match(message, 'hello') | stats dc(value) as d";
            + "\"mappings\": {"  
        } finally {
     * SingleCollector can't invert a collector bitmap, so the query crashed. Fix:  
        String ppl = "source = " + INDEX_NAME + " | where match(message, 'hello') and tag = 'hello' and value = 5 | stats count() as cnt";
        indexDocs();
        Map<String, Object> stage = shardFragmentStage(ppl);  
            + "  \"index.pluggable.dataformat\": \"composite\","
    }
        for (int i = 0; i < 10; i++) {
/**  
        assertEquals(true, response.get("acknowledged"));
        String ppl = "source = " + INDEX_NAME  
     * Regression: AND with sum() aggregation — non-count aggregations also need
    /**
        Map<String, Object> response = assertOkAndParse(client().performRequest(createIndex), "Create index");
 * delegation actually happened is to read cluster logs and look for the per-RG
            // prefer=true: Lucene drives end-to-end, no delegation instruction (no tree_shape).
    }
    private void indexDocs() throws Exception {
    /**  
     * Regression: NOT(match) on a delegated predicate was misclassified as CONJUNCTIVE
        health.addParameter("wait_for_status", "green");
        @SuppressWarnings("unchecked")
        Map<String, Object> explain = assertOkAndParse(client().performRequest(request), "EXPLAIN: " + ppl);  
    private static final String INDEX_NAME = "filter_delegation_e2e";  
 */  
     */  
        bulkRequest.setJsonEntity(bulk.toString());
     * (auto-injected IS NOT NULL on top of the user's WHERE). FilterTreeShapeDeriver
    }  
    /**
        assertEquals("SUM(value) for tag='hello' docs (dual-viable performance delegation)", 50L, total.longValue());  
        client().performRequest(new Request("POST", "/" + KEYWORD_SUBFIELD_INDEX + "/_flush?force=true"));
    /**  
 * compatible open source license.
    /**
        setPreferMetadataDriver(prefer);  
     * {@code LuceneFilterDelegationHandle}. Replace with a proper counter check
        Request request = new Request("POST", "/_analytics/ppl/_explain");
        List<List<Object>> rows = (List<List<Object>>) result.get("rows");
     * dual-viable (both DataFusion can evaluate against parquet and Lucene can evaluate  
    /**
        List<List<Object>> rows = (List<List<Object>>) result.get("rows");
        indexDocs();
            + "    \"value\": { \"type\": \"integer\" }"  
    }  
     * (test plugin + REST endpoint or DF metrics surfaced through PPL response)  
        client().performRequest(health);
        req.setJsonEntity("{\"persistent\":{\"analytics.planner.prefer_metadata_driver\": " + value + "}}");
    private static List<List<Object>> rowsOf(Map<String, Object> result) {
        Request bulkRequest = new Request("POST", "/" + KEYWORD_SUBFIELD_INDEX + "/_bulk");  
     * format (composite-parquet primary) only indexes text/keyword/match_only_text —
        Map<String, Object> result = executePplViaShim(ppl);
     */
     * <p>Both predicates use EQUALS so we exercise the existing
        indexDocs();
        Request req = new Request("PUT", "/_cluster/settings");  
    /**
 * The OpenSearch Contributors require contributions made to  
     * <p>TODO(scf-prod): runtime assertion that Lucene was actually consulted is
    /**
     * "execute_indexed_query called with no index_filter(...) in plan". Fix:
/*  
     * OR of two AND arms: left has correctness+perf, right has perf+native.
            + "}";  
    public void testOrCorrectnessWithPerfAndNative() throws Exception {
        createIndex();  
            + "}";
        List<List<Object>> rows = (List<List<Object>>) result.get("rows");
        client().performRequest(req);
        String ppl = "source = " + INDEX_NAME + " | where tag = 'hello' or value = 3 | stats sum(value) as total";  
            assertShardStage(ppl, 20L, /* prefer */ false, "datafusion", "INTERLEAVED_BOOLEAN_EXPRESSION");
        createIndex();
        // here — this asserts we are on the keyword path, not the analyzed-text path.)
            + "  \"index.composite.secondary_data_formats\": \"lucene\""
     * correctly filtered batches. Pre-fix this returned null because peer  
        @SuppressWarnings("unchecked")
    }
            bulk.append("{\"index\": {}}\n");  
            bulk.append("{\"occupation\": \"Engineer\", \"value\": 5}\n");  
     * Regression: AND(match, keyword=, integer=) routed via SingleCollector with
        indexDocs();  
        } catch (Exception ignored) {}
            ((Number) wrongCaseRows.get(0).get(0)).longValue());  
            ((Number) exactRows.get(0).get(0)).longValue());
            bulk.append("{\"message\": \"hello world\", \"tag\": \"hello\", \"value\": 5}\n");  
     */
     * <p>Result-correctness check: 10 docs with tag='hello' → SUM(value) = 50.  
        createIndex();  
        return ((Number) rows.get(0).get(0)).longValue();  
     * FieldStorageResolver and routed to peer consultation, but Lucene's secondary
            bulk.append("{\"index\": {}}\n");  
    }
        bulkRequest.addParameter("refresh", "true");
     * schema index. The bitmap-tree evaluator's general expr.evaluate(batch) path
     * Both delegations combined separately; result = 50.
     * query does not analyze its input, so a term against the analyzed text field would compare the
        indexDocs();  
     * the integer query produced a null Scorer → empty bitset → wrong zero count  
            + " | where match(message, 'hello') and tag = 'hello' and value = 5 | stats sum(value) as s";  
 * {@code FilterDelegationHandle} to count calls and exposes the count via REST — a
     * match(message,'hello') AND tag='hello' AND value=5  
     * Lucene-filterable and stays native. The two interleave under the OR → INTERLEAVED.  
        indexDocs();  
    }  
    public void testOrTwoPerf() throws Exception {
     */  
        assertEquals(10L, ((Number) rows.get(0).get(0)).longValue());
        indexDocs();  
        @SuppressWarnings("unchecked")  
        // 10 docs with "hello world" and value=5 → total = 50
     * referenced columns by full-schema index, but the projected batch had a different  
        Request createIndex = new Request("PUT", "/" + KEYWORD_SUBFIELD_INDEX);
        health.addParameter("timeout", "30s");  
        assertEquals(20L, ((Number) rows.get(0).get(0)).longValue());  
        createIndex();
    @SuppressWarnings("unchecked")  
            bulk.append("{\"message\": \"goodbye world\", \"tag\": \"goodbye\", \"value\": 3}\n");
        for (Map<String, Object> stage : stages) {
 * this file be licensed under the Apache-2.0 license or a
 * while DataFusion drives the scan + aggregation.
            // prefer=false: combiner runs — the dual-viable EQUALS can't stay performance-delegated  
            assertShardStage(ppl, 10L, /* prefer */ false, "datafusion", "CONJUNCTIVE");  
        Map<String, Object> result = executePplViaShim(ppl);
     * evaluates the predicate natively for page-stat pruning, and consults Lucene only  
     * after AND-intersection. Fix: STANDARD_TYPES in LuceneAnalyticsBackendPlugin
     * Lucene is never consulted.
        assertNotNull("rows must not be null", rows);
    }  
    private long executeCount(String ppl) throws Exception {
        // 10 docs with tag='hello' → total = 50
        throw new AssertionError("No SHARD_FRAGMENT stage in profile: " + stages);
            + "  \"index.composite.primary_data_format\": \"parquet\","  
            assertShardStage(ppl, 20L, /* prefer */ true, "datafusion", "INTERLEAVED_BOOLEAN_EXPRESSION");
        Map<String, Object> result = executePplViaShim(ppl);
        String ppl = "source = " + INDEX_NAME
 * "consulting peer" / "lazy provider initialized" lines emitted from the handle and
        assertNotNull("rows must not be null", rows);  
     * Regression: COUNT(DISTINCT col) is converted by Calcite into a stacked Filter  
        assertEquals(10L, ((Number) rows.get(0).get(0)).longValue());
 * bigger surface than this IT warrants, so deferred.
            + "  }"
        assertEquals(50L, ((Number) rows.get(0).get(0)).longValue());  
        @SuppressWarnings("unchecked")  
        List<List<Object>> rows = (List<List<Object>>) result.get("rows");
    private static final String KEYWORD_SUBFIELD_INDEX = "text_equals_keyword_subfield_e2e";
        Request createIndex = new Request("PUT", "/" + INDEX_NAME);  
            + "  \"index.composite.secondary_data_formats\": \"lucene\""
     * {@code EqualsSerializer} (no other comparison serializers are wired today).
import java.util.List;  
 * data node dispatch → Lucene FilterDelegationHandle → Rust indexed executor → results.
        try {  
     * (match(message,'hello') AND tag='hello') OR (tag='goodbye' AND value=3)  
        Request health = new Request("GET", "/_cluster/health/" + KEYWORD_SUBFIELD_INDEX);
        List<List<Object>> rows = (List<List<Object>>) result.get("rows");  
        for (int i = 0; i < 3; i++) {
        }
        }
        assertEquals(true, response.get("acknowledged"));  
     */
        Map<String, Object> result = executePplViaShim(ppl);
        @SuppressWarnings("unchecked")
    }
        // NOT(match(message,'hello')) → 10 goodbye docs.
        request.setJsonEntity("{\"query\": \"" + escapeJson(ppl) + "\"}");
     * collapse into a single {@code delegated_predicate} — CONJUNCTIVE.
     * Under {@code prefer=false} the combiner runs: the dual-viable EQUALS can't stay  
        String ppl = "source = " + INDEX_NAME + " | where not match(message, 'hello') | stats count() as c";
 */  
        createIndex();
        for (int i = 0; i < 10; i++) {
        List<List<Object>> rows = (List<List<Object>>) result.get("rows");
        assertEquals(1L, ((Number) rows.get(0).get(0)).longValue());
    public void testMatchFilterDelegationWithAggregate() throws Exception {
    public void testCountDistinctWithMatchFilter_StackedFilterMerged() throws Exception {
            + "  \"number_of_replicas\": 0,"  
