        String andPpl = "where userID = 'u_a' AND event_type = 'click' | stats count() as cnt";
        // Term that's present in fewer docs.
        new Doc("u_b", "click", 41, "eu", "alpha"),
            "where userID = 'u_a' AND event_type = 'view' AND region = 'us' | stats count() as cnt",
        Map<String, Object> response = assertOkAndParse(client().performRequest(req), "Create index");
        Response response = client().performRequest(request);
        Response response = client().performRequest(req);
                + "\", \"region\": \""
        assertShardFragmentChoseBackend(explain, "datafusion");
 * <ol>
        assertCount(
        new Doc("u_b", "view", 40, "eu", "gamma"),
            "where match(message, 'alpha') | stats count(userID) as cnt",
     * {@code amount} field. Lucene has no doc values for it (long fields aren't in the
    }
 *   <li><b>DataFusion-only viable</b> — predicate references a numeric field which only
            int to = SEGMENT_BOUNDS[seg + 1];
            "where userID = 'u_b' OR userID = 'u_seg3_only' | stats count() as cnt",
        new Doc("u_c", "view", 60, "apac", "alpha gamma"),
            + "    \"event_type\": { \"type\": \"keyword\" },"
        );
            oracleWhere(d -> d.userID.equals("u_a") && tokenizedContains(d.message, "alpha"))
        Map<String, Object> profile = (Map<String, Object>) explain.get("profile");
        assertCount("where amount = 22 | stats count() as cnt", oracleWhere(d -> d.amount == 22));
            + "    \"region\": { \"type\": \"keyword\" },"
        String toJson() {
    }
                + eventType
import java.util.List;
            for (int i = from; i < to; i++) {
        assertStageChoseBackend(explain, "SHARD_FRAGMENT", expectedBackend);
        new Doc("u_seg3_only", "click", 42, "apac", "gamma")
            client().performRequest(new Request("DELETE", "/" + INDEX));
    private void createIndex() throws Exception {
        createIndex();
     * doesn't have it natively) or stays as a {@code delegation_possible} performance hint.
                assertNull(executionType + " unexpectedly carries tree_shape (full stage: " + stage + ")", stage.get("tree_shape"));
        new Doc("u_c", "view", 71, "apac", "beta beta"),
        assertCount("where userID = 'u_a' | stats count() as cnt", oracleWhere(d -> d.userID.equals("u_a")));
                return;
    public void testNegationFilter() throws Exception {
    private void assertCount(String pplSuffix, long expected) throws IOException {
        for (Map<String, Object> stage : stages) {
        assertCoordinatorReduceChoseBackend(explain, "datafusion");
    /**
        client().performRequest(health);
import org.opensearch.client.Request;
     * skip entirely. SHARD_FRAGMENT runs Lucene, COORDINATOR_REDUCE runs DataFusion summing
        // Zero-match: 'dave' isn't in any segment → Weight.count returns 0 per leaf.
        assertCount(
     *   segment 2: u_a/view/12/us/"alpha", u_seg3_only/click/22/eu/"beta gamma",
    /**
            oracleWhere(d -> d.region.equals("us") && d.eventType.equals("view"))
            "where userID IN ('u_a', 'u_c') | stats count() as cnt",
import java.util.Map;
    }
        assertEquals("Expected 1 row for count query: " + ppl, 1, rows.size());
     * {@code IndexSearcher.count} resolves via the term dictionary.
        ingestThreeSegments();
     * Filter(IS NOT NULL(field)) → Scan} (count of non-null values), and the {@code IS NOT NULL}
                + "\", \"amount\": "
            "where match(message, 'gamma') | stats count() as cnt",
        // FilterDelegationInstructionNode where there's no filter to delegate.
/*
        // Unfiltered count: no predicate, Lucene driver still picks up via metadata-only scan.
            oracleWhere(d -> d.userID.equals("u_seg3_only"))
    // ── Oracle helpers ──────────────────────────────────────────────────────
        assertCount(andPpl, oracleWhere(d -> d.userID.equals("u_a") && d.eventType.equals("click")));
     *              u_a/view/31/us/"gamma", u_b/click/41/eu/"alpha",
        );
        ingestThreeSegments();
        // dual-viable is in effect (count fast path forces it on).
     */
     * stage being elided into the coord stage by the planner.
    /**
    private void bulkIndex(String ndjson) throws Exception {
 * must navigate:
 *   <li><b>Full-text on a text field</b> — {@code MATCH(message, ...)} resolves only on
        assertStageChoseBackend(explain, "COORDINATOR_REDUCE", expectedBackend);
 *       the conjunctive vs disjunctive delegation, and (when the count detector matches) the
    /**
 *       Lucene's secondary inverted index and isn't reproducible by the parquet/DataFusion
            "where userID = 'u_a' AND match(message, 'alpha') | stats count() as cnt",
     * fails with "decode failed: invalid tag value".
        // the MATCH leaf delegates to Lucene per row group. Asserts both correctness and that
            + "  \"number_of_replicas\": 0,"
        assertCount("where userID = 'dave' | stats count() as cnt", 0);
     * Multi-shard count: exercises the cross-backend partition boundary that single-shard tests
}
     * <p>{@code count()} (no field) is the actual Lucene-driven path —
        ingestThreeSegments();
     */
        long total = DOCS.size();
    /**
        createIndex();
     * each so each wave becomes its own Lucene segment. Multi-segment ingest exercises the
    private static void assertStageHasNoTreeShape(Map<String, Object> explain, String executionType) {
        assertCount("stats count() as cnt", total);
        assertCount(
     * {@code count(field)} desugars to {@code COUNT(field) → Project(field) →
            oracleWhere(d -> d.userID.equals("u_a") && d.amount > 20)
        // count(field) + correctness-delegated MATCH filter: Project/Filter narrow to DF, but
        );
        ingestThreeSegments();
        assertStageHasNoTreeShape(explain, "COORDINATOR_REDUCE");
        new Doc("u_a", "click", 21, "eu", "beta"),
            oracleWhere(d -> d.userID.equals("u_a") && d.eventType.equals("view") && d.region.equals("us"))
        assertEquals("clicks + views must equal total docs (every event has one type)", total, clicks + views);
        String ppl = "source = " + INDEX + " | " + pplSuffix;
        for (String t : text.toLowerCase(java.util.Locale.ROOT).split("\\s+")) {
        assertCount(
     * <pre>
        createIndex();
        );
        // AND of two keyword EQUALS — fully Lucene-driven, combiner not invoked.
                + "}";
 *       Lucene; correctness delegation puts the predicate on Lucene's side and the count
    }
    }
     *
            if (executionType.equals(stage.get("execution_type"))) {
        );
        return assertOkAndParse(response, "EXPLAIN: " + ppl);
            "where region IN ('apac') | stats count() as cnt",
        for (Map<String, Object> stage : stages) {
            "where NOT(event_type = 'click') | stats count() as cnt",
    public void testNumericFilter_dataFusionOnly() throws Exception {
     * per-shard counts. The reducer registers each shard's partition stream against the
    /**
            + "    \"amount\": { \"type\": \"long\" }"
 *
        new Doc("u_a", "click", 30, "us", "alpha"),
     * useful invariant; backend choice is forced by the planner.
    // ── PPL helpers ─────────────────────────────────────────────────────────
        // operator EQ supported on Lucene). 'u_a' appears 7 times across all three segments.
        // covers segments where most leaves contribute zero.
            + "  \"properties\": {"
    private Map<String, Object> executePPL(String ppl) throws IOException {
     * doesn't cover LONG, so the planner never marks Lucene viable — the SHARD_FRAGMENT must
     * Either way, the count must match the oracle.
     * Predicates that only DataFusion can answer — numeric range on the parquet-backed
    }
    }
        assertCount("where userID = 'u_a' | stats count() as cnt", oracleWhere(d -> d.userID.equals("u_a")));
 * this file be licensed under the Apache-2.0 license or a
    }
        try {
    public void testInListFilter() throws Exception {
        new Doc("u_a", "view", 11, "us", "alpha alpha"),
     * Single source of truth — every assertion's oracle is computed from this list.
        String ppl = "source = " + INDEX + " | " + pplSuffix;
        Request req = new Request("PUT", "/" + INDEX);
    // ── Explain helpers ─────────────────────────────────────────────────────
                + message
 *       parquet has doc values for; Lucene is not viable for the operator and must NOT be
        fail("No " + executionType + " stage in profile: " + stages);
            oracleWhere(d -> d.userID.equals("u_a") && tokenizedContains(d.message, "alpha"))
     * Ingest in three waves (defined by {@link #SEGMENT_BOUNDS}) with force-flush between
            oracleWhere(d -> d.userID.equals("u_b") || d.amount == 42)
        );
    }
        }
        assertEquals("Bulk indexing should have no errors", false, response.get("errors"));
        ingestThreeSegments();
    private static final List<Doc> DOCS = List.of(
        new Doc("u_seg3_only", "view", 32, "eu", "alpha"),
            oracleWhere(d -> !d.eventType.equals("click"))
        createIndex();
    );
        long total = DOCS.size();
        long total = DOCS.size();
 *   <li><b>Lucene-only viable</b> — predicate references a keyword/text field that lives in
        assertShardFragmentChoseBackend(explain, "datafusion");
        assertEquals(true, response.get("acknowledged"));
        return assertOkAndParse(response, "PPL: " + ppl);
        assertCount(
 *
        assertShardFragmentChoseBackend(alphaExplain, "lucene");
        @SuppressWarnings("unchecked")
            + ","
        new Doc("u_c", "click", 81, "us", "alpha"),
        long total = DOCS.size();
            + "\"settings\": {"
     * {@code count(field)} on a numeric field where {@code amount} only has parquet doc values.
     * </pre>
     */
    }
        assertCount(
            oracleWhere(d -> tokenizedContains(d.message, "gamma"))
    public void testCountByNumericField_drivenByDataFusion() throws Exception {
        // Three-way AND across keyword fields exercises BoolQueryBuilder with multiple MUST clauses.
        );
        new Doc("u_b", "view", 51, "us", "alpha beta"),
            bulkIndex(docs(batch));
            "source = " + INDEX + " | where match(message, 'alpha') | stats count(userID) as cnt"
     * Substrait stub from {@code LuceneFragmentConvertor.convertSchemaOnlyRead}; if Lucene's
        // one fused BoolQueryBuilder. Picks up perf-delegation on the keyword leaf and
        new Doc("u_seg3_only", "click", 22, "eu", "beta gamma"),
        );
     */
    }
        );
        return ((Number) rows.get(0).get(0)).longValue();
            + "    \"userID\": { \"type\": \"keyword\" },"
    private static String docs(String... documents) {
            }
     * per-leaf {@code Weight.count} summation inside {@code IndexSearcher.count}.
        assertCount("where amount > 50 | stats count() as cnt", oracleWhere(d -> d.amount > 50));
        assertCount(alphaPpl, oracleWhere(d -> tokenizedContains(d.message, "alpha")));
        String alphaPpl = "where match(message, 'alpha') | stats count() as cnt";
            "where userID = 'u_a' AND match(message, 'alpha') | stats count() as cnt",
        req.setJsonEntity(ndjson);
            + "},"
        fail("No " + executionType + " stage in profile: " + stages);
        Request request = new Request("POST", "/_analytics/ppl/_explain");
 * <p>Run with:
        new Doc("u_a", "view", 31, "us", "gamma"),
                    executionType + " chose unexpected backend (full stage: " + stage + ")",
                    expectedBackend,
     * still Lucene-viable, still the fast path.
    }
        health.addParameter("wait_for_status", "green");
            + "    \"message\": { \"type\": \"text\" },"
        assertCount(
package org.opensearch.analytics.qa;
     * {@code count(field)} on a keyword field — DataFusion drives by design. PPL's
    }
                + "\", \"message\": \""
 *       picked. The DataFusion engine path runs.</li>
    private static final int[] SEGMENT_BOUNDS = { 0, 7, 15, DOCS.size() };
     */
            oracleWhere(d -> d.userID.equals("u_a") || d.userID.equals("u_c"))
    }
            flush();
            oracleWhere(d -> !d.userID.equals("u_a"))
 *   <li><b>Mixed AND/OR</b> — leaves split between backends. {@code FilterTreeShape} drives
        assertCount("stats count() as cnt", total);
 * End-to-end tests for the count fast path covering the four shape buckets the planner
        // Coverage parity: every doc has exactly one event_type, so click_count + view_count = total.
        ingestThreeSegments();
     * Filter, so the keyword leaf either correctness-delegates to Lucene (when DataFusion
        }
        // Combined with a keyword filter — both delegate to Lucene, fused into one BoolQueryBuilder.
            + "  }"
            + "  \"index.pluggable.dataformat.enabled\": true,"
        health.addParameter("timeout", "30s");
     * DataFusion only. Asserting on row correctness (DF computes the right count) is the
        assertCount(
    }
        return sb.toString();
        // OR across backends — the combiner declines to fuse under disjunction unless
import org.opensearch.client.Response;
    /** Asserts the named stage has no {@code tree_shape} field — i.e. no delegation instruction. */
 * compatible open source license.
        );
     *              u_seg3_only/view/32/eu/"alpha", u_seg3_only/click/42/apac/"gamma"
        List<Map<String, Object>> stages = (List<Map<String, Object>>) profile.get("stages");
            return "{\"userID\": \""
    }
                );
        Request req = new Request("POST", "/" + INDEX + "/_bulk");
        new Doc("u_a", "click", 10, "us", "alpha beta"),
     *
        ingestThreeSegments();
            "where region = 'us' AND event_type = 'view' | stats count() as cnt",
        // Single-element IN reduces to equality.
        // correctness sibling into one Lucene shipment under OR; the count is unaffected.
     *              u_b/view/51/us/"alpha beta", u_c/click/61/apac/"gamma alpha",
            + "\"mappings\": {"
 * <p>Multi-segment ingest exercises Lucene's per-leaf {@code Weight.count(LeafReaderContext)}
        assertNotNull("profile present", profile);
    private static void assertShardFragmentChoseBackend(Map<String, Object> explain, String expectedBackend) {
        createIndex();
    }
        for (int seg = 0; seg < SEGMENT_BOUNDS.length - 1; seg++) {
        );
        Map<String, Object> alphaExplain = executeExplain("source = " + INDEX + " | " + alphaPpl);
    private void flush() throws Exception {
            sb.append("{\"index\": {}}\n").append(d).append("\n");
    /** Asserts the COORDINATOR_REDUCE stage in {@code explain.profile.stages} chose the given backend. */
        // Single keyword equality (Lucene-only viable: keyword has indexFormats=[lucene],
            "where userID = 'u_b' OR match(message, 'gamma') | stats count() as cnt",
     *   segment 0: u_a/click/10/us/"alpha beta", u_a/view/20/eu/"beta gamma",
    }
            + "  \"index.pluggable.dataformat\": \"composite\","
        req.setJsonEntity("{\"query\": \"" + escapeJson(ppl) + "\"}");
     * Mixed-backend AND: keyword-side leaf (Lucene viable) AND numeric-side leaf
            + "  \"index.composite.primary_data_format\": \"parquet\","
        assertCount(
    public void testKeywordBooleanFilter_luceneFused() throws Exception {
            }
     * STANDARD_TYPES set), so the planner must drop Lucene from the alternative list and
            + numberOfShards
        assertCount(
import java.io.IOException;
        Map<String, Object> profile = (Map<String, Object>) explain.get("profile");
     * <p>Three shards is enough to make the bug deterministic — fewer shards risk Lucene's
        long actual = countOf(pplSuffix);
 * SPDX-License-Identifier: Apache-2.0
 * The OpenSearch Contributors require contributions made to
    }
                assertEquals(
        req.addParameter("refresh", "true");
    }
 *
        long clicks = countOf("where event_type = 'click' | stats count() as cnt");
    public void testCountByKeywordField_drivenByDataFusion() throws Exception {
        assertCount("stats count(userID) as cnt", total);
 * {@code ./gradlew :sandbox:qa:analytics-engine-rest:integTest --tests "*.CountFastPathIT" -Dsandbox.enabled=true}
    private Map<String, Object> executeExplain(String ppl) throws IOException {
     *   segment 1: u_a/view/11/us/"alpha alpha", u_a/click/21/eu/"beta",
     * (DataFusion-only). The numeric leaf forces DataFusion as the operator backend on the
        Request req = new Request("POST", "/_analytics/ppl");
    private static void assertCoordinatorReduceChoseBackend(Map<String, Object> explain, String expectedBackend) {
    @SuppressWarnings("unchecked")
            oracleWhere(d -> d.userID.equals("u_b") || d.userID.equals("u_seg3_only"))
        assertNotNull("Response missing 'rows' for: " + ppl, rows);
            "where userID = 'u_seg3_only' | stats count() as cnt",
 *
                + amount
    /**
 */
 * </ol>
     */
        assertStageHasNoTreeShape(explain, "SHARD_FRAGMENT");
            oracleWhere(d -> tokenizedContains(d.message, "alpha"))
     */
        createIndex();
     *              u_c/click/70/apac/"beta"
        // stages. Pins that the multi-shard reducer path doesn't accidentally synthesize a
        createIndex();
 *       fast path runs.</li>
     *              u_b/click/50/us/"alpha beta gamma", u_c/view/60/apac/"alpha gamma",
        }
        assertCount(
        assertShardFragmentChoseBackend(explain, "lucene");
            if (t.equals(token)) return true;
                return;
 *       column scan. Lucene drives end-to-end via {@code LuceneSearchExecEngine}.</li>
            if (executionType.equals(stage.get("execution_type"))) {
    public void testFullTextMatchFilter() throws Exception {
        new Doc("u_a", "view", 20, "eu", "beta gamma"),
     * filter on a keyword field has no Lucene cap declared, so the operator narrows to
            + "  \"index.composite.secondary_data_formats\": \"lucene\""
        Map<String, Object> andExplain = executeExplain("source = " + INDEX + " | " + andPpl);
        client().performRequest(new Request("POST", "/" + INDEX + "/_flush?force=true"));
        createIndex(1);
    }
            + "  \"number_of_shards\": "
 * summation. Each test method computes its own oracle from {@link #DOCS} so adding rows in
                + userID
 *       combiner fuses both sides into one Lucene query.</li>
        }
        return false;
    private static boolean tokenizedContains(String text, String token) {
        new Doc("u_c", "click", 70, "apac", "beta"),
        request.setJsonEntity("{\"query\": \"" + escapeJson(ppl) + "\"}");
        );
    private long countOf(String pplSuffix) throws IOException {
     */
        assertCount("stats count(amount) as cnt", total);
    /** Asserts the SHARD_FRAGMENT stage in {@code explain.profile.stages} chose the given backend. */
        Map<String, Object> response = assertOkAndParse(client().performRequest(req), "Bulk index");
    /**
        Map<String, Object> explain = executeExplain("source = " + INDEX + " | stats count(amount) as cnt");
        ingestThreeSegments();
        // segment 1
    // ── Setup ───────────────────────────────────────────────────────────────
        // Validates the count(*) fast path through Lucene's IndexReader.numDocs.
     */
        for (String d : documents) {
    /**
        );
            "where userID != 'u_a' | stats count() as cnt",
        );
    @SuppressWarnings("unchecked")
        new Doc("u_c", "click", 61, "apac", "gamma alpha"),
                + "\", \"event_type\": \""
        ingestThreeSegments();
     * picks Lucene because the field has {@code indexFormats=[lucene]} (BKD points).
        // No WHERE clause → no delegation instruction → tree_shape must be absent on both
        } catch (Exception ignored) {}
public class CountFastPathIT extends AnalyticsRestTestCase {
    private static final String INDEX = "count_fast_path_e2e";
    private static long oracleWhere(java.util.function.Predicate<Doc> p) {
     * non-Substrait wire bytes leak into {@code derive_schema_from_partial_plan}, this test
     * Lucene's {@code Index(supportedFieldTypes={KEYWORD, TEXT, MATCH_ONLY_TEXT})}
        assertShardFragmentChoseBackend(andExplain, "lucene");
    }
        String body = "{"
            oracleWhere(d -> d.region.equals("apac"))
     * Layout (segment splits in {@link #ingestThreeSegments}):
     * be DataFusion. Catches the planner-level regression where a numeric scan accidentally
     * the DataFusion engine path runs end-to-end. Asserted via correctness of the count.
    public void testCountAcrossMultipleShards_luceneShardsToDataFusionReduce() throws Exception {
        req.setJsonEntity(body);
        StringBuilder sb = new StringBuilder();
        );
 */
     *              u_c/view/71/apac/"beta beta", u_c/click/81/us/"alpha"
     * IN-list lowers to {@code BoolQueryBuilder.should} (term-set query) on Lucene.
        assertShardFragmentChoseBackend(mixedExplain, "datafusion");
    }
        return DOCS.stream().filter(p).count();
        new Doc("u_a", "view", 12, "us", "alpha"),
    /** Range of doc indices that go into each segment (start inclusive, end exclusive). */
     * {@link #testCountAcrossMultipleShards_luceneShardsToDataFusionReduce} cover that.
    public void testMixedAndFilter_keywordPlusNumeric() throws Exception {
        assertCount(
        List<List<Object>> rows = (List<List<Object>>) result.get("rows");
        Map<String, Object> mixedExplain = executeExplain(
     *              u_a/click/30/us/"alpha", u_b/view/40/eu/"gamma",
    }
     * type, so the planner chooses Lucene and ships the predicate as a NamedWriteable
        Map<String, Object> result = executePPL(ppl);
        Request health = new Request("GET", "/_cluster/health/" + INDEX);
        // the SHARD_FRAGMENT remains DataFusion-driven (delegation, not driver collapse).
        Map<String, Object> explain = executeExplain("source = " + INDEX + " | stats count(userID) as cnt");
     */
     * Full-text {@code MATCH} on a text field. Only Lucene supports MATCH for any field
        assertCount(
        // segment 2
    /** Standard-analyzer-equivalent: token equality on whitespace splits. */
        createIndex(3);
    private void createIndex(int numberOfShards) throws Exception {
        assertCount(
        // correctness-delegation on the MATCH leaf in the same shape.
        }
        // Single-segment-only term: 'u_seg3_only' only in segment 2. Per-leaf summation
        assertCount(
     * Pure Lucene-side AND/OR over keyword fields. Both leaves are correctness-delegated to
     * {@link #testCountAcrossMultipleSegments} and
        new Doc("u_b", "click", 50, "us", "alpha beta gamma"),
     */
                    stage.get("chosen_backend")
        );
        }
        // Empty range — every doc's amount > 0, so amount<0 is empty.
        // 'alpha' appears in many docs; oracle counts whitespace-tokenised occurrences.
        assertNotNull("stages present", stages);
     * Lucene; the combiner emits a single fused {@code BoolQueryBuilder} which Lucene's
 * one place doesn't silently break a different assertion.
    }
    private static void assertStageChoseBackend(Map<String, Object> explain, String executionType, String expectedBackend) {
            "where userID = 'u_b' OR amount = 42 | stats count() as cnt",
     * {@code MatchQueryBuilder}.
        assertCount("where amount >= 50 | stats count() as cnt", oracleWhere(d -> d.amount >= 50));
    }
    }
        createIndex();
            "where userID = 'u_a' AND amount > 20 | stats count() as cnt",
    private void ingestThreeSegments() throws Exception {
        // EQUALS + MATCH on keyword + text — both Lucene-resolvable; combiner ships them as
        long views = countOf("where event_type = 'view' | stats count() as cnt");
                + region
        assertCount("where amount < 0 | stats count() as cnt", 0);
        List<Map<String, Object>> stages = (List<Map<String, Object>>) profile.get("stages");
    /**
        Map<String, Object> explain = executeExplain("source = " + INDEX + " | stats count() as cnt");
        assertEquals("Count mismatch for: " + ppl, expected, actual);
            + "}"
/**
            int from = SEGMENT_BOUNDS[seg];
            oracleWhere(d -> d.userID.equals("u_b") || tokenizedContains(d.message, "gamma"))
        createIndex();
    public void testCountAcrossMultipleSegments() throws Exception {
            }
    /**
            String[] batch = new String[to - from];
        ingestThreeSegments();
        // OR mixing keyword EQUALS with MATCH — the dual-viable EQUALS fuses with the MATCH
    // ── Document model ──────────────────────────────────────────────────────
                batch[i - from] = DOCS.get(i).toJson();
    private record Doc(String userID, String eventType, long amount, String region, String message) {
        req.setOptions(req.getOptions().toBuilder().addHeader("Content-Type", "application/x-ndjson").build());
            + "}";
        // segment 0
     * NOT and not-equals on keyword. Both lower to {@code BoolQueryBuilder.mustNot} —
