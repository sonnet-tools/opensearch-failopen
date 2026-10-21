        QueryBuilder query = QueryBuilders.boolQuery()
        assertSame(query, rewritten); // No changes expected
        assertThat(termsQuery.values().size(), equalTo(19));
            .filter(QueryBuilders.termQuery("field", "v6"));
            query.should(QueryBuilders.termQuery("color", "color_" + i));
        assertThat(rewritten, instanceOf(BoolQueryBuilder.class));
        assertThat(terms.values().size(), equalTo(50));
        // Non-boolean queries should be returned as-is
        QueryBuilder rewritten = rewriter.rewrite(query, context);
        QueryBuilder rewritten = rewriter.rewrite(query, context);
        assertThat(result.filter().get(0), instanceOf(TermsQueryBuilder.class));
        // Many term queries on same field should be merged (above threshold of 16)
        TermsQueryBuilder termsQuery = (TermsQueryBuilder) rewrittenBool.filter().get(0);
        QueryBuilder rewritten = rewriter.rewrite(query, context);
        // Should clauses with many terms should be merged
        for (int i = 0; i < 14; i++) {
            .must(QueryBuilders.termQuery("category", "computers"))
    public void testMixedFieldsNoMerging() {
        assertSame(query, rewritten); // No changes due to different boosts
        // Empty boolean query should not cause issues
        QueryBuilder query = QueryBuilders.boolQuery().must(nested).filter(QueryBuilders.termQuery("type", "product"));
        // Nested bool should also be rewritten
        BoolQueryBuilder query = QueryBuilders.boolQuery();
    public void testExistingTermsQueryExpansionBelowThreshold() {
        assertSame(query, rewritten); // No changes to must_not
            .filter(QueryBuilders.termQuery("status", "pending").boost(2.0f));
import org.opensearch.index.query.BoolQueryBuilder;
        // Term queries on different fields should not be merged
    public void testSingleTermQuery() {
        // Mix of existing terms queries and term queries with few values
            .should(QueryBuilders.termQuery("color", "red"))
    }
        // Should handle nested boolean queries with many terms
    public void testShouldMergingWithThreshold() {
        assertThat(nestedRewritten.filter().size(), equalTo(1));
    public void testBoostPreservation() {
        BoolQueryBuilder rewrittenBool = (BoolQueryBuilder) rewritten;
        assertThat(rewritten, instanceOf(BoolQueryBuilder.class));
    }
        BoolQueryBuilder result = (BoolQueryBuilder) rewritten;
        // Must_not clauses should not be merged
        BoolQueryBuilder query = QueryBuilders.boolQuery().filter(QueryBuilders.termsQuery("status", initialTerms));
        }
        BoolQueryBuilder b = (BoolQueryBuilder) rewritten;
        BoolQueryBuilder result = (BoolQueryBuilder) rewritten;
            .filter(QueryBuilders.termQuery("field1", "value1"))
        }
        // Add 18 size terms
            initialTerms[i] = "status_" + i;
            .should(QueryBuilders.termQuery("color", "blue"))
    public void testNonBooleanQuery() {
            .mustNot(QueryBuilders.termQuery("status", "deleted"))
            query.filter(QueryBuilders.termQuery("f1", "v" + i));
        // Add 20 term queries for the same field
        QueryBuilder query = QueryBuilders.boolQuery()
    public void testMixedTermsAndTermQueriesBelowThreshold() {
        assertThat(result.filter().get(0), instanceOf(TermsQueryBuilder.class));
        for (int i = 0; i < 20; i++) {
            .filter(QueryBuilders.termQuery("field2", "value2"))
/*
            query.filter(QueryBuilders.termQuery("status", "status_" + i).boost(2.0f));
        assertThat(rewritten, instanceOf(BoolQueryBuilder.class));
        // Should have 3 queries: NO merging in must clause
            .filter(QueryBuilders.termsQuery("status", "active", "pending"))
        for (int i = 0; i < 20; i++) {
    }
    }
    public void testExistingTermsQueryExpansionAboveThreshold() {
        // Test merging a large number of term queries
        assertThat(rewrittenBool.should().get(0), instanceOf(TermsQueryBuilder.class));
    }
            initialValues[i] = "v" + i;
        assertSame(query, rewritten); // No changes expected (total 6 values < 16)
        for (int i = 0; i < 17; i++) {
        TermsQueryBuilder termsQuery = (TermsQueryBuilder) nestedRewritten.filter().get(0);
        // Add 5 more term queries to exceed threshold
        QueryBuilder query = QueryBuilders.boolQuery()
            query.should(QueryBuilders.termQuery("tag", "t" + i));
        for (int i = 0; i < 50; i++) {
        // Add 20 color terms
        for (int i = 0; i < 10; i++) {
        }
    }
        assertThat(rewritten, instanceOf(BoolQueryBuilder.class));
        // Mix of existing terms queries and term queries with many values
        assertThat(termsQuery.values().size(), equalTo(20));
        }
        QueryBuilder query = QueryBuilders.boolQuery();
        assertSame(query, rewritten);
        // Should have 2 terms queries: one for color, one for size
        QueryBuilder rewritten = rewriter.rewrite(query, context);
    }
        // Add 20 terms with same boost
        QueryBuilder rewritten = rewriter.rewrite(query, context);
    public void testMixedFieldsAboveThresholdOnlyMergesPerField() {
        QueryBuilder rewritten = rewriter.rewrite(query, context);
    public void testSimpleTermMergingBelowThreshold() {
        assertThat(rewrittenBool.filter().size(), equalTo(1));
        BoolQueryBuilder rewrittenBool = (BoolQueryBuilder) rewritten;
        assertThat(rewrittenBool.filter().size(), equalTo(1));
        assertThat(b.filter().size(), equalTo(6));
        assertSame(query, rewritten); // No changes expected
        QueryBuilder rewritten = rewriter.rewrite(query, context);
        TermsQueryBuilder merged = (TermsQueryBuilder) result.filter().get(0);
        BoolQueryBuilder rewrittenBool = (BoolQueryBuilder) rewritten;
            .filter(QueryBuilders.termQuery("status", "active").boost(1.0f))
    public void testMixedTermsAndTermQueriesAboveThreshold() {
        TermsQueryBuilder termsQuery = (TermsQueryBuilder) rewrittenBool.filter().get(0);
        }
        BoolQueryBuilder query = QueryBuilders.boolQuery();
        }
        assertThat(result.filter().size(), equalTo(1));
        // Boost values should be preserved when merging many terms
        }
import static org.mockito.Mockito.mock;
            .filter(QueryBuilders.termQuery("field", "v3"))
        assertThat(rewrittenBool.must().size(), equalTo(3));
import org.opensearch.index.query.QueryShardContext;
            .must(QueryBuilders.rangeQuery("price").gt(100));
        assertThat(rewrittenBool.must().size(), equalTo(1));
        // Should have one terms query with all values
        QueryBuilder rewritten = rewriter.rewrite(query, context);
 * The OpenSearch Contributors require contributions made to
            query.filter(QueryBuilders.termQuery("f2", "v" + i));
        for (int i = 14; i < 19; i++) {
        QueryBuilder rewritten = rewriter.rewrite(query, context);
        assertThat(rewrittenBool.filter().size(), equalTo(1));
    public void testMustNotClauseNoMerging() {
        BoolQueryBuilder query = QueryBuilders.boolQuery().filter(QueryBuilders.termsQuery("field", initialValues));
package org.opensearch.search.query.rewriters;
    }
            .filter(QueryBuilders.termsQuery("field", "v4", "v5"))
            query.should(QueryBuilders.termQuery("size", "size_" + i));
        }
            .must(QueryBuilders.termQuery("category", "electronics"))
        assertThat(rewrittenBool.should().get(1), instanceOf(TermsQueryBuilder.class));
import static org.hamcrest.Matchers.equalTo;
    }
        for (int i = 0; i < 20; i++) {
        QueryBuilder query = QueryBuilders.termQuery("field", "value");
        assertThat(termsQuery.boost(), equalTo(2.0f));
        BoolQueryBuilder b = (BoolQueryBuilder) rewritten;
        QueryBuilder rewritten = rewriter.rewrite(query, context);
        BoolQueryBuilder rewrittenBool = (BoolQueryBuilder) rewritten;
import org.opensearch.index.query.QueryBuilders;
            .should(QueryBuilders.termQuery("size", "medium"));
        String[] initialTerms = new String[14];
            query.filter(QueryBuilders.termQuery("field", "value" + i));
        assertSame(query, rewritten);
    }
        BoolQueryBuilder rewrittenBool = (BoolQueryBuilder) rewritten;
    public void testEmptyBooleanQuery() {
    public void testLargeTermsMerging() {
        assertThat(b.should().size(), equalTo(1));
 * this file be licensed under the Apache-2.0 license or a
        assertSame(query, rewritten); // No changes expected
            query.filter(QueryBuilders.termQuery("field", "v" + i));
    }
        // one terms for f1, and 5 single terms for f2
        QueryBuilder query = QueryBuilders.boolQuery()
        TermsQueryBuilder terms = (TermsQueryBuilder) result.filter().get(0);
        QueryBuilder query = QueryBuilders.boolQuery()
            query.filter(QueryBuilders.termQuery("category", "cat_" + i));
        }
        }
        assertThat(rewritten, instanceOf(BoolQueryBuilder.class));
        assertThat(rewrittenBool.should().size(), equalTo(2));
 * SPDX-License-Identifier: Apache-2.0
        BoolQueryBuilder query = QueryBuilders.boolQuery();
        assertThat(merged.values().size(), equalTo(20));
        // Single term query should not be converted to terms query
    public void testShouldClauseMergingAboveThreshold() {
import org.opensearch.test.OpenSearchTestCase;
import org.opensearch.index.query.TermsQueryBuilder;
        QueryBuilder rewritten = rewriter.rewrite(query, context);
    public void testMixedBoostNoMerging() {
            .filter(QueryBuilders.termQuery("status", "approved"));
        BoolQueryBuilder query = QueryBuilders.boolQuery();
        assertThat(rewrittenBool.filter().get(0), instanceOf(TermsQueryBuilder.class));
            .should(QueryBuilders.termQuery("size", "large"))
        // Add more term queries to exceed threshold
        // Term queries in must clauses should NOT be merged (different semantics)
        assertThat(termsQuery.fieldName(), equalTo("category"));
        QueryBuilder rewritten = rewriter.rewrite(query, context);
            .filter(QueryBuilders.termQuery("field3", "value3"));
        QueryBuilder rewritten = rewriter.rewrite(query, context);
        // Ensure should clauses merge when exceeding threshold
        // Existing terms query should be expanded when total terms exceed threshold
    private final TermsMergingRewriter rewriter = TermsMergingRewriter.INSTANCE;
        QueryBuilder query = QueryBuilders.boolQuery().filter(QueryBuilders.termQuery("field", "value"));
    }
        // Should have one terms query instead of 20 term queries
        QueryBuilder rewritten = rewriter.rewrite(query, context);
    public void testTermMergingAboveThreshold() {
        // Few term queries on same field should NOT be merged (below threshold)
    public void testNestedBooleanQuery() {
    }
        for (int i = 0; i < 18; i++) {
            nested.filter(QueryBuilders.termQuery("status", "status_" + i));
        BoolQueryBuilder query = QueryBuilders.boolQuery();
    }
 * compatible open source license.
            .filter(QueryBuilders.termQuery("status", "active"))
        assertThat(nestedRewritten.filter().get(0), instanceOf(TermsQueryBuilder.class));
        // Existing terms query with few additional terms should NOT be expanded (below threshold)
            .filter(QueryBuilders.termQuery("status", "pending"))
}
        // Different boost values should prevent merging
        BoolQueryBuilder query = QueryBuilders.boolQuery();
        BoolQueryBuilder nested = QueryBuilders.boolQuery();
        }
        BoolQueryBuilder rewrittenBool = (BoolQueryBuilder) rewritten;
    public void testShouldClauseMergingBelowThreshold() {
import static org.hamcrest.Matchers.instanceOf;
        assertThat(b.should().get(0), instanceOf(TermsQueryBuilder.class));
            .filter(QueryBuilders.termQuery("status", "approved"));
public class TermsMergingRewriterTests extends OpenSearchTestCase {
        QueryBuilder rewritten = rewriter.rewrite(query, context);
        assertThat(termsQuery.values().size(), equalTo(20));
        QueryBuilder query = QueryBuilders.boolQuery()
        QueryBuilder query = QueryBuilders.boolQuery()
        TermsQueryBuilder termsQuery = (TermsQueryBuilder) rewrittenBool.filter().get(0);
 *
        assertSame(query, rewritten);
        QueryBuilder rewritten = rewriter.rewrite(query, context);
        QueryBuilder rewritten = rewriter.rewrite(query, context);
        assertThat(rewritten, instanceOf(BoolQueryBuilder.class));
        }
        QueryBuilder query = QueryBuilders.boolQuery()
        for (int i = 0; i < 5; i++) {
        assertThat(result.filter().size(), equalTo(1));
        QueryBuilder rewritten = rewriter.rewrite(query, context);
    }
    }
        for (int i = 0; i < 20; i++) {
        assertSame(query, rewritten); // No changes expected
        }
        for (int i = 10; i < 20; i++) {
    }
        String[] initialValues = new String[10];
            .filter(QueryBuilders.termsQuery("field", "v1", "v2"))
    private final QueryShardContext context = mock(QueryShardContext.class);
    public void testMustClauseNoMerging() {
    }
 */
            query.filter(QueryBuilders.termQuery("status", "status_" + i));
        QueryBuilder rewritten = rewriter.rewrite(query, context);
        BoolQueryBuilder nestedRewritten = (BoolQueryBuilder) rewrittenBool.must().get(0);
        QueryBuilder rewritten = rewriter.rewrite(query, context);
        // Should merge all into a single terms query
        // Add 20 term queries to exceed threshold
import org.opensearch.index.query.QueryBuilder;
    }
        // Should clauses with few terms should NOT be merged
        for (int i = 0; i < 18; i++) {
        assertThat(termsQuery.values().size(), equalTo(20));
            .mustNot(QueryBuilders.termQuery("status", "archived"));
    }
