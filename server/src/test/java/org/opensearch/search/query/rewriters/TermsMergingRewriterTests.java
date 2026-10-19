    public void testMixedBoostNoMerging() {
    }
        for (int i = 0; i < 5; i++) {
package org.opensearch.search.query.rewriters;
        }  
        QueryBuilder rewritten = rewriter.rewrite(query, context);  
        assertThat(termsQuery.values().size(), equalTo(20));
        for (int i = 0; i < 10; i++) {
    }  
        QueryBuilder rewritten = rewriter.rewrite(query, context);
            .should(QueryBuilders.termQuery("size", "large"))
            .must(QueryBuilders.termQuery("category", "computers"))  
        QueryBuilder rewritten = rewriter.rewrite(query, context);  
    }
        QueryBuilder query = QueryBuilders.boolQuery()
/*  
            query.filter(QueryBuilders.termQuery("field", "value" + i));
        QueryBuilder query = QueryBuilders.boolQuery()  
        for (int i = 0; i < 20; i++) {
        }
    }
        QueryBuilder rewritten = rewriter.rewrite(query, context);  
            .filter(QueryBuilders.termQuery("field", "v6"));
        assertThat(result.filter().get(0), instanceOf(TermsQueryBuilder.class));
        BoolQueryBuilder nestedRewritten = (BoolQueryBuilder) rewrittenBool.must().get(0);  
        }
        // Test merging a large number of term queries
        assertThat(rewritten, instanceOf(BoolQueryBuilder.class));
    }  
 * compatible open source license.
        TermsQueryBuilder termsQuery = (TermsQueryBuilder) nestedRewritten.filter().get(0);
        // Term queries in must clauses should NOT be merged (different semantics)  
        assertThat(termsQuery.values().size(), equalTo(20));
    }
        QueryBuilder rewritten = rewriter.rewrite(query, context);
            .filter(QueryBuilders.termQuery("status", "active"))
        assertThat(nestedRewritten.filter().size(), equalTo(1));
    }  
        QueryBuilder rewritten = rewriter.rewrite(query, context);  
        QueryBuilder query = QueryBuilders.termQuery("field", "value");
        }
        // Non-boolean queries should be returned as-is
        assertThat(b.should().size(), equalTo(1));
        // Mix of existing terms queries and term queries with many values
        }
        assertThat(result.filter().size(), equalTo(1));
        QueryBuilder rewritten = rewriter.rewrite(query, context);  
        BoolQueryBuilder rewrittenBool = (BoolQueryBuilder) rewritten;
            .filter(QueryBuilders.termsQuery("status", "active", "pending"))
import static org.hamcrest.Matchers.equalTo;
    public void testShouldMergingWithThreshold() {
        BoolQueryBuilder query = QueryBuilders.boolQuery();  
        for (int i = 0; i < 14; i++) {
    public void testMustNotClauseNoMerging() {
    }
 * this file be licensed under the Apache-2.0 license or a
        assertThat(rewrittenBool.must().size(), equalTo(3));
    }  
        assertSame(query, rewritten); // No changes expected
            .filter(QueryBuilders.termQuery("field1", "value1"))
    public void testTermMergingAboveThreshold() {
        // Add 18 size terms
import static org.hamcrest.Matchers.instanceOf;  
            .mustNot(QueryBuilders.termQuery("status", "deleted"))
        // Different boost values should prevent merging  
            .filter(QueryBuilders.termQuery("field3", "value3"));
        // Existing terms query with few additional terms should NOT be expanded (below threshold)
    }
        BoolQueryBuilder rewrittenBool = (BoolQueryBuilder) rewritten;
        // Many term queries on same field should be merged (above threshold of 16)
            query.filter(QueryBuilders.termQuery("status", "status_" + i));
    public void testExistingTermsQueryExpansionAboveThreshold() {
        BoolQueryBuilder result = (BoolQueryBuilder) rewritten;
        // Nested bool should also be rewritten
        for (int i = 0; i < 18; i++) {
        BoolQueryBuilder nested = QueryBuilders.boolQuery();
        assertThat(rewritten, instanceOf(BoolQueryBuilder.class));
        assertThat(rewrittenBool.must().size(), equalTo(1));
            query.filter(QueryBuilders.termQuery("status", "status_" + i).boost(2.0f));
        QueryBuilder rewritten = rewriter.rewrite(query, context);  
            .filter(QueryBuilders.termsQuery("field", "v1", "v2"))
        // Ensure should clauses merge when exceeding threshold
        QueryBuilder rewritten = rewriter.rewrite(query, context);
        QueryBuilder query = QueryBuilders.boolQuery().filter(QueryBuilders.termQuery("field", "value"));
        for (int i = 0; i < 20; i++) {  
        BoolQueryBuilder query = QueryBuilders.boolQuery();  
        assertThat(terms.values().size(), equalTo(50));
        BoolQueryBuilder rewrittenBool = (BoolQueryBuilder) rewritten;  
            .should(QueryBuilders.termQuery("color", "red"))
        BoolQueryBuilder query = QueryBuilders.boolQuery();  
        BoolQueryBuilder query = QueryBuilders.boolQuery().filter(QueryBuilders.termsQuery("status", initialTerms));  
        // Should clauses with many terms should be merged  
        for (int i = 0; i < 50; i++) {  
        // Should merge all into a single terms query  
        }  
    }  
        assertThat(result.filter().get(0), instanceOf(TermsQueryBuilder.class));
    }  
        TermsQueryBuilder termsQuery = (TermsQueryBuilder) rewrittenBool.filter().get(0);
 */  
        BoolQueryBuilder query = QueryBuilders.boolQuery();  
        assertThat(rewrittenBool.filter().get(0), instanceOf(TermsQueryBuilder.class));  
        assertThat(rewrittenBool.should().get(0), instanceOf(TermsQueryBuilder.class));
        // Few term queries on same field should NOT be merged (below threshold)  
        TermsQueryBuilder terms = (TermsQueryBuilder) result.filter().get(0);  
        BoolQueryBuilder b = (BoolQueryBuilder) rewritten;  
        // Should have one terms query with all values
import org.opensearch.index.query.QueryBuilder;
    }  
        // Should clauses with few terms should NOT be merged  
            .should(QueryBuilders.termQuery("color", "blue"))  
        // Should have 2 terms queries: one for color, one for size
        QueryBuilder query = QueryBuilders.boolQuery()  
    public void testSimpleTermMergingBelowThreshold() {
            .should(QueryBuilders.termQuery("size", "medium"));
        QueryBuilder rewritten = rewriter.rewrite(query, context);
        BoolQueryBuilder query = QueryBuilders.boolQuery();
            .filter(QueryBuilders.termQuery("field2", "value2"))  
        QueryBuilder rewritten = rewriter.rewrite(query, context);  
        BoolQueryBuilder query = QueryBuilders.boolQuery();
        String[] initialValues = new String[10];  
    public void testNestedBooleanQuery() {
import org.opensearch.test.OpenSearchTestCase;  
    public void testShouldClauseMergingBelowThreshold() {
            .filter(QueryBuilders.termQuery("status", "active").boost(1.0f))
    }
}
    }  
        // Should have 3 queries: NO merging in must clause
        assertThat(rewritten, instanceOf(BoolQueryBuilder.class));
        }  
        // one terms for f1, and 5 single terms for f2
    public void testLargeTermsMerging() {  
    }  
        // Existing terms query should be expanded when total terms exceed threshold  
        assertSame(query, rewritten); // No changes due to different boosts  
        QueryBuilder query = QueryBuilders.boolQuery()  
        for (int i = 0; i < 18; i++) {  
            .filter(QueryBuilders.termQuery("field", "v3"))
        QueryBuilder query = QueryBuilders.boolQuery()
        }
        assertThat(rewrittenBool.filter().size(), equalTo(1));
    public void testMixedFieldsAboveThresholdOnlyMergesPerField() {
        }
        for (int i = 0; i < 17; i++) {
    public void testBoostPreservation() {
            query.should(QueryBuilders.termQuery("color", "color_" + i));
        assertThat(termsQuery.values().size(), equalTo(19));
        BoolQueryBuilder result = (BoolQueryBuilder) rewritten;
    public void testMixedTermsAndTermQueriesBelowThreshold() {
        assertSame(query, rewritten);
        assertThat(termsQuery.fieldName(), equalTo("category"));  
        assertThat(result.filter().size(), equalTo(1));
        assertSame(query, rewritten);  
        String[] initialTerms = new String[14];
        QueryBuilder rewritten = rewriter.rewrite(query, context);  
        QueryBuilder query = QueryBuilders.boolQuery()
            query.filter(QueryBuilders.termQuery("f1", "v" + i));
        QueryBuilder rewritten = rewriter.rewrite(query, context);
        // Add 20 term queries to exceed threshold
        QueryBuilder rewritten = rewriter.rewrite(query, context);
        BoolQueryBuilder rewrittenBool = (BoolQueryBuilder) rewritten;
        }
        QueryBuilder query = QueryBuilders.boolQuery();
            .filter(QueryBuilders.termQuery("status", "pending"))  
        assertThat(rewrittenBool.should().get(1), instanceOf(TermsQueryBuilder.class));
        assertThat(b.filter().size(), equalTo(6));
        assertThat(rewritten, instanceOf(BoolQueryBuilder.class));
        assertThat(termsQuery.values().size(), equalTo(20));
        for (int i = 0; i < 20; i++) {  
    }
        // Mix of existing terms queries and term queries with few values
        QueryBuilder rewritten = rewriter.rewrite(query, context);
        for (int i = 10; i < 20; i++) {
        assertThat(rewrittenBool.filter().size(), equalTo(1));
        assertThat(termsQuery.boost(), equalTo(2.0f));
        QueryBuilder rewritten = rewriter.rewrite(query, context);
            initialTerms[i] = "status_" + i;  
    public void testEmptyBooleanQuery() {
        // Add 20 term queries for the same field
        assertSame(query, rewritten); // No changes expected
            .filter(QueryBuilders.termQuery("status", "pending").boost(2.0f));  
        // Empty boolean query should not cause issues  
            .filter(QueryBuilders.termsQuery("field", "v4", "v5"))  
    public void testMixedFieldsNoMerging() {
    public void testMixedTermsAndTermQueriesAboveThreshold() {
            query.should(QueryBuilders.termQuery("tag", "t" + i));
        QueryBuilder query = QueryBuilders.boolQuery()
        QueryBuilder rewritten = rewriter.rewrite(query, context);
        QueryBuilder query = QueryBuilders.boolQuery()
import org.opensearch.index.query.QueryShardContext;
 * SPDX-License-Identifier: Apache-2.0
            .filter(QueryBuilders.termQuery("status", "approved"));
        assertSame(query, rewritten); // No changes expected (total 6 values < 16)
            query.filter(QueryBuilders.termQuery("field", "v" + i));  
        assertThat(rewritten, instanceOf(BoolQueryBuilder.class));
import static org.mockito.Mockito.mock;
            query.filter(QueryBuilders.termQuery("category", "cat_" + i));  
            nested.filter(QueryBuilders.termQuery("status", "status_" + i));
        // Should handle nested boolean queries with many terms  
        // Add 5 more term queries to exceed threshold
        assertSame(query, rewritten); // No changes expected
    public void testExistingTermsQueryExpansionBelowThreshold() {
            .filter(QueryBuilders.termQuery("status", "approved"));
        TermsQueryBuilder termsQuery = (TermsQueryBuilder) rewrittenBool.filter().get(0);  
        QueryBuilder rewritten = rewriter.rewrite(query, context);
        assertThat(b.should().get(0), instanceOf(TermsQueryBuilder.class));
            .mustNot(QueryBuilders.termQuery("status", "archived"));
        // Must_not clauses should not be merged
            query.should(QueryBuilders.termQuery("size", "size_" + i));
 * The OpenSearch Contributors require contributions made to  
        QueryBuilder query = QueryBuilders.boolQuery().must(nested).filter(QueryBuilders.termQuery("type", "product"));
        // Single term query should not be converted to terms query  
        assertThat(rewrittenBool.should().size(), equalTo(2));  
        TermsQueryBuilder merged = (TermsQueryBuilder) result.filter().get(0);  
        BoolQueryBuilder rewrittenBool = (BoolQueryBuilder) rewritten;  
        BoolQueryBuilder rewrittenBool = (BoolQueryBuilder) rewritten;  
        for (int i = 0; i < 20; i++) {
            query.filter(QueryBuilders.termQuery("f2", "v" + i));
 *
        }  
        TermsQueryBuilder termsQuery = (TermsQueryBuilder) rewrittenBool.filter().get(0);
import org.opensearch.index.query.BoolQueryBuilder;
        assertSame(query, rewritten); // No changes expected
    public void testMustClauseNoMerging() {
public class TermsMergingRewriterTests extends OpenSearchTestCase {  
            .must(QueryBuilders.rangeQuery("price").gt(100));
    }  
        assertSame(query, rewritten); // No changes to must_not
import org.opensearch.index.query.TermsQueryBuilder;
    public void testShouldClauseMergingAboveThreshold() {
        // Add 20 terms with same boost
            initialValues[i] = "v" + i;
        // Boost values should be preserved when merging many terms
    public void testNonBooleanQuery() {  
        }
        QueryBuilder rewritten = rewriter.rewrite(query, context);
    }
        assertThat(rewritten, instanceOf(BoolQueryBuilder.class));
        BoolQueryBuilder query = QueryBuilders.boolQuery().filter(QueryBuilders.termsQuery("field", initialValues));
    private final QueryShardContext context = mock(QueryShardContext.class);  
        assertSame(query, rewritten);
        // Should have one terms query instead of 20 term queries
        // Term queries on different fields should not be merged  
    }
        BoolQueryBuilder b = (BoolQueryBuilder) rewritten;  
        assertThat(nestedRewritten.filter().get(0), instanceOf(TermsQueryBuilder.class));
    public void testSingleTermQuery() {
    private final TermsMergingRewriter rewriter = TermsMergingRewriter.INSTANCE;
        }  
        // Add more term queries to exceed threshold
        assertThat(rewrittenBool.filter().size(), equalTo(1));  
        QueryBuilder rewritten = rewriter.rewrite(query, context);  
            .must(QueryBuilders.termQuery("category", "electronics"))
        for (int i = 14; i < 19; i++) {  
        assertThat(merged.values().size(), equalTo(20));
import org.opensearch.index.query.QueryBuilders;  
        // Add 20 color terms  
