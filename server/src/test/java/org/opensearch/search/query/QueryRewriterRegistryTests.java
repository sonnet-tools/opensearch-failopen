            .must(QueryBuilders.termQuery("test_field", "test_value"))
                QueryBuilders.boolQuery()  
            .must(QueryBuilders.termQuery("status", "pending"));
        assertNotNull(rewritten);
                    )  
    }
        assertThat(rewrittenBool.must().get(1), instanceOf(TermQueryBuilder.class));
                        QueryBuilders.boolQuery()
            .should(QueryBuilders.termQuery("h", "u"));  
                            .filter(QueryBuilders.termQuery("type", "A"))
        // Test disabled rewriting via settings  
            )
            .must(QueryBuilders.termQuery("field1", "value2"))
        assertThat(rewritten, instanceOf(BoolQueryBuilder.class));
                    .should(QueryBuilders.termQuery("brand", "hp"))
                    .filter(QueryBuilders.termQuery("category", "computers"))
        assertThat(rewrittenBool.must().get(0), instanceOf(TermQueryBuilder.class));  
        // Must not should be preserved
import static org.hamcrest.Matchers.equalTo;  
        assertThat(rewritten, instanceOf(BoolQueryBuilder.class));  
        super.setUp();
    }  
                } else if (query instanceof BoolQueryBuilder) {
    }
        QueryBuilder rewritten = QueryRewriterRegistry.INSTANCE.rewrite(query, context);
        for (QueryBuilder filter : rewrittenBool.filter()) {
        assertThat(rewrittenBool.filter().size(), equalTo(2));  
                    }  
    public void testRegistryIdempotence() {
            }
                        rewritten.should(rewrittenClause);
                    .must(QueryBuilders.termQuery("field", "value1"))
            .must(QueryBuilders.rangeQuery("price").gte(500).lte(2000))  
        QueryRewriterRegistry.INSTANCE.initialize(newSettings, new ClusterSettings(newSettings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS));  
        assertTrue(result.must().size() >= 1);
            .filter(QueryBuilders.termQuery("type", "service"));
            .minimumShouldMatch(1);  
import org.opensearch.index.query.RangeQueryBuilder;
    }  
        // Build a query at threshold=16 that merges, then raise threshold to 32 and assert no merge
                    for (QueryBuilder mustNot : boolQuery.mustNot()) {
import org.opensearch.common.settings.Settings;
        QueryBuilder query = QueryBuilders.boolQuery()
            if (filter instanceof BoolQueryBuilder) {
        // The custom rewriter should have replaced the term query  
            );
        QueryBuilder deeplyNested = QueryBuilders.boolQuery()
        // - Removed match_all queries
                        rewritten.mustNot(rewrittenClause);
    public void testRewriterPriorityOrder() {
        // Even if one rewriter fails, others should still be applied
        QueryBuilder rewritten = QueryRewriterRegistry.INSTANCE.rewrite(null, context);
        assertThat(termCount, equalTo(2L));  
        boolean hasRangeFilter = false;  
        BoolQueryBuilder rewrittenBool = (BoolQueryBuilder) rewritten;
    public void testVeryComplexMixedQuery() {
            .should(QueryBuilders.termQuery("category", "important"))
            }  
                    // Copy settings  
                QueryBuilders.boolQuery()  
            .filter(QueryBuilders.matchAllQuery())
            .must(nestedBool)
        assertThat(rewrittenBool.must().size(), equalTo(1));
        ClusterSettings clusterSettings = new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
                return 1000; // High priority to ensure it runs last  
        QueryBuilder rewritten2 = QueryRewriterRegistry.INSTANCE.rewrite(query, context);  
        // Null query should return null  
        assertTrue(hasRangeFilter);  
        QueryBuilder merged = QueryRewriterRegistry.INSTANCE.rewrite(query, context);
                    TermQueryBuilder termQuery = (TermQueryBuilder) query;
    private final QueryShardContext context = mock(QueryShardContext.class);  
    public void testNullQuery() {
                            .filter(QueryBuilders.termQuery("type", "B"))
    public void testRewriterErrorHandling() {
        Settings settings = Settings.builder()  
        assertThat(rewrittenBool.filter().get(1), instanceOf(TermQueryBuilder.class));
                    for (QueryBuilder must : boolQuery.must()) {
        QueryRewriterRegistry.INSTANCE.registerRewriter(customRewriter);
        assertThat(rewritten, instanceOf(BoolQueryBuilder.class));  
                    .must(QueryBuilders.matchAllQuery())
        assertThat(rewrittenBool.must().size(), equalTo(2)); // two term queries for status
                    // Recursively rewrite clauses  
            .must(QueryBuilders.termQuery("field1", "value1"))
            .filter(QueryBuilders.termQuery("type", "product"))  
            @Override  
            .filter(QueryBuilders.termQuery("other_field", "other_value"));  
        BoolQueryBuilder nmb = (BoolQueryBuilder) notMerged;  
        // - term queries should be merged into terms query in filter contexts
        Settings settings = Settings.builder().put(SearchService.QUERY_REWRITING_ENABLED_SETTING.getKey(), false).build();
            query.filter(QueryBuilders.termQuery("f", "v" + i));
        assertThat(rewrittenBool.filter().size(), equalTo(2)); // two term queries for type (below threshold)  
/*  
            } else if (filter instanceof RangeQueryBuilder) {
                    }
        // Register the custom rewriter  
import static org.hamcrest.Matchers.instanceOf;
        // Increase threshold
    }  
                        QueryBuilder rewrittenClause = rewrite(mustNot, context);  
        BoolQueryBuilder mb = (BoolQueryBuilder) merged;  
        // - The nested bool in must clause should be flattened
        QueryBuilder rewritten = QueryRewriterRegistry.INSTANCE.rewrite(query, context);  
 * SPDX-License-Identifier: Apache-2.0
        assertNotSame(query, rewritten2);
        // Should have flattened structure and merged terms  
                        if (rewrittenClause != filter) changed = true;
        // Enable via settings update
            )
            .must(
        BoolQueryBuilder rewrittenBool = (BoolQueryBuilder) rewritten;
            .must(
        QueryBuilder query = QueryBuilders.boolQuery()  
                return query;
            .filter(QueryBuilders.termQuery("field", "value"));  
public class QueryRewriterRegistryTests extends OpenSearchTestCase {
            .filter(  
import org.opensearch.index.query.QueryBuilders;
            .must(QueryBuilders.matchAllQuery())
    @Override
import org.opensearch.common.settings.ClusterSettings;
                QueryBuilders.boolQuery()
        // - The range query should be moved from must to filter by MustToFilterRewriter  
            .must(  
            }  
                    rewritten.minimumShouldMatch(boolQuery.minimumShouldMatch());  
                    // Recursively apply to nested queries
            }
            .filter(  
    }
        assertThat(mustTerm.value(), equalTo("custom_value"));
        // Should not throw any exceptions
                hasBoolFilter = true;  
                    .should(QueryBuilders.termQuery("priority", "high"))
            .put(SearchService.QUERY_REWRITING_TERMS_THRESHOLD_SETTING.getKey(), 16)
        boolean hasBoolFilter = false;
    }
                            .must(QueryBuilders.matchAllQuery())  
                        rewritten.filter(rewrittenClause);  
 * compatible open source license.
        // Should be flattened first. Match_all may be removed depending on context; terms NOT merged in must context
        QueryRewriter customRewriter = new QueryRewriter() {
        }  
                    if ("test_field".equals(termQuery.fieldName()) && "test_value".equals(termQuery.value())) {  
                        QueryBuilders.boolQuery()
            @Override
 */  
    }
                if (query instanceof TermQueryBuilder) {
import org.opensearch.search.SearchService;  
        QueryBuilder query = QueryBuilders.boolQuery()  
                    for (QueryBuilder should : boolQuery.should()) {  
            .filter(QueryBuilders.matchAllQuery());  
        QueryBuilder nestedBool = QueryBuilders.boolQuery()
        assertThat(rewritten, instanceOf(BoolQueryBuilder.class));
        // Should be one terms query
            public QueryBuilder rewrite(QueryBuilder query, QueryShardContext context) {  
                        QueryBuilder rewrittenClause = rewrite(filter, context);
        // Should have:
        QueryRewriterRegistry.INSTANCE.initialize(settings, clusterSettings);
                hasRangeFilter = true;
        assertThat(result.minimumShouldMatch(), equalTo("1"));
        assertEquals(1, mb.filter().size());
                }  
        QueryBuilder twice = QueryRewriterRegistry.INSTANCE.rewrite(once, context);  
 * The OpenSearch Contributors require contributions made to  
            )
        // Test that all rewriters work together correctly  
                    rewritten.queryName(boolQuery.queryName());
        assertSame(query, rewritten);  
                    .filter(QueryBuilders.termQuery("category", "electronics"))  
    }
        };
        ClusterSettings clusterSettings = new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
            .put(SearchService.QUERY_REWRITING_ENABLED_SETTING.getKey(), true)
        QueryBuilder query = QueryBuilders.boolQuery()  
            .should(QueryBuilders.termQuery("category", "urgent"))  
        assertTrue(result.filter().size() >= 1);
        // - Flattened nested boolean
                    }  
            .build();  
        QueryBuilder query = QueryBuilders.boolQuery()
        QueryRewriterRegistry.INSTANCE.initialize(settings, clusterSettings);
        assertNull(rewritten);
        QueryBuilder rewritten = QueryRewriterRegistry.INSTANCE.rewrite(query, context);  
    public void testDynamicTermsThresholdUpdate() {
            public int priority() {
        TermQueryBuilder mustTerm = (TermQueryBuilder) rewrittenBool.must().get(0);  
        // Test a very complex query with all optimizations applicable
        QueryBuilder once = QueryRewriterRegistry.INSTANCE.rewrite(q, context);
        for (int i = 0; i < 16; i++) {
                    .should(QueryBuilders.termQuery("priority", "low"))
        QueryBuilder rewritten = QueryRewriterRegistry.INSTANCE.rewrite(query, context);
import org.opensearch.index.query.QueryShardContext;  
        // Test a complex real-world-like query
 * this file be licensed under the Apache-2.0 license or a
                    .should(QueryBuilders.termQuery("brand", "apple"))
        assertTrue(hasBoolFilter);
                return "test_custom_rewriter";
        assertEquals(16, nmb.filter().size());
        assertThat(rewrittenBool.must().get(0), instanceOf(TermQueryBuilder.class));
        BoolQueryBuilder result = (BoolQueryBuilder) rewritten;
            .filter(QueryBuilders.matchAllQuery())
        assertThat(rewrittenBool.filter().get(0), instanceOf(TermQueryBuilder.class));
        // Initialize with disabled setting
        // - Terms in must clauses are NOT merged (semantically different)  
            .mustNot(QueryBuilders.boolQuery().must(QueryBuilders.termQuery("archived", "true")))
        // Test that rewriters are applied in correct order
        QueryBuilder rewritten = QueryRewriterRegistry.INSTANCE.rewrite(query, context);  
            @Override
                        QueryBuilder rewrittenClause = rewrite(must, context);  
            public String name() {
                    .must(
}
        // One should be the brand bool query
                    rewritten.boost(boolQuery.boost());
        clusterSettings.applySettings(Settings.builder().put(SearchService.QUERY_REWRITING_ENABLED_SETTING.getKey(), true).build());  
import org.opensearch.index.query.TermQueryBuilder;
        assertThat(mustTerm.fieldName(), equalTo("custom_field"));
                    return changed ? rewritten : query;
            .filter(QueryBuilders.matchAllQuery());  
        // Verify optimizations were applied  
                        QueryBuilder rewrittenClause = rewrite(should, context);
                    .must(QueryBuilders.matchAllQuery())
    public void testPerformanceMetrics() {  
                    boolean changed = false;
            .filter(QueryBuilders.boolQuery().filter(QueryBuilders.termQuery("g", "w")))
        assertNotSame(query, rewritten);
            .must(QueryBuilders.termQuery("field", "value"))
            .must(QueryBuilders.termQuery("status", "active"))  
        // Create a query that will be affected by multiple rewriters  
        }
                    rewritten.adjustPureNegative(boolQuery.adjustPureNegative());
    public void setUp() throws Exception {  
                    .should(QueryBuilders.termQuery("priority", "medium"))  
    }  
        BoolQueryBuilder rewrittenBool = (BoolQueryBuilder) rewritten;
        QueryBuilder query = QueryBuilders.boolQuery()
                        // Replace with a different query
                        return QueryBuilders.termQuery("custom_field", "custom_value");
import static org.mockito.Mockito.mock;
                    .must(
                QueryBuilders.boolQuery()
        // - match_all should be removed in non-scoring contexts  
        assertThat(rewrittenBool.mustNot().size(), equalTo(1));  
        QueryBuilder rewritten = QueryRewriterRegistry.INSTANCE.rewrite(query, context);
                    }  
        QueryBuilder rewritten = QueryRewriterRegistry.INSTANCE.rewrite(deeplyNested, context);  
            .must(QueryBuilders.boolQuery().must(QueryBuilders.termQuery("f", "v")))
                            .filter(QueryBuilders.termQuery("status", "active"))  
        // Initialize registry with default settings
                        if (rewrittenClause != mustNot) changed = true;
        // After rewriting:
                    .should(QueryBuilders.termQuery("brand", "dell"))  
                            .filter(QueryBuilders.termQuery("status", "approved"))
package org.opensearch.search.query;
                    for (QueryBuilder filter : boolQuery.filter()) {
        BoolQueryBuilder query = QueryBuilders.boolQuery();  
        QueryBuilder query = QueryBuilders.boolQuery()
                    )  
        // Test that we log performance metrics in debug mode
        QueryBuilder q = QueryBuilders.boolQuery()  
        // This is handled internally by QueryRewriterRegistry  
import org.opensearch.test.OpenSearchTestCase;
        // - The filter bool with brand terms should be preserved
                        if (rewrittenClause != should) changed = true;  
        assertNotNull(rewritten);
        long termCount = rewrittenBool.must().stream().filter(q -> q instanceof TermQueryBuilder).count();
        // Check must clauses (should have terms query for category only - range moved to filter)
            .must(QueryBuilders.matchAllQuery())
    public void testCustomRewriterRegistration() {
    }  
        // This is more of a sanity check that the timing code doesn't throw exceptions
                    .must(QueryBuilders.termQuery("field", "value2"))  
        BoolQueryBuilder rewrittenBool = (BoolQueryBuilder) rewritten;
        QueryBuilder notMerged = QueryRewriterRegistry.INSTANCE.rewrite(query, context);
    public void testCompleteRewritingPipeline() {
        // Should be all individual term queries now
                    BoolQueryBuilder rewritten = new BoolQueryBuilder();
                        if (rewrittenClause != must) changed = true;
    }  
        assertEquals(once.toString(), twice.toString());
        // Check filter clauses (should have the brand bool query AND the range query)
 *
import org.opensearch.index.query.QueryBuilder;
        QueryBuilder rewritten = QueryRewriterRegistry.INSTANCE.rewrite(query, context);  
                QueryBuilders.boolQuery()
                    BoolQueryBuilder boolQuery = (BoolQueryBuilder) query;  
            )
            .must(QueryBuilders.matchAllQuery())
                            .filter(QueryBuilders.termQuery("status", "pending"))
        // Test that it's applied  
                        rewritten.must(rewrittenClause);
import org.opensearch.index.query.BoolQueryBuilder;  
        // Check that minimum should match is preserved  
        // Test that if a rewriter throws an exception, others still run
        // Create a custom rewriter for testing  
        assertThat(rewritten, instanceOf(BoolQueryBuilder.class));
    public void testDisabledRewriting() {
    public void testComplexRealWorldQuery() {  
        // Composition order smoke check: must_to_filter should not move term queries in must
        assertThat(rewrittenBool.must().size(), equalTo(1));  
                    }
            .mustNot(QueryBuilders.termQuery("status", "discontinued"));
        // terms_merging should not merge terms in must; only in filter/should contexts  
        // Now it should rewrite
        Settings newSettings = Settings.builder().put(SearchService.QUERY_REWRITING_TERMS_THRESHOLD_SETTING.getKey(), 32).build();
