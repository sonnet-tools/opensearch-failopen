        QueryBuilder query = QueryBuilders.boolQuery()
                return query;
import static org.mockito.Mockito.mock;
        BoolQueryBuilder mb = (BoolQueryBuilder) merged;
        // Test that if a rewriter throws an exception, others still run
                        rewritten.filter(rewrittenClause);
                    boolean changed = false;
                        rewritten.mustNot(rewrittenClause);
            .must(QueryBuilders.termQuery("field1", "value1"))
            .filter(
                    rewritten.queryName(boolQuery.queryName());
        boolean hasRangeFilter = false;
                    for (QueryBuilder mustNot : boolQuery.mustNot()) {
                }
                    TermQueryBuilder termQuery = (TermQueryBuilder) query;
                if (query instanceof TermQueryBuilder) {
                return "test_custom_rewriter";
        ClusterSettings clusterSettings = new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
            .mustNot(QueryBuilders.termQuery("status", "discontinued"));
                        rewritten.should(rewrittenClause);
            @Override
        // Should be all individual term queries now
                    for (QueryBuilder filter : boolQuery.filter()) {
                    }
        assertTrue(result.filter().size() >= 1);
        BoolQueryBuilder rewrittenBool = (BoolQueryBuilder) rewritten;
        // - match_all should be removed in non-scoring contexts
            } else if (filter instanceof RangeQueryBuilder) {
                QueryBuilders.boolQuery()
            .filter(QueryBuilders.termQuery("type", "service"));
        QueryRewriterRegistry.INSTANCE.registerRewriter(customRewriter);
                    .filter(QueryBuilders.termQuery("category", "electronics"))
import org.opensearch.common.settings.ClusterSettings;
                } else if (query instanceof BoolQueryBuilder) {
                QueryBuilders.boolQuery()
        Settings settings = Settings.builder().put(SearchService.QUERY_REWRITING_ENABLED_SETTING.getKey(), false).build();
        // The custom rewriter should have replaced the term query
        QueryRewriterRegistry.INSTANCE.initialize(settings, clusterSettings);
import org.opensearch.index.query.QueryBuilders;
                            .filter(QueryBuilders.termQuery("status", "pending"))
        // - The nested bool in must clause should be flattened
                QueryBuilders.boolQuery()
        clusterSettings.applySettings(Settings.builder().put(SearchService.QUERY_REWRITING_ENABLED_SETTING.getKey(), true).build());
    public void testVeryComplexMixedQuery() {
            )
                    )
        QueryBuilder once = QueryRewriterRegistry.INSTANCE.rewrite(q, context);
                    rewritten.adjustPureNegative(boolQuery.adjustPureNegative());
        assertNull(rewritten);
            .should(QueryBuilders.termQuery("category", "important"))
                            .filter(QueryBuilders.termQuery("status", "approved"))
        QueryRewriter customRewriter = new QueryRewriter() {
                    .must(QueryBuilders.matchAllQuery())
            @Override
    public void testCustomRewriterRegistration() {
            public QueryBuilder rewrite(QueryBuilder query, QueryShardContext context) {
            .must(QueryBuilders.termQuery("field", "value"))
                    .should(QueryBuilders.termQuery("brand", "apple"))
    }
                QueryBuilders.boolQuery()
        assertTrue(result.must().size() >= 1);
        QueryBuilder rewritten = QueryRewriterRegistry.INSTANCE.rewrite(deeplyNested, context);
        // Even if one rewriter fails, others should still be applied
        // Should have:
import org.opensearch.index.query.QueryShardContext;
                        if (rewrittenClause != must) changed = true;
        assertThat(rewrittenBool.must().get(0), instanceOf(TermQueryBuilder.class));
        assertThat(rewrittenBool.must().size(), equalTo(1));
            .filter(QueryBuilders.termQuery("type", "product"))
        ClusterSettings clusterSettings = new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        assertThat(mustTerm.fieldName(), equalTo("custom_field"));
            .filter(QueryBuilders.matchAllQuery());
        assertThat(rewrittenBool.must().get(1), instanceOf(TermQueryBuilder.class));
        }
                    .must(
    }
        assertNotSame(query, rewritten2);
            @Override
    public void testRewriterPriorityOrder() {
        assertTrue(hasRangeFilter);
        assertEquals(16, nmb.filter().size());
        // Enable via settings update
        };
        QueryBuilder rewritten = QueryRewriterRegistry.INSTANCE.rewrite(query, context);
    }
        assertEquals(once.toString(), twice.toString());
                        QueryBuilder rewrittenClause = rewrite(mustNot, context);
                QueryBuilders.boolQuery()
            }
                    .should(QueryBuilders.termQuery("priority", "low"))
        // Test that we log performance metrics in debug mode
            }
        assertThat(rewrittenBool.must().size(), equalTo(2)); // two term queries for status
                    .should(QueryBuilders.termQuery("brand", "dell"))
        // Verify optimizations were applied
import static org.hamcrest.Matchers.instanceOf;
            .must(QueryBuilders.termQuery("status", "active"))
        // Register the custom rewriter
        assertThat(rewrittenBool.filter().get(0), instanceOf(TermQueryBuilder.class));
            .must(QueryBuilders.matchAllQuery())
import org.opensearch.index.query.TermQueryBuilder;
        QueryRewriterRegistry.INSTANCE.initialize(newSettings, new ClusterSettings(newSettings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS));
    public void testComplexRealWorldQuery() {
        assertThat(rewritten, instanceOf(BoolQueryBuilder.class));
    }
        // Composition order smoke check: must_to_filter should not move term queries in must
 * compatible open source license.
        assertThat(result.minimumShouldMatch(), equalTo("1"));
    @Override
        assertSame(query, rewritten);
        QueryBuilder query = QueryBuilders.boolQuery()
        QueryBuilder rewritten2 = QueryRewriterRegistry.INSTANCE.rewrite(query, context);
                            .filter(QueryBuilders.termQuery("type", "B"))
            .filter(
                    // Copy settings
        TermQueryBuilder mustTerm = (TermQueryBuilder) rewrittenBool.must().get(0);
        assertThat(rewrittenBool.filter().get(1), instanceOf(TermQueryBuilder.class));
                            .filter(QueryBuilders.termQuery("status", "active"))
}
            .filter(QueryBuilders.boolQuery().filter(QueryBuilders.termQuery("g", "w")))
            .must(QueryBuilders.termQuery("field1", "value2"))
import org.opensearch.index.query.BoolQueryBuilder;
        QueryBuilder rewritten = QueryRewriterRegistry.INSTANCE.rewrite(query, context);
            if (filter instanceof BoolQueryBuilder) {
        // Test disabled rewriting via settings
        // Build a query at threshold=16 that merges, then raise threshold to 32 and assert no merge
                    }
        BoolQueryBuilder rewrittenBool = (BoolQueryBuilder) rewritten;
                        QueryBuilder rewrittenClause = rewrite(should, context);
        // Create a custom rewriter for testing
        QueryRewriterRegistry.INSTANCE.initialize(settings, clusterSettings);
        assertThat(rewrittenBool.filter().size(), equalTo(2));
        assertThat(rewritten, instanceOf(BoolQueryBuilder.class));
                        QueryBuilders.boolQuery()
        // Should have flattened structure and merged terms
        // - Flattened nested boolean
                    .filter(QueryBuilders.termQuery("category", "computers"))
        // Now it should rewrite
        // Test that rewriters are applied in correct order
 *
        // After rewriting:
            .filter(QueryBuilders.matchAllQuery());
            query.filter(QueryBuilders.termQuery("f", "v" + i));
        BoolQueryBuilder rewrittenBool = (BoolQueryBuilder) rewritten;
        super.setUp();
        assertThat(rewritten, instanceOf(BoolQueryBuilder.class));
            .put(SearchService.QUERY_REWRITING_ENABLED_SETTING.getKey(), true)
        // Test that all rewriters work together correctly
                    .must(QueryBuilders.termQuery("field", "value1"))
            public int priority() {
            .must(QueryBuilders.boolQuery().must(QueryBuilders.termQuery("f", "v")))
        // - term queries should be merged into terms query in filter contexts
        BoolQueryBuilder result = (BoolQueryBuilder) rewritten;
            )
public class QueryRewriterRegistryTests extends OpenSearchTestCase {
        QueryBuilder query = QueryBuilders.boolQuery()
                        // Replace with a different query
        // Test a very complex query with all optimizations applicable
        Settings settings = Settings.builder()
        QueryBuilder merged = QueryRewriterRegistry.INSTANCE.rewrite(query, context);
    public void testRegistryIdempotence() {
                        if (rewrittenClause != should) changed = true;
                    }
        QueryBuilder query = QueryBuilders.boolQuery()
import org.opensearch.test.OpenSearchTestCase;
        assertThat(rewrittenBool.mustNot().size(), equalTo(1));
        // - Removed match_all queries
        // Must not should be preserved
/*
        // This is handled internally by QueryRewriterRegistry
        QueryBuilder rewritten = QueryRewriterRegistry.INSTANCE.rewrite(query, context);
                        QueryBuilder rewrittenClause = rewrite(must, context);
                    .should(QueryBuilders.termQuery("brand", "hp"))
        // Should be one terms query
        QueryBuilder notMerged = QueryRewriterRegistry.INSTANCE.rewrite(query, context);
        BoolQueryBuilder nmb = (BoolQueryBuilder) notMerged;
        // Null query should return null
            .must(
        // Test a complex real-world-like query
        // - The filter bool with brand terms should be preserved
    public void testCompleteRewritingPipeline() {
        // terms_merging should not merge terms in must; only in filter/should contexts
        assertNotNull(rewritten);
                    }
    }
        // Increase threshold
        BoolQueryBuilder rewrittenBool = (BoolQueryBuilder) rewritten;
        QueryBuilder query = QueryBuilders.boolQuery()
                    BoolQueryBuilder rewritten = new BoolQueryBuilder();
                    }
                        rewritten.must(rewrittenClause);
            .mustNot(QueryBuilders.boolQuery().must(QueryBuilders.termQuery("archived", "true")))
            }
        QueryBuilder q = QueryBuilders.boolQuery()
        assertEquals(1, mb.filter().size());
                    .must(QueryBuilders.matchAllQuery())
        assertNotNull(rewritten);
        QueryBuilder rewritten = QueryRewriterRegistry.INSTANCE.rewrite(query, context);
                    rewritten.minimumShouldMatch(boolQuery.minimumShouldMatch());
    public void testNullQuery() {
        assertThat(termCount, equalTo(2L));
                return 1000; // High priority to ensure it runs last
package org.opensearch.search.query;
            .put(SearchService.QUERY_REWRITING_TERMS_THRESHOLD_SETTING.getKey(), 16)
            .must(QueryBuilders.rangeQuery("price").gte(500).lte(2000))
    }
        // Create a query that will be affected by multiple rewriters
            .must(nestedBool)
                    for (QueryBuilder must : boolQuery.must()) {
            );
                            .must(QueryBuilders.matchAllQuery())
        // Test that it's applied
                    .must(QueryBuilders.termQuery("field", "value2"))
        assertThat(rewritten, instanceOf(BoolQueryBuilder.class));
    public void testDynamicTermsThresholdUpdate() {
            .must(QueryBuilders.matchAllQuery())
            .should(QueryBuilders.termQuery("category", "urgent"))
 * SPDX-License-Identifier: Apache-2.0
                        return QueryBuilders.termQuery("custom_field", "custom_value");
                    .should(QueryBuilders.termQuery("priority", "medium"))
            .filter(QueryBuilders.termQuery("field", "value"));
import org.opensearch.search.SearchService;
                    .must(
                    BoolQueryBuilder boolQuery = (BoolQueryBuilder) query;
    public void testPerformanceMetrics() {
    public void testDisabledRewriting() {
        assertNotSame(query, rewritten);
        // Initialize with disabled setting
 * The OpenSearch Contributors require contributions made to
        // Should be flattened first. Match_all may be removed depending on context; terms NOT merged in must context
    }
        assertThat(mustTerm.value(), equalTo("custom_value"));
import org.opensearch.common.settings.Settings;
                    for (QueryBuilder should : boolQuery.should()) {
                    // Recursively rewrite clauses
    }
        assertTrue(hasBoolFilter);
        QueryBuilder nestedBool = QueryBuilders.boolQuery()
                    // Recursively apply to nested queries
                        if (rewrittenClause != filter) changed = true;
        // Initialize registry with default settings
        assertThat(rewritten, instanceOf(BoolQueryBuilder.class));
            .filter(QueryBuilders.matchAllQuery())
        // - The range query should be moved from must to filter by MustToFilterRewriter
import static org.hamcrest.Matchers.equalTo;
        QueryBuilder rewritten = QueryRewriterRegistry.INSTANCE.rewrite(query, context);
                        QueryBuilder rewrittenClause = rewrite(filter, context);
            .must(QueryBuilders.termQuery("status", "pending"));
        assertThat(rewrittenBool.filter().size(), equalTo(2)); // two term queries for type (below threshold)
        // This is more of a sanity check that the timing code doesn't throw exceptions
                    .should(QueryBuilders.termQuery("priority", "high"))
            .build();
            )
        // Check that minimum should match is preserved
        assertThat(rewrittenBool.must().size(), equalTo(1));
    private final QueryShardContext context = mock(QueryShardContext.class);
import org.opensearch.index.query.QueryBuilder;
            .should(QueryBuilders.termQuery("h", "u"));
                        if (rewrittenClause != mustNot) changed = true;
        QueryBuilder rewritten = QueryRewriterRegistry.INSTANCE.rewrite(null, context);
                    return changed ? rewritten : query;
            .must(QueryBuilders.matchAllQuery())
            )
    }
            .must(QueryBuilders.termQuery("test_field", "test_value"))
        // Check must clauses (should have terms query for category only - range moved to filter)
            .filter(QueryBuilders.termQuery("other_field", "other_value"));
        for (QueryBuilder filter : rewrittenBool.filter()) {
                hasRangeFilter = true;
        Settings newSettings = Settings.builder().put(SearchService.QUERY_REWRITING_TERMS_THRESHOLD_SETTING.getKey(), 32).build();
                    if ("test_field".equals(termQuery.fieldName()) && "test_value".equals(termQuery.value())) {
                            .filter(QueryBuilders.termQuery("type", "A"))
    public void testRewriterErrorHandling() {
    }
        // One should be the brand bool query
        QueryBuilder query = QueryBuilders.boolQuery()
            .must(
        boolean hasBoolFilter = false;
            .must(
        QueryBuilder deeplyNested = QueryBuilders.boolQuery()
        // Should not throw any exceptions
            .minimumShouldMatch(1);
        QueryBuilder twice = QueryRewriterRegistry.INSTANCE.rewrite(once, context);
        BoolQueryBuilder query = QueryBuilders.boolQuery();
        for (int i = 0; i < 16; i++) {
        QueryBuilder query = QueryBuilders.boolQuery()
        QueryBuilder rewritten = QueryRewriterRegistry.INSTANCE.rewrite(query, context);
        long termCount = rewrittenBool.must().stream().filter(q -> q instanceof TermQueryBuilder).count();
 * this file be licensed under the Apache-2.0 license or a
    }
import org.opensearch.index.query.RangeQueryBuilder;
        assertThat(rewrittenBool.must().get(0), instanceOf(TermQueryBuilder.class));
                    )
        QueryBuilder rewritten = QueryRewriterRegistry.INSTANCE.rewrite(query, context);
            .filter(QueryBuilders.matchAllQuery())
                hasBoolFilter = true;
    }
            }
 */
            public String name() {
        }
        // Check filter clauses (should have the brand bool query AND the range query)
                    rewritten.boost(boolQuery.boost());
    public void setUp() throws Exception {
        // - Terms in must clauses are NOT merged (semantically different)
                        QueryBuilders.boolQuery()
