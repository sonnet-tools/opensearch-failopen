        assertThat(rewritten, instanceOf(BoolQueryBuilder.class));
        MappedFieldType textFieldType = mock(MappedFieldType.class);  
    public void testRangeQueryMovedToFilter() {
        context = mock(QueryShardContext.class);
        QueryBuilder query = QueryBuilders.boolQuery()
        BoolQueryBuilder rewrittenBool = (BoolQueryBuilder) rewritten;
    public void testNestedBooleanQueriesRewritten() {  
        assertThat(rewrittenBool.filter().size(), equalTo(1));
        QueryBuilder rewritten = rewriter.rewrite(query, context);  
        assertThat(rewrittenBool.adjustPureNegative(), equalTo(false));  
    public void testBoostedNumericQueriesMovedToFilter() {  
        QueryBuilder query = QueryBuilders.boolQuery()
            .must(QueryBuilders.termsQuery("category", "A", "B", "C"));
        BoolQueryBuilder rewrittenBool = (BoolQueryBuilder) rewritten;
        // Match queries on numeric fields should be moved to filter
        assertThat(rewritten, instanceOf(BoolQueryBuilder.class));
    public void testAllMustClausesMovedToFilter() {  
        assertThat(rewritten, instanceOf(BoolQueryBuilder.class));
 */  
            }  
            .queryName("my_query")  
        QueryBuilder query = QueryBuilders.boolQuery()
        QueryBuilder rewritten = rewriter.rewrite(query, context);  
        assertThat(mustClause.fieldName(), equalTo("name"));  
            .must(QueryBuilders.termQuery("category", "electronics"))
        // Verify rewriter has correct priority
        assertThat(rewrittenBool.mustNot().size(), equalTo(1));  
        QueryBuilder query = QueryBuilders.boolQuery()
    }
 * SPDX-License-Identifier: Apache-2.0
        when(context.fieldMapper("price")).thenReturn(intFieldType);
            .must(QueryBuilders.termsQuery("count", new Object[] { 1, 2, 3 }))  
        // Term queries on numeric fields should be moved to filter
        // Without context, numeric term/terms cannot be identified; range still moves
/*  
        // With null context, range queries should still be moved  
        assertThat(rewritten, instanceOf(BoolQueryBuilder.class));  
        assertSame(query, rewritten);
        BoolQueryBuilder rewrittenBool = (BoolQueryBuilder) rewritten;  
        assertThat(b.must().get(0), instanceOf(TermQueryBuilder.class));  
        QueryBuilder query = QueryBuilders.boolQuery()  
            .must(QueryBuilders.termQuery("user_id", 7))
import org.opensearch.index.query.QueryBuilder;
            .should(QueryBuilders.matchQuery("tags", "important"))  
        assertThat(rewriter.priority(), equalTo(150));
        assertThat(rewritten, instanceOf(BoolQueryBuilder.class));  
        BoolQueryBuilder rewrittenBool = (BoolQueryBuilder) rewritten;
        // Text terms query should remain in must  
        assertThat(b.must().size(), equalTo(1));  
    }
        assertNotNull(nestedRewritten);  
import static org.hamcrest.Matchers.instanceOf;
        // Range query moved to filter  
        // Complex query with mix of movable and non-movable clauses
        assertThat(rewrittenBool.must().size(), equalTo(1));
        // Numeric terms query should be moved to filter
        BoolQueryBuilder rewrittenBool = (BoolQueryBuilder) rewritten;
        QueryBuilder nested = QueryBuilders.boolQuery()
        assertThat(rewritten, instanceOf(BoolQueryBuilder.class));
        BoolQueryBuilder rewrittenBool = (BoolQueryBuilder) rewritten;
    public void testNumericTermsQueryMovedToFilter() {  
        assertThat(nestedRewritten.filter().get(0), instanceOf(RangeQueryBuilder.class));  
            .minimumShouldMatch(2)
import org.opensearch.index.query.RangeQueryBuilder;
        // Term query stays in must (can't determine if numeric without context)
    }
        assertThat(nestedRewritten.must().size(), equalTo(1));
    public void testNoContextDoesNotMoveNumericTerms() {
        // Text queries remain in must
            .should(QueryBuilders.termQuery("featured", true));
        QueryBuilder query = QueryBuilders.termQuery("field", "value");  
            .filter(QueryBuilders.rangeQuery("price").gte(100))  
        assertThat(rewritten, instanceOf(BoolQueryBuilder.class));
            .must(QueryBuilders.termQuery("active", true));
        assertThat(rewritten, instanceOf(BoolQueryBuilder.class));  
        QueryBuilder rewritten = rewriter.rewrite(query, context);
            .must(QueryBuilders.rangeQuery("price").gte(100))  
        QueryBuilder query = QueryBuilders.boolQuery()  
            .mustNot(QueryBuilders.termQuery("deleted", true));  
        when(context.fieldMapper("name")).thenReturn(textFieldType);
        // The term query should remain in must
        for (QueryBuilder clause : rewrittenBool.must()) {
        // All bool query properties should be preserved
        // Term query on text field should remain in must
        assertThat(rewrittenBool.mustNot().size(), equalTo(1));  
import static org.mockito.Mockito.mock;  
            if (clause instanceof BoolQueryBuilder) {  
        // The range query in the nested bool should be moved to filter
        TermQueryBuilder mustClause = (TermQueryBuilder) rewrittenBool.must().get(0);
        QueryBuilder query = QueryBuilders.boolQuery()  
        // Terms queries on numeric fields should be moved to filter
        BoolQueryBuilder rewrittenBool = (BoolQueryBuilder) rewritten;  
        // Should and must_not unchanged
        assertThat(rewritten, instanceOf(BoolQueryBuilder.class));  
        QueryBuilder query = QueryBuilders.boolQuery()
        QueryBuilder query = QueryBuilders.boolQuery()
        // Numeric match query should be moved to filter
            .must(QueryBuilders.termsQuery("status_code", new Object[] { 200, 201, 204 }))
        assertThat(rewrittenBool.filter().size(), equalTo(1));
        assertThat(nestedRewritten.filter().size(), equalTo(1));
            .must(QueryBuilders.termQuery("age", 25))  
            .must(QueryBuilders.rangeQuery("price").gte(100).lte(500))
        QueryBuilder rewritten = rewriter.rewrite(query, context);  
        assertThat(b.filter().size(), equalTo(2));
    }
        // Text term query should remain in must  
        QueryBuilder rewritten = rewriter.rewrite(query, context);
            .must(QueryBuilders.termQuery("category", "electronics"));  
        // Properties should be preserved
            .must(QueryBuilders.rangeQuery("price").gte(100))  
        super.setUp();
            .must(QueryBuilders.matchQuery("description", "high quality"));
        // Setup non-numeric field types
        assertThat(rewrittenBool.boost(), equalTo(2.0f));  
    }
        QueryBuilder rewritten = rewriter.rewrite(query, context);
        QueryBuilder rewritten = rewriter.rewrite(query, context);
    }  
        BoolQueryBuilder rewrittenBool = (BoolQueryBuilder) rewritten;
    public void testExistingFilterClausesPreserved() {  
    }
 * The OpenSearch Contributors require contributions made to  
        assertThat(rewrittenBool.filter().size(), equalTo(1));
        assertThat(rewrittenBool.must().size(), equalTo(0));
        BoolQueryBuilder rewrittenBool = (BoolQueryBuilder) rewritten;
        assertThat(rewrittenBool.must().size(), equalTo(2)); // match title + terms status_code (text field)
        BoolQueryBuilder rewrittenBool = (BoolQueryBuilder) rewritten;
        MatchQueryBuilder mustClause = (MatchQueryBuilder) rewrittenBool.must().get(0);
            .must(QueryBuilders.matchQuery("name", "foo").boost(2.0f));
        // Should and must_not clauses should not be affected
        when(context.fieldMapper("age")).thenReturn(intFieldType);  
    public void testNoMustClausesNoChanges() {  
        QueryBuilder rewritten = rewriter.rewrite(query, context);
            .must(QueryBuilders.rangeQuery("created_date").gte("2024-01-01"))
            .must(QueryBuilders.termQuery("user_id", 12345))
            .boost(2.0f)
        QueryBuilder rewritten = rewriter.rewrite(query, null);
        TermsQueryBuilder mustClause = (TermsQueryBuilder) rewrittenBool.must().get(0);
            .must(QueryBuilders.termQuery("age", 42).boost(3.0f))  
        BoolQueryBuilder b = (BoolQueryBuilder) rewritten;
        assertThat(filterClause.fieldName(), equalTo("count"));
        // Nested boolean queries should also be rewritten
        BoolQueryBuilder nestedRewritten = null;
        assertThat(rewritten, instanceOf(BoolQueryBuilder.class));
    }
import org.opensearch.index.mapper.NumberFieldMapper;
        assertThat(rewrittenBool.should().size(), equalTo(1));
        QueryBuilder rewritten = rewriter.rewrite(query, null);
    public void testNumericTermQueryMovedToFilter() {  
import org.opensearch.test.OpenSearchTestCase;
            .filter(QueryBuilders.existsQuery("description"))
    @Override
import org.opensearch.index.query.BoolQueryBuilder;  
        // text match remains
        assertThat(rewrittenBool.must().size(), equalTo(1));
        BoolQueryBuilder b = (BoolQueryBuilder) rewritten;
        // Non-bool queries should not be changed
        assertThat(rewriter.name(), equalTo("must_to_filter"));  
import org.opensearch.index.query.MatchQueryBuilder;
            .must(QueryBuilders.rangeQuery("price").gte(100))
        assertThat(rewrittenBool.must().size(), equalTo(1));
        assertSame(query, rewritten);
        // two moved  
        assertThat(rewrittenBool.must().size(), equalTo(0));
        assertThat(rewrittenBool.filter().size(), equalTo(3));  
    }  
        // If all must clauses can be moved, they should all go to filter
            .must(QueryBuilders.rangeQuery("age").gte(18))
        // Range and numeric queries moved to filter
        assertThat(rewrittenBool.filter().get(0), instanceOf(RangeQueryBuilder.class));
        QueryBuilder query = QueryBuilders.boolQuery()
import org.opensearch.index.query.TermQueryBuilder;  
        // Should and must_not unchanged
            .must(QueryBuilders.rangeQuery("price").gte(100))  
        when(context.fieldMapper("category")).thenReturn(textFieldType);  
 * this file be licensed under the Apache-2.0 license or a
        // The nested bool should be rewritten  
import static org.mockito.Mockito.when;
import org.opensearch.index.query.TermsQueryBuilder;
            .should(QueryBuilders.termQuery("featured", true))
package org.opensearch.search.query.rewriters;
        assertThat(nestedRewritten.must().get(0), instanceOf(TermQueryBuilder.class));  
        QueryBuilder rewritten = rewriter.rewrite(query, context);
import org.opensearch.index.query.QueryShardContext;
        QueryBuilder query = QueryBuilders.boolQuery()
        QueryBuilder rewritten = rewriter.rewrite(query, context);  
    private QueryShardContext context;  
            .must(QueryBuilders.termQuery("name", "John"));
        assertThat(rewrittenBool.filter().get(0), instanceOf(RangeQueryBuilder.class));
            .must(QueryBuilders.matchQuery("title", "opensearch"))  
        QueryBuilder rewritten = rewriter.rewrite(query, context);
            .must(QueryBuilders.rangeQuery("price").gte(10).boost(1.5f))
        QueryBuilder rewritten = rewriter.rewrite(query, context);
            .must(QueryBuilders.rangeQuery("price").gte(1));
        assertThat(rewrittenBool.filter().size(), equalTo(3)); // range + exists + user_id (numeric)
        QueryBuilder query = QueryBuilders.boolQuery().must(nested).must(QueryBuilders.matchQuery("name", "test"));  
        MatchQueryBuilder filterClause = (MatchQueryBuilder) rewrittenBool.filter().get(0);  
    }
        assertThat(rewrittenBool.must().size(), equalTo(0));
    public void testComplexMixedQuery() {
    private final MustToFilterRewriter rewriter = MustToFilterRewriter.INSTANCE;
        assertThat(rewritten, instanceOf(BoolQueryBuilder.class));
    }
import org.opensearch.index.query.QueryBuilders;  
        assertThat(filterClause.fieldName(), equalTo("age"));
        // Setup numeric field types
        QueryBuilder rewritten = rewriter.rewrite(query, context);  
        // Range moved, term stayed  
        assertThat(rewrittenBool.should().size(), equalTo(1));
            .must(QueryBuilders.termQuery("count", 5));
        // Range query should be moved to filter  
        assertThat(rewrittenBool.filter().size(), equalTo(3));  
        assertThat(rewrittenBool.filter().size(), equalTo(1));
    }
        // Find the nested bool query  
        QueryBuilder query = QueryBuilders.boolQuery()
        when(context.fieldMapper("active")).thenReturn(textFieldType);
        assertThat(filterClause.fieldName(), equalTo("price"));
import org.opensearch.index.mapper.MappedFieldType;
        assertThat(b.must().size(), equalTo(1));
import static org.hamcrest.Matchers.equalTo;
        assertThat(rewrittenBool.filter().size(), equalTo(1));
            .must(QueryBuilders.matchQuery("price", 99.99))  
        // All clauses should be in filter
 * compatible open source license.
    public void testNumericMatchQueryMovedToFilter() {  
            .must(QueryBuilders.termQuery("age", 25));  
        // Query without must clauses should not be changed
        assertThat(rewrittenBool.must().size(), equalTo(1));
        BoolQueryBuilder rewrittenBool = (BoolQueryBuilder) rewritten;  
            .filter(QueryBuilders.termQuery("status", "active"))
        }
        TermsQueryBuilder filterClause = (TermsQueryBuilder) rewrittenBool.filter().get(0);  
        assertThat(b.filter().size(), equalTo(1));
 *
}
            .mustNot(QueryBuilders.termQuery("deleted", true));
    public void testShouldAndMustNotClausesUnchanged() {
        assertThat(rewrittenBool.must().get(0), instanceOf(TermQueryBuilder.class));  
    public void setUp() throws Exception {  
                nestedRewritten = (BoolQueryBuilder) clause;
        assertThat(mustClause.fieldName(), equalTo("description"));  
        TermQueryBuilder filterClause = (TermQueryBuilder) rewrittenBool.filter().get(0);  
        assertThat(rewrittenBool.queryName(), equalTo("my_query"));
    public void testNonBoolQueryUnchanged() {
        // Range query should be moved to filter even without context  
        assertThat(rewrittenBool.filter().size(), equalTo(1));
        // Should have 3 filter clauses: moved range query + 2 existing
        when(context.fieldMapper("status_code")).thenReturn(textFieldType);
    public void testBoolQueryPropertiesPreserved() {  
        assertThat(b.must().get(0), instanceOf(MatchQueryBuilder.class));
        // Existing filter clauses should be preserved
    }
            .filter(QueryBuilders.existsQuery("description"));
        when(context.fieldMapper("user_id")).thenReturn(intFieldType);  
public class MustToFilterRewriterTests extends OpenSearchTestCase {  
        when(context.fieldMapper("count")).thenReturn(intFieldType);
    }
        NumberFieldMapper.NumberFieldType intFieldType = mock(NumberFieldMapper.NumberFieldType.class);
        assertThat(rewrittenBool.must().size(), equalTo(1));
            .must(QueryBuilders.rangeQuery("age").gte(18))  
    }
                break;
    }
        assertThat(rewrittenBool.must().get(0), instanceOf(TermQueryBuilder.class));  
        QueryBuilder query = QueryBuilders.boolQuery()
        assertThat(rewrittenBool.must().size(), equalTo(2));
            .adjustPureNegative(false);
    public void testRewriterPriority() {  
        // Numeric term query should be moved to filter
        when(context.fieldMapper("description")).thenReturn(textFieldType);
        // Range queries should always be moved to filter  
    public void testNullContextStillMovesRangeQueries() {
        assertThat(rewrittenBool.minimumShouldMatch(), equalTo("2"));
        // Even with boosts, numeric queries should be moved (boost irrelevant in filter)
            .must(QueryBuilders.rangeQuery("price").gte(100))
    }
        assertThat(mustClause.fieldName(), equalTo("category"));  
        // Text match query should remain in must  
