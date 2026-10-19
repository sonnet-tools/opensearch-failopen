            .must(QueryBuilders.matchAllQuery())  
            .filter(QueryBuilders.matchAllQuery())
    }
 */  
        QueryBuilder rewritten = rewriter.rewrite(query, context);
        BoolQueryBuilder rewrittenBool = (BoolQueryBuilder) rewritten;
import org.opensearch.index.query.QueryBuilder;
        QueryBuilder rewritten = rewriter.rewrite(query, context);  
            .filter(QueryBuilders.rangeQuery("price").gt(100))
        QueryBuilder rewritten = rewriter.rewrite(query, context);  
        assertThat(rewritten, instanceOf(BoolQueryBuilder.class));  
    public void testRemoveMatchAllFromMust() {
            .filter(QueryBuilders.termQuery("f2", "x"));
        // match_all in must is kept in scoring context, match_all in filter is removed
        QueryBuilder rewritten = rewriter.rewrite(query, context);
        // match_all in filter clause should be removed
        QueryBuilder rewritten = rewriter.rewrite(query, context);
        QueryBuilder rewritten = rewriter.rewrite(query, context);  
        assertThat(nestedRewritten.filter().size(), equalTo(1));  
            .must(QueryBuilders.matchAllQuery())
        QueryBuilder rewritten = rewriter.rewrite(query, context);
import org.opensearch.index.query.QueryBuilders;  
            .must(QueryBuilders.termQuery("field", "v"))
        // match_all should be removed from filter  
    }  
        QueryBuilder query = QueryBuilders.boolQuery().must(nested).filter(QueryBuilders.termQuery("field2", "value2"));  
    private final MatchAllRemovalRewriter rewriter = MatchAllRemovalRewriter.INSTANCE;
            .must(QueryBuilders.matchAllQuery())  
    public void testNestedBooleanWithMatchAll() {  
        // When converting bool with only match_all to match_all, preserve boost  
        assertThat(rewrittenBool.filter().size(), equalTo(1));
    public void testMustMatchAllRemovedWhenFilterPresent() {  
        // Non-boolean queries should be returned as-is
        BoolQueryBuilder rewrittenBool = (BoolQueryBuilder) rewritten;
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.index.query.BoolQueryBuilder;
        BoolQueryBuilder rewrittenBool = (BoolQueryBuilder) rewritten;  
        assertThat(rewrittenBool.filter().size(), equalTo(0));  
        QueryBuilder query = QueryBuilders.boolQuery()
    public void testNonBooleanQuery() {  
        // Bool with only must_not after removal should not be converted to match_all
        // must contains match_all + term, and there is a filter clause => remove match_all from must
        BoolQueryBuilder rewrittenBool = (BoolQueryBuilder) rewritten;  
        QueryBuilder query = QueryBuilders.boolQuery().must(QueryBuilders.matchAllQuery()).must(QueryBuilders.termQuery("field", "value"));  
        // Nested boolean queries should also have match_all removed
    }
    }
/*  
            .mustNot(QueryBuilders.matchAllQuery())  
        QueryBuilder query = QueryBuilders.boolQuery().must(QueryBuilders.matchAllQuery()).filter(QueryBuilders.matchAllQuery());
    }
            .must(QueryBuilders.termQuery("field", "value"));
            .should(QueryBuilders.matchAllQuery())
    }  
        assertThat(rewritten, instanceOf(BoolQueryBuilder.class));
    }
    }
 * compatible open source license.
        // Multiple match_all queries should all be removed
        assertThat(rewrittenBool.must().size(), equalTo(1));
        QueryBuilder rewritten = rewriter.rewrite(query, context);
        BoolQueryBuilder nestedRewritten = (BoolQueryBuilder) rewrittenBool.must().get(0);
        assertSame(query, rewritten); // No changes for must_not clause
    public void testNestedFilterMatchAllRemoved() {
        QueryBuilder query = QueryBuilders.boolQuery()  
    }
            .filter(QueryBuilders.matchAllQuery())
        QueryBuilder query = QueryBuilders.boolQuery().filter(nested);
        QueryBuilder query = QueryBuilders.boolQuery();  
    public void testEmptyBooleanQuery() {
        // Empty boolean query should not be converted
    public void testOnlyMatchAllQuery() {
    public void testRemoveMatchAllFromFilter() {
        assertThat(rewritten, instanceOf(QueryBuilders.matchAllQuery().getClass()));
    public void testBoostPreservation() {
        QueryBuilder query = QueryBuilders.boolQuery()
    private final QueryShardContext context = mock(QueryShardContext.class);
        assertThat(rewrittenBool.must().size(), equalTo(2));
        QueryBuilder query = QueryBuilders.boolQuery().must(QueryBuilders.matchAllQuery());  
 * this file be licensed under the Apache-2.0 license or a
        QueryBuilder query = QueryBuilders.boolQuery()
        assertThat(rewrittenBool.filter().size(), equalTo(0));  
        // match_all in must_not clause should be kept (it's meaningful)
        // match_all in should clause should be kept  
        assertThat(rewritten, instanceOf(BoolQueryBuilder.class));
        // Nested bool keeps match_all in scoring context  
        QueryBuilder rewritten = rewriter.rewrite(query, context);
    public void testMultipleMatchAllQueries() {  
        assertThat(rewritten.boost(), equalTo(2.0f));
        // With filter clause present, this is not a pure scoring context  
        QueryBuilder query = QueryBuilders.matchAllQuery();
        QueryBuilder query = QueryBuilders.boolQuery()
    }  
        BoolQueryBuilder rewrittenBool = (BoolQueryBuilder) rewritten;
            .should(QueryBuilders.termQuery("field", "value"));  
import static org.mockito.Mockito.mock;  
import org.opensearch.test.OpenSearchTestCase;
}
    public void testEmptyBoolAfterRemoval() {
        // Bool with only match_all in must/filter - keeps match_all in must in scoring context  
        BoolQueryBuilder nestedRewritten = (BoolQueryBuilder) rewrittenBool.filter().get(0);
package org.opensearch.search.query.rewriters;
    public void testKeepMatchAllInShould() {
        assertThat(rewrittenBool.must().size(), equalTo(1)); // only term query remains
public class MatchAllRemovalRewriterTests extends OpenSearchTestCase {
    }  
        assertThat(rewrittenBool.must().size(), equalTo(1));
        QueryBuilder rewritten = rewriter.rewrite(query, context);  
        assertSame(query, rewritten); // No changes for should clause  
import static org.hamcrest.Matchers.instanceOf;
        assertThat(rewrittenBool.must().size(), equalTo(1));
import static org.hamcrest.Matchers.equalTo;
        QueryBuilder rewritten = rewriter.rewrite(query, context);
        // match_all should be kept in scoring context  
        assertSame(query, rewritten);
        QueryBuilder nested = QueryBuilders.boolQuery().filter(QueryBuilders.matchAllQuery()).filter(QueryBuilders.termQuery("a", "b"));
        assertThat(rewritten, instanceOf(BoolQueryBuilder.class));
        // match_all in must clause should NOT be removed in scoring context
        QueryBuilder rewritten = rewriter.rewrite(query, context);  
        QueryBuilder rewritten = rewriter.rewrite(query, context);
        assertThat(rewritten, instanceOf(BoolQueryBuilder.class));  
        BoolQueryBuilder rewrittenBool = (BoolQueryBuilder) rewritten;
            .must(QueryBuilders.termQuery("category", "electronics"));  
        assertThat(rewritten, instanceOf(BoolQueryBuilder.class));  
        // Since there are non-match_all queries in must, match_all should be removed
        assertThat(nestedRewritten.must().size(), equalTo(2)); // match_all + term
    }
        // Only the real filter remains
            .mustNot(QueryBuilders.termQuery("status", "deleted"));
            .must(QueryBuilders.matchAllQuery())  
 *
        assertThat(rewrittenBool.mustNot().size(), equalTo(1));  
        // match_all inside nested bool under filter should be removed  
            .must(QueryBuilders.termQuery("field1", "value1"));
        assertThat(rewritten, instanceOf(QueryBuilders.matchAllQuery().getClass()));  
        // match_all removed from must because non-scoring context exists (filter present)
    }  
    public void testBoolWithOnlyMustNotAfterRemoval() {  
        BoolQueryBuilder rewrittenBool = (BoolQueryBuilder) rewritten;
        // must clause keeps match_all in scoring context, must_not preserved
        QueryBuilder nested = QueryBuilders.boolQuery()
        assertThat(rewritten, instanceOf(BoolQueryBuilder.class));  
        // Boolean query with only match_all should be simplified to match_all
import org.opensearch.index.query.QueryShardContext;
        QueryBuilder rewritten = rewriter.rewrite(query, context);
 * SPDX-License-Identifier: Apache-2.0
        assertSame(query, rewritten);
        BoolQueryBuilder rewrittenBool = (BoolQueryBuilder) rewritten;
    }
    public void testKeepMatchAllInMustNot() {  
        QueryBuilder query = QueryBuilders.boolQuery()
            .must(QueryBuilders.matchAllQuery())  
            .must(QueryBuilders.termQuery("field", "value"));  
        assertThat(rewrittenBool.must().size(), equalTo(1));
        assertThat(rewritten, instanceOf(BoolQueryBuilder.class));
        QueryBuilder query = QueryBuilders.boolQuery().must(QueryBuilders.matchAllQuery()).boost(2.0f);
