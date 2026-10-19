/*  
    @AwaitsFix(bugUrl = "https://github.com/opensearch-project/OpenSearch/issues/18906")  
        // Should clauses should also be flattened
    }
        assertThat(preserved.queryName(), equalTo("inner"));
    private final QueryShardContext context = mock(QueryShardContext.class);
        assertThat(rewrittenBool.mustNot().get(0), instanceOf(BoolQueryBuilder.class));
        }
        assertThat(rewrittenBool.mustNot().size(), equalTo(1));  
            .minimumShouldMatch(1);  
        assertSame(query, rewritten);  
 * The OpenSearch Contributors require contributions made to  
        BoolQueryBuilder query = QueryBuilders.boolQuery().must(nested);
            .must(QueryBuilders.boolQuery().must(QueryBuilders.termQuery("field", "v")))
        assertThat(rewritten, instanceOf(BoolQueryBuilder.class));
    }
        // After one rewrite, a second rewrite should be a no-op (structurally identical)  
    public void testRandomizedMustNotInnerNotFlattened() {
        // Nested should with MSM should not be flattened
    public void testIdempotence() {
        QueryBuilder query = QueryBuilders.boolQuery();  
        QueryBuilder nestedMustNot = QueryBuilders.boolQuery().must(QueryBuilders.termQuery("field1", "value1"));
    }  
        BoolQueryBuilder rewrittenBool = (BoolQueryBuilder) rewritten;  
        BoolQueryBuilder rewrittenBool = (BoolQueryBuilder) rewritten;
        assertThat(rewritten, instanceOf(BoolQueryBuilder.class));
    public void testShouldClauseFlattening() {  
        assertThat(preserved.boost(), equalTo(2.0f));
            .should(QueryBuilders.termQuery("f2", "v2"))
        QueryBuilder twice = rewriter.rewrite(once, context);  
public class BooleanFlatteningRewriterTests extends OpenSearchTestCase {
    }
        // Multiple nested boolean queries should all be flattened  
        BoolQueryBuilder preserved = (BoolQueryBuilder) outer.should().get(0);
        assertThat(outer.should().get(0), instanceOf(BoolQueryBuilder.class));
        QueryBuilder query = QueryBuilders.boolQuery().should(nestedShould).must(QueryBuilders.termQuery("field3", "value3"));  
        assertThat(rewritten, instanceOf(BoolQueryBuilder.class));
        assertEquals(once.toString(), twice.toString());
import static org.mockito.Mockito.mock;
        // Verify the term query details
        // Simple boolean query should not be modified
            inner.mustNot(QueryBuilders.termQuery("p", "v" + i));  
    }  
        // Must_not clauses should NOT be flattened to preserve semantics  
import org.opensearch.index.query.QueryBuilders;
        assertThat(outer.should().size(), equalTo(1));  
        QueryBuilder rewritten = rewriter.rewrite(query, context);
        assertThat(termQuery.value(), equalTo("value1"));
    public void testDoNotFlattenWhenNestedHasQueryName() {
        // The nested bool should be flattened
        assertSame(query, rewritten);
        TermQueryBuilder termQuery = (TermQueryBuilder) rewrittenBool.must().get(0);
        BoolQueryBuilder outer = (BoolQueryBuilder) rewritten;
        // Build inner bool with random number of must_not terms
    }  
        QueryBuilder rewritten = rewriter.rewrite(query, context);  
            .queryName("outer")  
    }  
        QueryBuilder query = QueryBuilders.boolQuery()
    public void testMustNotClauseNoFlattening() {
        QueryBuilder once = rewriter.rewrite(query, context);
        // only flattens by merging same-type clauses but preserves the bool structure.
        QueryBuilder rewritten = rewriter.rewrite(query, context);
        // Outer must_not remains and inner bool is preserved
        QueryBuilder inner = QueryBuilders.boolQuery().mustNot(QueryBuilders.termQuery("product", "Oranges"));
        BoolQueryBuilder preserved = (BoolQueryBuilder) outer.must().get(0);  
        // Deep nesting should be flattened at all levels
        assertThat(result.queryName(), equalTo("outer"));
        QueryBuilder deepNested = QueryBuilders.boolQuery()
        QueryBuilder rewritten = rewriter.rewrite(query, context);
    public void testDeepNesting() {
        // Nested bool with queryName should not be flattened  
package org.opensearch.search.query.rewriters;
        BoolQueryBuilder inner = QueryBuilders.boolQuery();
        assertThat(termQuery.fieldName(), equalTo("field1"));  
        QueryBuilder query = QueryBuilders.boolQuery().mustNot(nestedMustNot).must(QueryBuilders.termQuery("field2", "value2"));  
        assertSame(query, rewritten);
        // Nested bool with non-default boost should not be flattened  
        assertThat(rewritten, instanceOf(BoolQueryBuilder.class));
        assertThat(outer.must().get(0), instanceOf(BoolQueryBuilder.class));
    public void testEmptyBooleanQuery() {
    }
        QueryBuilder query = QueryBuilders.boolQuery().must(nested1).filter(nested2);
        QueryBuilder nested = QueryBuilders.boolQuery()  
        // Test with 10 levels of nesting
import org.apache.lucene.tests.util.LuceneTestCase.AwaitsFix;
    }  
        // Nested boolean query with single must clause should be flattened
import static org.hamcrest.Matchers.instanceOf;
        QueryBuilder rewritten = rewriter.rewrite(query, context);
            .minimumShouldMatch(2)  
        assertThat(outer.must().size(), equalTo(1));
    }
            .filter(QueryBuilders.termQuery("field2", "value2"));
import org.opensearch.index.query.QueryShardContext;
        QueryBuilder rewritten = rewriter.rewrite(query, context);  
    public void testVeryDeepNesting() {  
        QueryBuilder innermost = QueryBuilders.termQuery("field", "value");
            .minimumShouldMatch(1);  
        BoolQueryBuilder rewrittenBool = (BoolQueryBuilder) rewritten;
        // Non-boolean queries should be returned as-is  
        QueryBuilder query = QueryBuilders.boolQuery().mustNot(inner);
        BoolQueryBuilder outer = (BoolQueryBuilder) rewritten;  
        BoolQueryBuilder nested = QueryBuilders.boolQuery().queryName("inner").must(QueryBuilders.termQuery("f", "v"));
        for (int i = 0; i < 10; i++) {  
    public void testQueryNamePreservation() {  
        BoolQueryBuilder rewrittenBool = (BoolQueryBuilder) rewritten;
        assertThat(rewrittenBool.mustNot().size(), equalTo(1));
            .must(QueryBuilders.boolQuery().queryName("inner").must(QueryBuilders.termQuery("field", "value")));
        // Should clauses should be flattened  
    public void testDoubleNegationNotFlattenedUnderMustNot() {
        QueryBuilder rewritten = rewriter.rewrite(query, context);
        QueryBuilder rewritten = rewriter.rewrite(query, context);
        QueryBuilder nested2 = QueryBuilders.boolQuery().filter(QueryBuilders.termQuery("field3", "value3"));
            .must(QueryBuilders.termQuery("field1", "value1"))
import org.opensearch.index.query.QueryBuilder;  
    }  
    }
        BoolQueryBuilder preserved = (BoolQueryBuilder) outer.must().get(0);  
        QueryBuilder inner = QueryBuilders.boolQuery().must(QueryBuilders.termQuery("f", "A")).must(QueryBuilders.termQuery("f", "B"));  
        // where intermediate bool wrappers are removed entirely. Our current implementation  
import org.opensearch.test.OpenSearchTestCase;
        BoolQueryBuilder outer = (BoolQueryBuilder) rewritten;  
        assertThat(rewrittenBool.filter().size(), equalTo(1));  
        assertThat(rewritten, instanceOf(BoolQueryBuilder.class));
            .should(QueryBuilders.termQuery("field2", "value2"))
            .should(QueryBuilders.termQuery("field2", "value2"));
        assertThat(rewrittenBool.filter().size(), equalTo(1));
        assertThat(rewrittenBool.must().get(0), instanceOf(QueryBuilders.termQuery("field1", "value1").getClass()));
        QueryBuilder rewritten = rewriter.rewrite(query, context);  
            .must(QueryBuilders.termQuery("field1", "value1"))  
            .filter(QueryBuilders.boolQuery().filter(QueryBuilders.termQuery("g", "w")));  
        QueryBuilder rewritten = rewriter.rewrite(deepNested, context);
 * this file be licensed under the Apache-2.0 license or a
        assertThat(rewritten, instanceOf(BoolQueryBuilder.class));  
    private final BooleanFlatteningRewriter rewriter = BooleanFlatteningRewriter.INSTANCE;  
import org.opensearch.index.query.BoolQueryBuilder;
    }
        BoolQueryBuilder rewrittenBool = (BoolQueryBuilder) rewritten;
        assertThat(rewrittenBool.mustNot().get(0), instanceOf(BoolQueryBuilder.class));
        BoolQueryBuilder rewrittenBool = (BoolQueryBuilder) rewritten;
        assertThat(preserved.must().size(), equalTo(1));
        QueryBuilder query = QueryBuilders.boolQuery()
    }  
        BoolQueryBuilder nested = QueryBuilders.boolQuery()  
        QueryBuilder nested1 = QueryBuilders.boolQuery()
        int n = between(1, 5);  
    public void testShouldClauseNotFlattenedWhenNestedHasMinimumShouldMatch() {
        BoolQueryBuilder query = QueryBuilders.boolQuery()  
 */  
        QueryBuilder rewritten = rewriter.rewrite(query, context);
    public void testSimpleBooleanQuery() {  
        BoolQueryBuilder rewrittenBool = (BoolQueryBuilder) rewritten;  
        QueryBuilder query = QueryBuilders.boolQuery().must(nested).minimumShouldMatch(2);
import static org.hamcrest.Matchers.equalTo;  
        BoolQueryBuilder nested = QueryBuilders.boolQuery().boost(2.0f).must(QueryBuilders.termQuery("field", "value"));
        QueryBuilder nestedBool = QueryBuilders.boolQuery().must(QueryBuilders.termQuery("field1", "value1"));  
        QueryBuilder rewritten = rewriter.rewrite(query, context);
        assertThat(outer.must().get(0), instanceOf(BoolQueryBuilder.class));
        assertThat(rewrittenBool.must().size(), equalTo(2));
    public void testNonBooleanQuery() {
    public void testMultipleNestedBooleansFlattening() {
    public void testTopLevelPropertiesPreserved() {
        BoolQueryBuilder rewrittenBool = (BoolQueryBuilder) rewritten;  
            .must(QueryBuilders.boolQuery().must(QueryBuilders.termQuery("f", "v")))
        // Mixed clause types with different minimumShouldMatch settings
        BoolQueryBuilder result = (BoolQueryBuilder) rewritten;
        assertThat(preserved.minimumShouldMatch(), equalTo("1"));  
        // Ensure query names are preserved during flattening
        assertThat(rewrittenBool.boost(), equalTo(2.0f));
 * SPDX-License-Identifier: Apache-2.0
            .should(QueryBuilders.termQuery("field1", "value1"))
    public void testMixedClauseTypes() {
        assertThat(rewritten, instanceOf(BoolQueryBuilder.class));
        // Should be flattened significantly
        assertThat(rewritten, instanceOf(BoolQueryBuilder.class));  
    }
    }
        assertThat(rewrittenBool.must().get(0), instanceOf(TermQueryBuilder.class));
        QueryBuilder query = QueryBuilders.boolQuery().mustNot(inner);
        // Must_not should not be flattened  
        // This would require a different optimization strategy.
        assertThat(outer.must().size(), equalTo(1));
        assertThat(rewrittenBool.minimumShouldMatch(), equalTo("2"));  
}  
            .should(QueryBuilders.termQuery("field1", "value1"))  
        assertThat(rewrittenBool.queryName(), equalTo("qn"));
        assertThat(rewrittenBool.must().size(), equalTo(1));  
        BoolQueryBuilder query = QueryBuilders.boolQuery().must(nested);
        BoolQueryBuilder result = (BoolQueryBuilder) rewritten;
        QueryBuilder query = QueryBuilders.boolQuery()
        QueryBuilder query = QueryBuilders.boolQuery().must(nestedBool).filter(QueryBuilders.termQuery("field2", "value2"));
            .must(QueryBuilders.termQuery("field2", "value2"));  
        // not( bool( must_not: [ term ] ) ) should NOT be flattened by the rewriter  
        QueryBuilder query = QueryBuilders.termQuery("field", "value");
            .should(QueryBuilders.termQuery("f1", "v1"))
            .should(QueryBuilders.boolQuery().should(QueryBuilders.termQuery("f2", "v2")));
        QueryBuilder rewritten = rewriter.rewrite(query, context);
        QueryBuilder rewritten = rewriter.rewrite(query, context);
        // TODO: This test expects complete flattening of deeply nested bool queries
            .boost(2.0f)
        assertThat(rewrittenBool.should().size(), equalTo(2));
        assertThat(result.must().size(), equalTo(1));  
    public void testDoNotFlattenWhenNestedHasNonDefaultBoost() {
        BoolQueryBuilder rewrittenBool = (BoolQueryBuilder) rewritten;  
        // All nested clauses should be flattened
    public void testNestedBooleanFlattening() {
        assertThat(rewrittenBool.mustNot().get(0), instanceOf(BoolQueryBuilder.class));
        assertThat(rewritten, instanceOf(BoolQueryBuilder.class));
        assertThat(rewritten, instanceOf(BoolQueryBuilder.class));
        QueryBuilder rewritten = rewriter.rewrite(query, context);  
    }
        assertSame(query, rewritten); // Should not flatten due to different minimumShouldMatch
import org.opensearch.index.query.TermQueryBuilder;  
        assertThat(rewrittenBool.mustNot().get(0), instanceOf(BoolQueryBuilder.class));
        QueryBuilder rewritten = rewriter.rewrite(query, context);  
        assertThat(rewritten, instanceOf(BoolQueryBuilder.class));
        QueryBuilder nestedShould = QueryBuilders.boolQuery()
        }
        assertThat(rewritten, instanceOf(BoolQueryBuilder.class));  
        // not( bool( must: [A, B] ) ) should not be flattened by BooleanFlatteningRewriter
 * compatible open source license.
    public void testDeMorganPatternNotFlattenedUnderMustNot() {
        QueryBuilder query = QueryBuilders.boolQuery().mustNot(inner);
            innermost = QueryBuilders.boolQuery().must(innermost);
        assertThat(rewrittenBool.must().size(), equalTo(1));
    }  
        for (int i = 0; i < n; i++) {
        assertThat(rewrittenBool.mustNot().size(), equalTo(1));  
 *
        QueryBuilder rewritten = rewriter.rewrite(innermost, context);
        QueryBuilder rewritten = rewriter.rewrite(query, context);
    }
        assertThat(rewritten, instanceOf(BoolQueryBuilder.class));
        // Empty boolean query should not cause issues
            .queryName("qn")
        assertThat(rewrittenBool.must().size(), equalTo(1));
        BoolQueryBuilder query = QueryBuilders.boolQuery().should(nested).must(QueryBuilders.termQuery("g", "w"));
        assertThat(rewrittenBool.mustNot().size(), equalTo(1));
        assertThat(outer.must().size(), equalTo(1));
            .must(QueryBuilders.boolQuery().must(QueryBuilders.boolQuery().must(QueryBuilders.termQuery("field1", "value1"))));  
        // Should be flattened to single level bool with term query  
