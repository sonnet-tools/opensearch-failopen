    }
        // With filter clause present, this is not a pure scoring context
        QueryBuilder rewritten = rewriter.rewrite(query, context);
        // Since there are non-match_all queries in must, match_all should be removed
            .should(QueryBuilders.matchAllQuery())
import static org.mockito.Mockito.mock;
import org.opensearch.index.query.QueryBuilders;
    }
        // match_all should be removed from filter
/*
        assertThat(rewritten, instanceOf(BoolQueryBuilder.class));
    }
        BoolQueryBuilder rewrittenBool = (BoolQueryBuilder) rewritten;
import org.opensearch.index.query.QueryBuilder;
        QueryBuilder query = QueryBuilders.boolQuery().must(QueryBuilders.matchAllQuery());
        BoolQueryBuilder rewrittenBool = (BoolQueryBuilder) rewritten;
        // Nested bool keeps match_all in scoring context
    private final MatchAllRemovalRewriter rewriter = MatchAllRemovalRewriter.INSTANCE;
        QueryBuilder nested = QueryBuilders.boolQuery()
        assertThat(rewritten, instanceOf(QueryBuilders.matchAllQuery().getClass()));
        // Empty boolean query should not be converted
        // Multiple match_all queries should all be removed
        QueryBuilder query = QueryBuilders.boolQuery().must(QueryBuilders.matchAllQuery()).must(QueryBuilders.termQuery("field", "value"));
    }
            .must(QueryBuilders.matchAllQuery())
            .must(QueryBuilders.matchAllQuery())
        assertThat(rewritten, instanceOf(BoolQueryBuilder.class));
        BoolQueryBuilder nestedRewritten = (BoolQueryBuilder) rewrittenBool.filter().get(0);
        // match_all in should clause should be kept
        assertThat(rewrittenBool.must().size(), equalTo(1));
import static org.hamcrest.Matchers.equalTo;
    public void testMultipleMatchAllQueries() {
        BoolQueryBuilder rewrittenBool = (BoolQueryBuilder) rewritten;
        BoolQueryBuilder rewrittenBool = (BoolQueryBuilder) rewritten;
package org.opensearch.search.query.rewriters;
 * compatible open source license.
            .mustNot(QueryBuilders.matchAllQuery())
    }
        QueryBuilder query = QueryBuilders.boolQuery();
        BoolQueryBuilder rewrittenBool = (BoolQueryBuilder) rewritten;
            .filter(QueryBuilders.rangeQuery("price").gt(100))
            .must(QueryBuilders.termQuery("field", "v"))
        // Only the real filter remains
        // Bool with only match_all in must/filter - keeps match_all in must in scoring context
        assertThat(rewrittenBool.filter().size(), equalTo(0));
        QueryBuilder rewritten = rewriter.rewrite(query, context);
        // match_all in filter clause should be removed
        QueryBuilder rewritten = rewriter.rewrite(query, context);
            .must(QueryBuilders.termQuery("field", "value"));
        assertThat(nestedRewritten.must().size(), equalTo(2)); // match_all + term
            .must(QueryBuilders.termQuery("category", "electronics"));
            .mustNot(QueryBuilders.termQuery("status", "deleted"));
    public void testNonBooleanQuery() {
    public void testKeepMatchAllInMustNot() {
    public void testMustMatchAllRemovedWhenFilterPresent() {
            .filter(QueryBuilders.matchAllQuery())
        QueryBuilder rewritten = rewriter.rewrite(query, context);
        QueryBuilder query = QueryBuilders.boolQuery()
    public void testRemoveMatchAllFromMust() {
            .must(QueryBuilders.matchAllQuery())
import org.opensearch.index.query.BoolQueryBuilder;
        assertSame(query, rewritten);
        QueryBuilder query = QueryBuilders.boolQuery()
        QueryBuilder rewritten = rewriter.rewrite(query, context);
        assertThat(rewrittenBool.filter().size(), equalTo(0));
        // Bool with only must_not after removal should not be converted to match_all
            .must(QueryBuilders.matchAllQuery())
public class MatchAllRemovalRewriterTests extends OpenSearchTestCase {
    }
        BoolQueryBuilder nestedRewritten = (BoolQueryBuilder) rewrittenBool.must().get(0);
            .should(QueryBuilders.termQuery("field", "value"));
    public void testEmptyBooleanQuery() {
        QueryBuilder query = QueryBuilders.boolQuery()
        // Nested boolean queries should also have match_all removed
        QueryBuilder rewritten = rewriter.rewrite(query, context);
            .must(QueryBuilders.matchAllQuery())
            .must(QueryBuilders.termQuery("field1", "value1"));
    public void testNestedBooleanWithMatchAll() {
    public void testRemoveMatchAllFromFilter() {
        QueryBuilder query = QueryBuilders.boolQuery().filter(nested);
    }
    public void testBoolWithOnlyMustNotAfterRemoval() {
    public void testBoostPreservation() {
        // must clause keeps match_all in scoring context, must_not preserved
        assertThat(rewritten, instanceOf(BoolQueryBuilder.class));
        assertThat(rewrittenBool.must().size(), equalTo(2));
        // Non-boolean queries should be returned as-is
import org.opensearch.test.OpenSearchTestCase;
    public void testNestedFilterMatchAllRemoved() {
import org.opensearch.index.query.QueryShardContext;
        QueryBuilder nested = QueryBuilders.boolQuery().filter(QueryBuilders.matchAllQuery()).filter(QueryBuilders.termQuery("a", "b"));
        QueryBuilder rewritten = rewriter.rewrite(query, context);
        QueryBuilder query = QueryBuilders.boolQuery()
        QueryBuilder query = QueryBuilders.boolQuery()
        // match_all inside nested bool under filter should be removed
        assertThat(rewrittenBool.must().size(), equalTo(1));
    }
        QueryBuilder rewritten = rewriter.rewrite(query, context);
        // Boolean query with only match_all should be simplified to match_all
    public void testKeepMatchAllInShould() {
    public void testOnlyMatchAllQuery() {
        QueryBuilder rewritten = rewriter.rewrite(query, context);
        // match_all in must is kept in scoring context, match_all in filter is removed
        assertThat(rewritten, instanceOf(BoolQueryBuilder.class));
    }
        QueryBuilder rewritten = rewriter.rewrite(query, context);
        QueryBuilder query = QueryBuilders.boolQuery().must(nested).filter(QueryBuilders.termQuery("field2", "value2"));
        assertSame(query, rewritten); // No changes for must_not clause
        BoolQueryBuilder rewrittenBool = (BoolQueryBuilder) rewritten;
        QueryBuilder rewritten = rewriter.rewrite(query, context);
        BoolQueryBuilder rewrittenBool = (BoolQueryBuilder) rewritten;
        QueryBuilder rewritten = rewriter.rewrite(query, context);
        assertThat(rewrittenBool.must().size(), equalTo(1)); // only term query remains
    }
            .filter(QueryBuilders.termQuery("f2", "x"));
        assertThat(rewritten, instanceOf(QueryBuilders.matchAllQuery().getClass()));
        assertSame(query, rewritten);
        QueryBuilder query = QueryBuilders.boolQuery().must(QueryBuilders.matchAllQuery()).filter(QueryBuilders.matchAllQuery());
        assertThat(rewrittenBool.mustNot().size(), equalTo(1));
        // match_all in must_not clause should be kept (it's meaningful)
        QueryBuilder rewritten = rewriter.rewrite(query, context);
        assertThat(rewritten, instanceOf(BoolQueryBuilder.class));
 *
        assertThat(rewrittenBool.filter().size(), equalTo(1));
 */
 * this file be licensed under the Apache-2.0 license or a
        assertThat(nestedRewritten.filter().size(), equalTo(1));
        // match_all in must clause should NOT be removed in scoring context
    }
    private final QueryShardContext context = mock(QueryShardContext.class);
    public void testEmptyBoolAfterRemoval() {
 * SPDX-License-Identifier: Apache-2.0
        assertThat(rewrittenBool.must().size(), equalTo(1));
        assertSame(query, rewritten); // No changes for should clause
        assertThat(rewritten, instanceOf(BoolQueryBuilder.class));
        // match_all removed from must because non-scoring context exists (filter present)
    }
        assertThat(rewritten, instanceOf(BoolQueryBuilder.class));
import static org.hamcrest.Matchers.instanceOf;
        QueryBuilder query = QueryBuilders.boolQuery().must(QueryBuilders.matchAllQuery()).boost(2.0f);
        // match_all should be kept in scoring context
        QueryBuilder query = QueryBuilders.boolQuery()
            .must(QueryBuilders.termQuery("field", "value"));
        QueryBuilder rewritten = rewriter.rewrite(query, context);
}
 * The OpenSearch Contributors require contributions made to
    }
        QueryBuilder query = QueryBuilders.matchAllQuery();
        assertThat(rewrittenBool.must().size(), equalTo(1));
    }
        // When converting bool with only match_all to match_all, preserve boost
        BoolQueryBuilder rewrittenBool = (BoolQueryBuilder) rewritten;
        assertThat(rewritten.boost(), equalTo(2.0f));
        assertThat(rewritten, instanceOf(BoolQueryBuilder.class));
            .filter(QueryBuilders.matchAllQuery())
        // must contains match_all + term, and there is a filter clause => remove match_all from must
