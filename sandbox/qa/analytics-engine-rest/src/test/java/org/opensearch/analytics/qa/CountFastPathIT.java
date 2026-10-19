        assertShardFragmentChoseBackend(explain, "datafusion");
    @SuppressWarnings("unchecked")  
     * IN-list lowers to {@code BoolQueryBuilder.should} (term-set query) on Lucene.
            "where userID = 'u_a' AND event_type = 'view' AND region = 'us' | stats count() as cnt",  
        );  
            flush();  
     * (DataFusion-only). The numeric leaf forces DataFusion as the operator backend on the
        new Doc("u_b", "click", 50, "us", "alpha beta gamma"),  
            bulkIndex(docs(batch));
     * {@code MatchQueryBuilder}.
        // AND of two keyword EQUALS — fully Lucene-driven, combiner not invoked.  
    }  
            "where userID = 'u_b' OR userID = 'u_seg3_only' | stats count() as cnt",  
    }  
        assertStageHasNoTreeShape(explain, "COORDINATOR_REDUCE");  
/*  
        assertEquals("clicks + views must equal total docs (every event has one type)", total, clicks + views);
                + "\", \"amount\": "
     * Lucene's {@code Index(supportedFieldTypes={KEYWORD, TEXT, MATCH_ONLY_TEXT})}  
        );  
        assertShardFragmentChoseBackend(alphaExplain, "lucene");
    }
        assertEquals("Bulk indexing should have no errors", false, response.get("errors"));  
        assertCount("where amount < 0 | stats count() as cnt", 0);  
        );  
 *   <li><b>Lucene-only viable</b> — predicate references a keyword/text field that lives in
        ingestThreeSegments();  
        assertCount(
        for (Map<String, Object> stage : stages) {
     * the DataFusion engine path runs end-to-end. Asserted via correctness of the count.
            if (executionType.equals(stage.get("execution_type"))) {
        for (int seg = 0; seg < SEGMENT_BOUNDS.length - 1; seg++) {
     * <p>{@code count()} (no field) is the actual Lucene-driven path —
        return false;  
        fail("No " + executionType + " stage in profile: " + stages);
    private static String docs(String... documents) {
    }  
        health.addParameter("timeout", "30s");  
            + "    \"message\": { \"type\": \"text\" },"  
    /**
            + "  \"properties\": {"
            sb.append("{\"index\": {}}\n").append(d).append("\n");
        assertShardFragmentChoseBackend(explain, "lucene");  
        request.setJsonEntity("{\"query\": \"" + escapeJson(ppl) + "\"}");
            oracleWhere(d -> d.userID.equals("u_b") || tokenizedContains(d.message, "gamma"))  
 *
    }
        // dual-viable is in effect (count fast path forces it on).
    // ── Oracle helpers ──────────────────────────────────────────────────────
            + "  \"index.composite.secondary_data_formats\": \"lucene\""
import org.opensearch.client.Response;
            "source = " + INDEX + " | where match(message, 'alpha') | stats count(userID) as cnt"
        assertStageChoseBackend(explain, "COORDINATOR_REDUCE", expectedBackend);
     *              u_a/click/30/us/"alpha", u_b/view/40/eu/"gamma",
        }  
        );  
            "where NOT(event_type = 'click') | stats count() as cnt",
    private static boolean tokenizedContains(String text, String token) {
        String andPpl = "where userID = 'u_a' AND event_type = 'click' | stats count() as cnt";
        assertCount(
    }
        new Doc("u_c", "click", 70, "apac", "beta"),
        long total = DOCS.size();  
    public void testFullTextMatchFilter() throws Exception {  
        // EQUALS + MATCH on keyword + text — both Lucene-resolvable; combiner ships them as  
            for (int i = from; i < to; i++) {
        // Combined with a keyword filter — both delegate to Lucene, fused into one BoolQueryBuilder.
            + "    \"region\": { \"type\": \"keyword\" },"
     * picks Lucene because the field has {@code indexFormats=[lucene]} (BKD points).  
        new Doc("u_a", "click", 30, "us", "alpha"),
        for (Map<String, Object> stage : stages) {
        StringBuilder sb = new StringBuilder();
     *  
     * {@code IndexSearcher.count} resolves via the term dictionary.  
        assertNotNull("profile present", profile);
            + "\"mappings\": {"
    }
    /**
        new Doc("u_b", "view", 40, "eu", "gamma"),
    // ── PPL helpers ─────────────────────────────────────────────────────────
        assertCoordinatorReduceChoseBackend(explain, "datafusion");
    private Map<String, Object> executePPL(String ppl) throws IOException {  
public class CountFastPathIT extends AnalyticsRestTestCase {
        ingestThreeSegments();
 *       Lucene's secondary inverted index and isn't reproducible by the parquet/DataFusion
        // 'alpha' appears in many docs; oracle counts whitespace-tokenised occurrences.
     * fails with "decode failed: invalid tag value".
     * Filter, so the keyword leaf either correctness-delegates to Lucene (when DataFusion  
            "where match(message, 'gamma') | stats count() as cnt",  
        Response response = client().performRequest(request);
     * Single source of truth — every assertion's oracle is computed from this list.  
        List<Map<String, Object>> stages = (List<Map<String, Object>>) profile.get("stages");  
                batch[i - from] = DOCS.get(i).toJson();  
        // OR across backends — the combiner declines to fuse under disjunction unless
        assertCount(
            + "    \"userID\": { \"type\": \"keyword\" },"  
        for (String d : documents) {  
        long total = DOCS.size();
     *              u_b/view/51/us/"alpha beta", u_c/click/61/apac/"gamma alpha",  
        return DOCS.stream().filter(p).count();
            oracleWhere(d -> tokenizedContains(d.message, "gamma"))
        String alphaPpl = "where match(message, 'alpha') | stats count() as cnt";
     * {@code count(field)} on a numeric field where {@code amount} only has parquet doc values.
    }
    /**
        createIndex();  
        try {
    private void ingestThreeSegments() throws Exception {  
    /** Range of doc indices that go into each segment (start inclusive, end exclusive). */
            client().performRequest(new Request("DELETE", "/" + INDEX));
        Request request = new Request("POST", "/_analytics/ppl/_explain");  
        ingestThreeSegments();  
    }
    private static void assertStageChoseBackend(Map<String, Object> explain, String executionType, String expectedBackend) {
 */  
     * </pre>
        assertCount(
        assertCount("stats count(userID) as cnt", total);
        new Doc("u_a", "click", 10, "us", "alpha beta"),
    /**
        req.setJsonEntity(body);  
        String toJson() {
    @SuppressWarnings("unchecked")
                + "\", \"event_type\": \""
            "where userID IN ('u_a', 'u_c') | stats count() as cnt",
    private Map<String, Object> executeExplain(String ppl) throws IOException {
    /**  
    }  
    /** Asserts the SHARD_FRAGMENT stage in {@code explain.profile.stages} chose the given backend. */  
    private void createIndex() throws Exception {
        return sb.toString();  
                return;
            oracleWhere(d -> d.userID.equals("u_a") && tokenizedContains(d.message, "alpha"))
    /** Asserts the COORDINATOR_REDUCE stage in {@code explain.profile.stages} chose the given backend. */
    }
        createIndex();  
        return assertOkAndParse(response, "EXPLAIN: " + ppl);  
            oracleWhere(d -> !d.eventType.equals("click"))
        // Coverage parity: every doc has exactly one event_type, so click_count + view_count = total.
    /**
            + numberOfShards
     * each so each wave becomes its own Lucene segment. Multi-segment ingest exercises the  
     * Substrait stub from {@code LuceneFragmentConvertor.convertSchemaOnlyRead}; if Lucene's
     * Mixed-backend AND: keyword-side leaf (Lucene viable) AND numeric-side leaf
                + userID  
 * summation. Each test method computes its own oracle from {@link #DOCS} so adding rows in
                    expectedBackend,
        Map<String, Object> profile = (Map<String, Object>) explain.get("profile");
import java.util.List;
 * one place doesn't silently break a different assertion.
    }
        ingestThreeSegments();
    public void testNumericFilter_dataFusionOnly() throws Exception {
     * DataFusion only. Asserting on row correctness (DF computes the right count) is the
            "where region IN ('apac') | stats count() as cnt",
        assertCount(
}
        req.setOptions(req.getOptions().toBuilder().addHeader("Content-Type", "application/x-ndjson").build());
        // covers segments where most leaves contribute zero.
    /**
 * </ol>
        String ppl = "source = " + INDEX + " | " + pplSuffix;  
        new Doc("u_a", "click", 21, "eu", "beta"),
        Request req = new Request("POST", "/" + INDEX + "/_bulk");
            "where region = 'us' AND event_type = 'view' | stats count() as cnt",
        );
     * still Lucene-viable, still the fast path.
        assertNotNull("Response missing 'rows' for: " + ppl, rows);  
        );  
        assertCount("where amount >= 50 | stats count() as cnt", oracleWhere(d -> d.amount >= 50));  
                    stage.get("chosen_backend")  
        assertEquals("Expected 1 row for count query: " + ppl, 1, rows.size());
            "where userID = 'u_a' AND match(message, 'alpha') | stats count() as cnt",
        );
        Request req = new Request("POST", "/_analytics/ppl");
     *
        assertCount(
        client().performRequest(new Request("POST", "/" + INDEX + "/_flush?force=true"));
     * {@code amount} field. Lucene has no doc values for it (long fields aren't in the  
    }
        createIndex();
        // Term that's present in fewer docs.
        }
 *       picked. The DataFusion engine path runs.</li>  
     * Predicates that only DataFusion can answer — numeric range on the parquet-backed
        // count(field) + correctness-delegated MATCH filter: Project/Filter narrow to DF, but  
    private static final String INDEX = "count_fast_path_e2e";  
            + "  \"index.pluggable.dataformat.enabled\": true,"
     * Pure Lucene-side AND/OR over keyword fields. Both leaves are correctness-delegated to
    }
        assertCount("stats count(amount) as cnt", total);
 *
        client().performRequest(health);
     *              u_seg3_only/view/32/eu/"alpha", u_seg3_only/click/42/apac/"gamma"  
        assertCount(  
        createIndex(1);  
        assertCount("where userID = 'dave' | stats count() as cnt", 0);
        assertCount(
        // Zero-match: 'dave' isn't in any segment → Weight.count returns 0 per leaf.  
        req.setJsonEntity("{\"query\": \"" + escapeJson(ppl) + "\"}");
        assertShardFragmentChoseBackend(explain, "datafusion");
        assertShardFragmentChoseBackend(andExplain, "lucene");
        new Doc("u_a", "view", 11, "us", "alpha alpha"),
    }
        Request req = new Request("PUT", "/" + INDEX);
        new Doc("u_a", "view", 31, "us", "gamma"),  
 * must navigate:
 *       parquet has doc values for; Lucene is not viable for the operator and must NOT be
            oracleWhere(d -> d.userID.equals("u_b") || d.amount == 42)
        assertStageChoseBackend(explain, "SHARD_FRAGMENT", expectedBackend);
     *              u_b/click/50/us/"alpha beta gamma", u_c/view/60/apac/"alpha gamma",
    }
        return assertOkAndParse(response, "PPL: " + ppl);
            oracleWhere(d -> tokenizedContains(d.message, "alpha"))
            + "  }"
    public void testKeywordBooleanFilter_luceneFused() throws Exception {
     *              u_c/click/70/apac/"beta"  
        ingestThreeSegments();
            oracleWhere(d -> d.region.equals("us") && d.eventType.equals("view"))
import java.io.IOException;
        new Doc("u_b", "click", 41, "eu", "alpha"),
        // Validates the count(*) fast path through Lucene's IndexReader.numDocs.
    private void bulkIndex(String ndjson) throws Exception {  
 *   <li><b>Full-text on a text field</b> — {@code MATCH(message, ...)} resolves only on
    private void flush() throws Exception {  
            + "    \"amount\": { \"type\": \"long\" }"
        String ppl = "source = " + INDEX + " | " + pplSuffix;
    }
                assertNull(executionType + " unexpectedly carries tree_shape (full stage: " + stage + ")", stage.get("tree_shape"));  
     * skip entirely. SHARD_FRAGMENT runs Lucene, COORDINATOR_REDUCE runs DataFusion summing  
    public void testInListFilter() throws Exception {  
     *   segment 2: u_a/view/12/us/"alpha", u_seg3_only/click/22/eu/"beta gamma",
     */
    }
     * type, so the planner chooses Lucene and ships the predicate as a NamedWriteable  
        createIndex();
    /**  
    private static long oracleWhere(java.util.function.Predicate<Doc> p) {  
    }  
        ingestThreeSegments();
import org.opensearch.client.Request;
     * Filter(IS NOT NULL(field)) → Scan} (count of non-null values), and the {@code IS NOT NULL}
        for (String t : text.toLowerCase(java.util.Locale.ROOT).split("\\s+")) {  
                );
                + eventType
    // ── Setup ───────────────────────────────────────────────────────────────  
        assertCount(
            oracleWhere(d -> d.userID.equals("u_seg3_only"))
 *       column scan. Lucene drives end-to-end via {@code LuceneSearchExecEngine}.</li>  
        assertCount("where amount > 50 | stats count() as cnt", oracleWhere(d -> d.amount > 50));
        assertCount(  
        new Doc("u_c", "click", 81, "us", "alpha"),
    }
     * <pre>
    public void testCountByNumericField_drivenByDataFusion() throws Exception {
        Map<String, Object> mixedExplain = executeExplain(
            + "  \"number_of_shards\": "
        ingestThreeSegments();  
    private static void assertCoordinatorReduceChoseBackend(Map<String, Object> explain, String expectedBackend) {  
                return;
        } catch (Exception ignored) {}  
        assertCount(andPpl, oracleWhere(d -> d.userID.equals("u_a") && d.eventType.equals("click")));
            + "\"settings\": {"  
            "where userID = 'u_a' AND amount > 20 | stats count() as cnt",  
 * End-to-end tests for the count fast path covering the four shape buckets the planner  
        // segment 1  
     * {@link #testCountAcrossMultipleShards_luceneShardsToDataFusionReduce} cover that.  
        Map<String, Object> result = executePPL(ppl);  
        );
        ingestThreeSegments();
     */
     * Layout (segment splits in {@link #ingestThreeSegments}):
     */
        // Single-segment-only term: 'u_seg3_only' only in segment 2. Per-leaf summation  
            "where userID = 'u_seg3_only' | stats count() as cnt",  
    // ── Document model ──────────────────────────────────────────────────────
                + "}";  
 * <p>Multi-segment ingest exercises Lucene's per-leaf {@code Weight.count(LeafReaderContext)}  
            + ","  
 * compatible open source license.
    }
            oracleWhere(d -> d.userID.equals("u_b") || d.userID.equals("u_seg3_only"))
        assertCount(  
        new Doc("u_seg3_only", "click", 22, "eu", "beta gamma"),
        List<List<Object>> rows = (List<List<Object>>) result.get("rows");
        // segment 2  
     * {@code count(field)} on a keyword field — DataFusion drives by design. PPL's  
        new Doc("u_b", "view", 51, "us", "alpha beta"),
     */
 * {@code ./gradlew :sandbox:qa:analytics-engine-rest:integTest --tests "*.CountFastPathIT" -Dsandbox.enabled=true}
        );
 *
        assertEquals(true, response.get("acknowledged"));
     *   segment 1: u_a/view/11/us/"alpha alpha", u_a/click/21/eu/"beta",
            + "},"  
        long clicks = countOf("where event_type = 'click' | stats count() as cnt");
    private void assertCount(String pplSuffix, long expected) throws IOException {
     *              u_c/view/71/apac/"beta beta", u_c/click/81/us/"alpha"
     * Lucene; the combiner emits a single fused {@code BoolQueryBuilder} which Lucene's
        // OR mixing keyword EQUALS with MATCH — the dual-viable EQUALS fuses with the MATCH
    public void testCountAcrossMultipleShards_luceneShardsToDataFusionReduce() throws Exception {  
 *       combiner fuses both sides into one Lucene query.</li>  
            "where userID = 'u_b' OR amount = 42 | stats count() as cnt",
        }
        new Doc("u_seg3_only", "view", 32, "eu", "alpha"),  
        assertCount(
    private void createIndex(int numberOfShards) throws Exception {  
     * STANDARD_TYPES set), so the planner must drop Lucene from the alternative list and
        new Doc("u_c", "click", 61, "apac", "gamma alpha"),  
        Map<String, Object> andExplain = executeExplain("source = " + INDEX + " | " + andPpl);  
 */  
        createIndex();
            + "  \"index.composite.primary_data_format\": \"parquet\","
            + "}"  
            oracleWhere(d -> d.userID.equals("u_a") && d.amount > 20)
 *   <li><b>Mixed AND/OR</b> — leaves split between backends. {@code FilterTreeShape} drives
        createIndex(3);
     * <p>Three shards is enough to make the bug deterministic — fewer shards risk Lucene's  
        // Single keyword equality (Lucene-only viable: keyword has indexFormats=[lucene],
        assertCount("stats count() as cnt", total);  
        // the MATCH leaf delegates to Lucene per row group. Asserts both correctness and that
        new Doc("u_seg3_only", "click", 42, "apac", "gamma")
        assertShardFragmentChoseBackend(mixedExplain, "datafusion");
    }
     */  
        // segment 0
    }
        Map<String, Object> response = assertOkAndParse(client().performRequest(req), "Bulk index");
            if (executionType.equals(stage.get("execution_type"))) {
        String body = "{"
            oracleWhere(d -> d.userID.equals("u_a") && tokenizedContains(d.message, "alpha"))
     */  
     * be DataFusion. Catches the planner-level regression where a numeric scan accidentally
        Map<String, Object> response = assertOkAndParse(client().performRequest(req), "Create index");
        // stages. Pins that the multi-shard reducer path doesn't accidentally synthesize a  
                assertEquals(  
            int from = SEGMENT_BOUNDS[seg];
        createIndex();
    /** Asserts the named stage has no {@code tree_shape} field — i.e. no delegation instruction. */
        assertCount("where userID = 'u_a' | stats count() as cnt", oracleWhere(d -> d.userID.equals("u_a")));
                + amount
 * SPDX-License-Identifier: Apache-2.0
    private static final int[] SEGMENT_BOUNDS = { 0, 7, 15, DOCS.size() };
     */
     */
        assertNotNull("stages present", stages);  
     * per-shard counts. The reducer registers each shard's partition stream against the
     * useful invariant; backend choice is forced by the planner.
        // the SHARD_FRAGMENT remains DataFusion-driven (delegation, not driver collapse).
                    executionType + " chose unexpected backend (full stage: " + stage + ")",
        assertStageHasNoTreeShape(explain, "SHARD_FRAGMENT");
     * doesn't have it natively) or stays as a {@code delegation_possible} performance hint.
            int to = SEGMENT_BOUNDS[seg + 1];  
        );
     * Either way, the count must match the oracle.
        Map<String, Object> explain = executeExplain("source = " + INDEX + " | stats count() as cnt");
     *              u_a/view/31/us/"gamma", u_b/click/41/eu/"alpha",
            }
        long actual = countOf(pplSuffix);
        );
        ingestThreeSegments();
            String[] batch = new String[to - from];
    private long countOf(String pplSuffix) throws IOException {
     * stage being elided into the coord stage by the planner.
        );
        ingestThreeSegments();
    // ── Explain helpers ─────────────────────────────────────────────────────  
    public void testNegationFilter() throws Exception {  
            "where userID != 'u_a' | stats count() as cnt",
 *       Lucene; correctness delegation puts the predicate on Lucene's side and the count
        new Doc("u_c", "view", 60, "apac", "alpha gamma"),
        assertCount("stats count() as cnt", total);
 * <p>Run with:
        createIndex();
            "where match(message, 'alpha') | stats count(userID) as cnt",
        // Three-way AND across keyword fields exercises BoolQueryBuilder with multiple MUST clauses.
    /** Standard-analyzer-equivalent: token equality on whitespace splits. */
        long total = DOCS.size();  
     * non-Substrait wire bytes leak into {@code derive_schema_from_partial_plan}, this test  
        long total = DOCS.size();
        List<Map<String, Object>> stages = (List<Map<String, Object>>) profile.get("stages");
    private static void assertShardFragmentChoseBackend(Map<String, Object> explain, String expectedBackend) {
            if (t.equals(token)) return true;
    );
 * The OpenSearch Contributors require contributions made to  
            + "    \"event_type\": { \"type\": \"keyword\" },"
     * Multi-shard count: exercises the cross-backend partition boundary that single-shard tests
     * per-leaf {@code Weight.count} summation inside {@code IndexSearcher.count}.
            + "  \"number_of_replicas\": 0,"
        );  
        }
        );
                + "\", \"region\": \""  
     * doesn't cover LONG, so the planner never marks Lucene viable — the SHARD_FRAGMENT must
        // Empty range — every doc's amount > 0, so amount<0 is empty.
        assertCount(  
        // one fused BoolQueryBuilder. Picks up perf-delegation on the keyword leaf and
        createIndex();  
    }
        // operator EQ supported on Lucene). 'u_a' appears 7 times across all three segments.  
    private static void assertStageHasNoTreeShape(Map<String, Object> explain, String executionType) {
        }
/**
    public void testCountAcrossMultipleSegments() throws Exception {
            }
 *       the conjunctive vs disjunctive delegation, and (when the count detector matches) the
import java.util.Map;  
    /**
        Request health = new Request("GET", "/_cluster/health/" + INDEX);
                + region
        return ((Number) rows.get(0).get(0)).longValue();
            }  
        // correctness sibling into one Lucene shipment under OR; the count is unaffected.  
 * this file be licensed under the Apache-2.0 license or a
            oracleWhere(d -> d.region.equals("apac"))  
        // FilterDelegationInstructionNode where there's no filter to delegate.
        assertEquals("Count mismatch for: " + ppl, expected, actual);
    }
            + "}";
     */
        Map<String, Object> explain = executeExplain("source = " + INDEX + " | stats count(userID) as cnt");  
     * Ingest in three waves (defined by {@link #SEGMENT_BOUNDS}) with force-flush between
        assertCount(alphaPpl, oracleWhere(d -> tokenizedContains(d.message, "alpha")));  
        req.addParameter("refresh", "true");  
 *       fast path runs.</li>  
        }
     * Full-text {@code MATCH} on a text field. Only Lucene supports MATCH for any field
        fail("No " + executionType + " stage in profile: " + stages);
 *   <li><b>DataFusion-only viable</b> — predicate references a numeric field which only
     */
 *  
            "where userID = 'u_b' OR match(message, 'gamma') | stats count() as cnt",
            "where userID = 'u_a' AND match(message, 'alpha') | stats count() as cnt",  
        long views = countOf("where event_type = 'view' | stats count() as cnt");  
        // No WHERE clause → no delegation instruction → tree_shape must be absent on both
            oracleWhere(d -> !d.userID.equals("u_a"))  
        new Doc("u_c", "view", 71, "apac", "beta beta"),
     * filter on a keyword field has no Lucene cap declared, so the operator narrows to  
     *   segment 0: u_a/click/10/us/"alpha beta", u_a/view/20/eu/"beta gamma",  
     * {@code count(field)} desugars to {@code COUNT(field) → Project(field) →
        Map<String, Object> alphaExplain = executeExplain("source = " + INDEX + " | " + alphaPpl);
     * {@link #testCountAcrossMultipleSegments} and
    public void testCountByKeywordField_drivenByDataFusion() throws Exception {
        Map<String, Object> explain = executeExplain("source = " + INDEX + " | stats count(amount) as cnt");  
        req.setJsonEntity(ndjson);
package org.opensearch.analytics.qa;
            return "{\"userID\": \""
        // Unfiltered count: no predicate, Lucene driver still picks up via metadata-only scan.
        // Single-element IN reduces to equality.  
        new Doc("u_a", "view", 20, "eu", "beta gamma"),  
    }  
        Response response = client().performRequest(req);  
    private record Doc(String userID, String eventType, long amount, String region, String message) {  
        );
    }
    /**  
            + "  \"index.pluggable.dataformat\": \"composite\","  
        assertCount("where amount = 22 | stats count() as cnt", oracleWhere(d -> d.amount == 22));
        );
    private static final List<Doc> DOCS = List.of(  
        createIndex();
        Map<String, Object> profile = (Map<String, Object>) explain.get("profile");  
     */
    public void testMixedAndFilter_keywordPlusNumeric() throws Exception {
            oracleWhere(d -> d.userID.equals("u_a") && d.eventType.equals("view") && d.region.equals("us"))
        @SuppressWarnings("unchecked")
     * NOT and not-equals on keyword. Both lower to {@code BoolQueryBuilder.mustNot} —  
        assertCount(  
        health.addParameter("wait_for_status", "green");
                + message  
    /**
        // correctness-delegation on the MATCH leaf in the same shape.
        assertCount(
            oracleWhere(d -> d.userID.equals("u_a") || d.userID.equals("u_c"))  
        assertCount("where userID = 'u_a' | stats count() as cnt", oracleWhere(d -> d.userID.equals("u_a")));  
 * <ol>  
                + "\", \"message\": \""
        new Doc("u_a", "view", 12, "us", "alpha"),
