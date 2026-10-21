    public void testNumericTermQueryMovedToFilter() {
        BoolQueryBuilder rewrittenBool = (BoolQueryBuilder) rewritten;
        assertThat(rewrittenBool.queryName(), equalTo("my_query"));
        assertThat(nestedRewritten.must().size(), equalTo(1));
        QueryBuilder query = QueryBuilders.boolQuery()
        assertThat(mustClause.fieldName(), equalTo("description"));
        when(context.fieldMapper("count")).thenReturn(intFieldType);
        assertThat(b.filter().size(), equalTo(1));
            .must(QueryBuilders.termQuery("active", true));
        assertThat(rewritten, instanceOf(BoolQueryBuilder.class));
        QueryBuilder rewritten = rewriter.rewrite(query, context);
        // Existing filter clauses should be preserved
import org.opensearch.index.query.TermQueryBuilder;
            .must(QueryBuilders.matchQuery("name", "foo").boost(2.0f));
import org.opensearch.index.mapper.NumberFieldMapper;
        // Range query should be moved to filter even without context
        // Setup non-numeric field types
        when(context.fieldMapper("description")).thenReturn(textFieldType);
    public void testNestedBooleanQueriesRewritten() {
import static org.hamcrest.Matchers.instanceOf;
        // Non-bool queries should not be changed
        // Text match query should remain in must
        assertThat(rewrittenBool.filter().get(0), instanceOf(RangeQueryBuilder.class));
        // Verify rewriter has correct priority
        // Term queries on numeric fields should be moved to filter
        // Should and must_not unchanged
        MappedFieldType textFieldType = mock(MappedFieldType.class);
            .mustNot(QueryBuilders.termQuery("deleted", true));
        assertThat(nestedRewritten.must().get(0), instanceOf(TermQueryBuilder.class));
    @Override
    }
import org.opensearch.index.query.QueryShardContext;
import org.opensearch.test.OpenSearchTestCase;
            .must(QueryBuilders.matchQuery("description", "high quality"));
        assertThat(rewrittenBool.filter().size(), equalTo(1));
        assertThat(rewrittenBool.must().size(), equalTo(0));
 */
        // two moved
            .adjustPureNegative(false);
            .must(QueryBuilders.rangeQuery("price").gte(100))
        // Setup numeric field types
        when(context.fieldMapper("user_id")).thenReturn(intFieldType);
        BoolQueryBuilder rewrittenBool = (BoolQueryBuilder) rewritten;
            .must(QueryBuilders.rangeQuery("price").gte(100))
        TermsQueryBuilder mustClause = (TermsQueryBuilder) rewrittenBool.must().get(0);
            .must(QueryBuilders.rangeQuery("price").gte(10).boost(1.5f))
    }
        // Range queries should always be moved to filter
    }
            .must(QueryBuilders.termsQuery("status_code", new Object[] { 200, 201, 204 }))
    }
        assertThat(rewrittenBool.must().size(), equalTo(1));
        assertThat(rewritten, instanceOf(BoolQueryBuilder.class));
        assertThat(rewritten, instanceOf(BoolQueryBuilder.class));
    }
        super.setUp();
        // Text term query should remain in must
        assertThat(rewrittenBool.minimumShouldMatch(), equalTo("2"));
    public void testNoMustClausesNoChanges() {
        TermQueryBuilder mustClause = (TermQueryBuilder) rewrittenBool.must().get(0);
        BoolQueryBuilder b = (BoolQueryBuilder) rewritten;
        assertThat(rewriter.priority(), equalTo(150));
        assertThat(nestedRewritten.filter().get(0), instanceOf(RangeQueryBuilder.class));
        assertThat(b.must().get(0), instanceOf(MatchQueryBuilder.class));
        QueryBuilder rewritten = rewriter.rewrite(query, context);
        BoolQueryBuilder rewrittenBool = (BoolQueryBuilder) rewritten;
        assertThat(rewrittenBool.filter().size(), equalTo(3)); // range + exists + user_id (numeric)
                break;
    }
            .must(QueryBuilders.termQuery("age", 42).boost(3.0f))
        // Even with boosts, numeric queries should be moved (boost irrelevant in filter)
import org.opensearch.index.query.BoolQueryBuilder;
        assertThat(rewritten, instanceOf(BoolQueryBuilder.class));
        QueryBuilder query = QueryBuilders.boolQuery()
            .must(QueryBuilders.termQuery("category", "electronics"))
        QueryBuilder query = QueryBuilders.boolQuery()
import org.opensearch.index.query.QueryBuilders;
    }
            .must(QueryBuilders.termQuery("user_id", 12345))
        MatchQueryBuilder mustClause = (MatchQueryBuilder) rewrittenBool.must().get(0);
    public void testBoolQueryPropertiesPreserved() {
        assertThat(rewrittenBool.must().size(), equalTo(1));
            .must(QueryBuilders.rangeQuery("price").gte(100))
        BoolQueryBuilder rewrittenBool = (BoolQueryBuilder) rewritten;
        QueryBuilder query = QueryBuilders.boolQuery()
        assertThat(filterClause.fieldName(), equalTo("count"));
    private QueryShardContext context;
            .must(QueryBuilders.rangeQuery("age").gte(18))
        BoolQueryBuilder rewrittenBool = (BoolQueryBuilder) rewritten;
            .queryName("my_query")
        QueryBuilder rewritten = rewriter.rewrite(query, context);
        assertThat(rewrittenBool.mustNot().size(), equalTo(1));
        QueryBuilder query = QueryBuilders.boolQuery()
        assertThat(rewritten, instanceOf(BoolQueryBuilder.class));
        assertThat(rewrittenBool.filter().get(0), instanceOf(RangeQueryBuilder.class));
        assertThat(rewriter.name(), equalTo("must_to_filter"));
            .boost(2.0f)
    public void testNumericTermsQueryMovedToFilter() {
        QueryBuilder rewritten = rewriter.rewrite(query, context);
        // All bool query properties should be preserved
            .filter(QueryBuilders.existsQuery("description"));
        BoolQueryBuilder rewrittenBool = (BoolQueryBuilder) rewritten;
        assertThat(rewrittenBool.should().size(), equalTo(1));
        assertSame(query, rewritten);
        QueryBuilder query = QueryBuilders.boolQuery()
        QueryBuilder rewritten = rewriter.rewrite(query, context);
        assertThat(rewrittenBool.filter().size(), equalTo(1));
        BoolQueryBuilder rewrittenBool = (BoolQueryBuilder) rewritten;
    public void testNonBoolQueryUnchanged() {
        QueryBuilder rewritten = rewriter.rewrite(query, context);
        QueryBuilder query = QueryBuilders.boolQuery().must(nested).must(QueryBuilders.matchQuery("name", "test"));
        }
        QueryBuilder query = QueryBuilders.boolQuery()
        assertThat(filterClause.fieldName(), equalTo("age"));
            if (clause instanceof BoolQueryBuilder) {
import org.opensearch.index.mapper.MappedFieldType;
        assertThat(mustClause.fieldName(), equalTo("category"));
            }
    public void testNoContextDoesNotMoveNumericTerms() {
        assertThat(rewrittenBool.filter().size(), equalTo(1));
        // The nested bool should be rewritten
            .must(QueryBuilders.termQuery("age", 25))
            .filter(QueryBuilders.rangeQuery("price").gte(100))
import org.opensearch.index.query.QueryBuilder;
        assertThat(rewrittenBool.filter().size(), equalTo(3));
    public void testNullContextStillMovesRangeQueries() {
import org.opensearch.index.query.TermsQueryBuilder;
        // All clauses should be in filter
            .must(QueryBuilders.termsQuery("count", new Object[] { 1, 2, 3 }))
        MatchQueryBuilder filterClause = (MatchQueryBuilder) rewrittenBool.filter().get(0);
    public void testRangeQueryMovedToFilter() {
        QueryBuilder rewritten = rewriter.rewrite(query, context);
        QueryBuilder query = QueryBuilders.termQuery("field", "value");
        // Numeric match query should be moved to filter
        BoolQueryBuilder nestedRewritten = null;
        assertThat(rewritten, instanceOf(BoolQueryBuilder.class));
        // Range and numeric queries moved to filter
        assertThat(b.filter().size(), equalTo(2));
import static org.mockito.Mockito.mock;
        TermQueryBuilder filterClause = (TermQueryBuilder) rewrittenBool.filter().get(0);
            .must(QueryBuilders.rangeQuery("price").gte(100))
        QueryBuilder query = QueryBuilders.boolQuery()
        QueryBuilder rewritten = rewriter.rewrite(query, context);
        // Should and must_not unchanged
        for (QueryBuilder clause : rewrittenBool.must()) {
    public void testNumericMatchQueryMovedToFilter() {
        assertThat(nestedRewritten.filter().size(), equalTo(1));
        // Should have 3 filter clauses: moved range query + 2 existing
            .must(QueryBuilders.rangeQuery("price").gte(1));
    public void testBoostedNumericQueriesMovedToFilter() {
        assertThat(rewritten, instanceOf(BoolQueryBuilder.class));
 * SPDX-License-Identifier: Apache-2.0
        BoolQueryBuilder rewrittenBool = (BoolQueryBuilder) rewritten;
    }
        assertThat(rewrittenBool.adjustPureNegative(), equalTo(false));
        assertThat(rewrittenBool.must().size(), equalTo(2)); // match title + terms status_code (text field)
            .must(QueryBuilders.termsQuery("category", "A", "B", "C"));
 * compatible open source license.
        assertThat(rewrittenBool.filter().size(), equalTo(1));
            .mustNot(QueryBuilders.termQuery("deleted", true));
        context = mock(QueryShardContext.class);
        QueryBuilder query = QueryBuilders.boolQuery()
        // Range query should be moved to filter
        // Numeric terms query should be moved to filter
        assertThat(rewrittenBool.must().size(), equalTo(0));
        when(context.fieldMapper("status_code")).thenReturn(textFieldType);
        QueryBuilder query = QueryBuilders.boolQuery()
            .must(QueryBuilders.matchQuery("title", "opensearch"))
        assertThat(b.must().size(), equalTo(1));
        assertThat(rewrittenBool.filter().size(), equalTo(3));
    }
            .should(QueryBuilders.matchQuery("tags", "important"))
    }
        assertThat(filterClause.fieldName(), equalTo("price"));
        when(context.fieldMapper("active")).thenReturn(textFieldType);
        QueryBuilder rewritten = rewriter.rewrite(query, context);
        // text match remains
        BoolQueryBuilder rewrittenBool = (BoolQueryBuilder) rewritten;
public class MustToFilterRewriterTests extends OpenSearchTestCase {
    }
        QueryBuilder query = QueryBuilders.boolQuery()
        when(context.fieldMapper("category")).thenReturn(textFieldType);
    public void setUp() throws Exception {
        // Nested boolean queries should also be rewritten
        QueryBuilder rewritten = rewriter.rewrite(query, context);
import org.opensearch.index.query.MatchQueryBuilder;
            .must(QueryBuilders.rangeQuery("price").gte(100))
            .should(QueryBuilders.termQuery("featured", true))
        assertThat(rewrittenBool.mustNot().size(), equalTo(1));
            .must(QueryBuilders.rangeQuery("price").gte(100).lte(500))
        assertThat(b.must().get(0), instanceOf(TermQueryBuilder.class));
            .minimumShouldMatch(2)
        BoolQueryBuilder rewrittenBool = (BoolQueryBuilder) rewritten;
        assertThat(rewrittenBool.must().get(0), instanceOf(TermQueryBuilder.class));
        // Term query on text field should remain in must
        assertThat(rewritten, instanceOf(BoolQueryBuilder.class));
    public void testRewriterPriority() {
    }
    }
        QueryBuilder rewritten = rewriter.rewrite(query, null);
        when(context.fieldMapper("price")).thenReturn(intFieldType);
        assertThat(rewrittenBool.must().size(), equalTo(0));
        // Numeric term query should be moved to filter
        QueryBuilder query = QueryBuilders.boolQuery()
 * this file be licensed under the Apache-2.0 license or a
        // Find the nested bool query
 * The OpenSearch Contributors require contributions made to
        // With null context, range queries should still be moved
        assertThat(b.must().size(), equalTo(1));
        // If all must clauses can be moved, they should all go to filter
    }
    }
    }
        // Range query moved to filter
package org.opensearch.search.query.rewriters;
            .filter(QueryBuilders.termQuery("status", "active"))
            .must(QueryBuilders.rangeQuery("created_date").gte("2024-01-01"))
                nestedRewritten = (BoolQueryBuilder) clause;
        assertThat(rewrittenBool.must().get(0), instanceOf(TermQueryBuilder.class));
        // Query without must clauses should not be changed
import static org.mockito.Mockito.when;
        assertThat(rewrittenBool.must().size(), equalTo(1));
            .must(QueryBuilders.termQuery("category", "electronics"));
    private final MustToFilterRewriter rewriter = MustToFilterRewriter.INSTANCE;
        // Should and must_not clauses should not be affected
        assertThat(rewritten, instanceOf(BoolQueryBuilder.class));
            .must(QueryBuilders.termQuery("user_id", 7))
        // Match queries on numeric fields should be moved to filter
        // The range query in the nested bool should be moved to filter
        assertThat(rewrittenBool.should().size(), equalTo(1));
        BoolQueryBuilder rewrittenBool = (BoolQueryBuilder) rewritten;
        TermsQueryBuilder filterClause = (TermsQueryBuilder) rewrittenBool.filter().get(0);
        // Complex query with mix of movable and non-movable clauses
        assertNotNull(nestedRewritten);
        // The term query should remain in must
        // Range moved, term stayed
        // Text queries remain in must
        assertThat(rewrittenBool.must().size(), equalTo(2));
        when(context.fieldMapper("name")).thenReturn(textFieldType);
        NumberFieldMapper.NumberFieldType intFieldType = mock(NumberFieldMapper.NumberFieldType.class);
        QueryBuilder rewritten = rewriter.rewrite(query, context);
    public void testComplexMixedQuery() {
        assertThat(mustClause.fieldName(), equalTo("name"));
    }
        QueryBuilder rewritten = rewriter.rewrite(query, context);
            .must(QueryBuilders.termQuery("age", 25));
            .must(QueryBuilders.matchQuery("price", 99.99))
        // Without context, numeric term/terms cannot be identified; range still moves
            .filter(QueryBuilders.existsQuery("description"))
    public void testExistingFilterClausesPreserved() {
 *
        // Term query stays in must (can't determine if numeric without context)
            .must(QueryBuilders.termQuery("count", 5));
/*
        // Terms queries on numeric fields should be moved to filter
import static org.hamcrest.Matchers.equalTo;
            .must(QueryBuilders.rangeQuery("age").gte(18))
        // Text terms query should remain in must
}
        assertSame(query, rewritten);
        assertThat(rewrittenBool.filter().size(), equalTo(1));
    public void testShouldAndMustNotClausesUnchanged() {
        assertThat(rewritten, instanceOf(BoolQueryBuilder.class));
    public void testAllMustClausesMovedToFilter() {
        QueryBuilder rewritten = rewriter.rewrite(query, context);
        assertThat(rewrittenBool.boost(), equalTo(2.0f));
            .must(QueryBuilders.termQuery("name", "John"));
        // Properties should be preserved
        when(context.fieldMapper("age")).thenReturn(intFieldType);
        assertThat(rewrittenBool.filter().size(), equalTo(1));
        BoolQueryBuilder b = (BoolQueryBuilder) rewritten;
        assertThat(rewrittenBool.must().size(), equalTo(1));
            .should(QueryBuilders.termQuery("featured", true));
        assertThat(rewrittenBool.must().size(), equalTo(1));
        assertThat(rewritten, instanceOf(BoolQueryBuilder.class));
        QueryBuilder rewritten = rewriter.rewrite(query, null);
import org.opensearch.index.query.RangeQueryBuilder;
        QueryBuilder query = QueryBuilders.boolQuery()
        QueryBuilder nested = QueryBuilders.boolQuery()
