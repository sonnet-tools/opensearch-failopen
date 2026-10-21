        QueryBuilder nested = QueryBuilders.boolQuery()
        TermQueryBuilder termQuery = (TermQueryBuilder) rewrittenBool.must().get(0);
        QueryBuilder rewritten = rewriter.rewrite(query, context);
        BoolQueryBuilder rewrittenBool = (BoolQueryBuilder) rewritten;
        assertThat(rewritten, instanceOf(BoolQueryBuilder.class));
        // Nested should with MSM should not be flattened
        QueryBuilder query = QueryBuilders.boolQuery()
    }
        assertThat(rewritten, instanceOf(BoolQueryBuilder.class));
        // Nested bool with queryName should not be flattened
        // Must_not clauses should NOT be flattened to preserve semantics
    }
    public void testDeMorganPatternNotFlattenedUnderMustNot() {
        // where intermediate bool wrappers are removed entirely. Our current implementation
    public void testDoNotFlattenWhenNestedHasNonDefaultBoost() {
        assertThat(rewritten, instanceOf(BoolQueryBuilder.class));
    public void testIdempotence() {
    public void testMixedClauseTypes() {
    }
    public void testMustNotClauseNoFlattening() {
 * The OpenSearch Contributors require contributions made to
        assertThat(rewritten, instanceOf(BoolQueryBuilder.class));
    }
        BoolQueryBuilder nested = QueryBuilders.boolQuery().queryName("inner").must(QueryBuilders.termQuery("f", "v"));
        QueryBuilder rewritten = rewriter.rewrite(query, context);
        // Empty boolean query should not cause issues
        QueryBuilder query = QueryBuilders.boolQuery().must(nested1).filter(nested2);
            .minimumShouldMatch(2)
        BoolQueryBuilder rewrittenBool = (BoolQueryBuilder) rewritten;
            .should(QueryBuilders.termQuery("field1", "value1"))
            .should(QueryBuilders.termQuery("f2", "v2"))
        // only flattens by merging same-type clauses but preserves the bool structure.
        // This would require a different optimization strategy.
            .boost(2.0f)
            .must(QueryBuilders.termQuery("field2", "value2"));
        assertThat(outer.must().get(0), instanceOf(BoolQueryBuilder.class));
        assertThat(result.queryName(), equalTo("outer"));
            .must(QueryBuilders.boolQuery().queryName("inner").must(QueryBuilders.termQuery("field", "value")));
            .queryName("qn")
        QueryBuilder rewritten = rewriter.rewrite(query, context);
        QueryBuilder innermost = QueryBuilders.termQuery("field", "value");
    }
        assertThat(result.must().size(), equalTo(1));
 * SPDX-License-Identifier: Apache-2.0
        assertThat(preserved.queryName(), equalTo("inner"));
            .filter(QueryBuilders.termQuery("field2", "value2"));
        assertThat(rewritten, instanceOf(BoolQueryBuilder.class));
        QueryBuilder rewritten = rewriter.rewrite(query, context);
        assertThat(rewrittenBool.must().size(), equalTo(1));
        assertThat(outer.must().get(0), instanceOf(BoolQueryBuilder.class));
        // All nested clauses should be flattened
        QueryBuilder query = QueryBuilders.boolQuery().should(nestedShould).must(QueryBuilders.termQuery("field3", "value3"));
        assertSame(query, rewritten);
import org.opensearch.index.query.QueryShardContext;
        BoolQueryBuilder nested = QueryBuilders.boolQuery()
        BoolQueryBuilder query = QueryBuilders.boolQuery().should(nested).must(QueryBuilders.termQuery("g", "w"));
        BoolQueryBuilder query = QueryBuilders.boolQuery().must(nested);
    }
}
        assertThat(rewrittenBool.minimumShouldMatch(), equalTo("2"));
    }
    public void testShouldClauseFlattening() {
        // The nested bool should be flattened
    }
            inner.mustNot(QueryBuilders.termQuery("p", "v" + i));
        QueryBuilder query = QueryBuilders.boolQuery().mustNot(inner);
        assertThat(rewrittenBool.filter().size(), equalTo(1));
        BoolQueryBuilder rewrittenBool = (BoolQueryBuilder) rewritten;
        assertThat(outer.should().size(), equalTo(1));
        BoolQueryBuilder preserved = (BoolQueryBuilder) outer.must().get(0);
/*
        // Ensure query names are preserved during flattening
        BoolQueryBuilder result = (BoolQueryBuilder) rewritten;
    }
    public void testNestedBooleanFlattening() {
            .must(QueryBuilders.termQuery("field1", "value1"))
        QueryBuilder nestedMustNot = QueryBuilders.boolQuery().must(QueryBuilders.termQuery("field1", "value1"));
        assertThat(rewritten, instanceOf(BoolQueryBuilder.class));
        // Should be flattened to single level bool with term query
        assertThat(outer.must().size(), equalTo(1));
        BoolQueryBuilder outer = (BoolQueryBuilder) rewritten;
        QueryBuilder rewritten = rewriter.rewrite(query, context);
        QueryBuilder query = QueryBuilders.boolQuery().mustNot(nestedMustNot).must(QueryBuilders.termQuery("field2", "value2"));
        // TODO: This test expects complete flattening of deeply nested bool queries
        BoolQueryBuilder rewrittenBool = (BoolQueryBuilder) rewritten;
        assertThat(rewrittenBool.boost(), equalTo(2.0f));
        assertThat(preserved.must().size(), equalTo(1));
            innermost = QueryBuilders.boolQuery().must(innermost);
import org.opensearch.index.query.QueryBuilder;
            .should(QueryBuilders.termQuery("field2", "value2"))
    public void testDoNotFlattenWhenNestedHasQueryName() {
        assertThat(rewrittenBool.must().size(), equalTo(1));
 * this file be licensed under the Apache-2.0 license or a
        QueryBuilder deepNested = QueryBuilders.boolQuery()
        assertThat(rewritten, instanceOf(BoolQueryBuilder.class));
    public void testMultipleNestedBooleansFlattening() {
            .must(QueryBuilders.boolQuery().must(QueryBuilders.termQuery("f", "v")))
        // Multiple nested boolean queries should all be flattened
        // Outer must_not remains and inner bool is preserved
        assertSame(query, rewritten);
        assertThat(rewritten, instanceOf(BoolQueryBuilder.class));
            .must(QueryBuilders.termQuery("field1", "value1"))
        QueryBuilder query = QueryBuilders.boolQuery()
        // Must_not should not be flattened
    public void testEmptyBooleanQuery() {
        BoolQueryBuilder rewrittenBool = (BoolQueryBuilder) rewritten;
        assertThat(rewrittenBool.should().size(), equalTo(2));
        // Deep nesting should be flattened at all levels
        assertThat(outer.must().size(), equalTo(1));
        // After one rewrite, a second rewrite should be a no-op (structurally identical)
    public void testDoubleNegationNotFlattenedUnderMustNot() {
            .should(QueryBuilders.termQuery("field1", "value1"))
        // not( bool( must: [A, B] ) ) should not be flattened by BooleanFlatteningRewriter
        QueryBuilder rewritten = rewriter.rewrite(query, context);
        BoolQueryBuilder preserved = (BoolQueryBuilder) outer.should().get(0);
        QueryBuilder rewritten = rewriter.rewrite(query, context);
    }
 *
            .should(QueryBuilders.termQuery("field2", "value2"));
        // Should clauses should be flattened
    public void testShouldClauseNotFlattenedWhenNestedHasMinimumShouldMatch() {
        BoolQueryBuilder rewrittenBool = (BoolQueryBuilder) rewritten;
    public void testQueryNamePreservation() {
        BoolQueryBuilder rewrittenBool = (BoolQueryBuilder) rewritten;
        QueryBuilder rewritten = rewriter.rewrite(query, context);
        QueryBuilder inner = QueryBuilders.boolQuery().must(QueryBuilders.termQuery("f", "A")).must(QueryBuilders.termQuery("f", "B"));
        assertThat(outer.must().size(), equalTo(1));
        assertThat(rewritten, instanceOf(BoolQueryBuilder.class));
        assertEquals(once.toString(), twice.toString());
import static org.mockito.Mockito.mock;
import org.opensearch.index.query.TermQueryBuilder;
import org.opensearch.index.query.QueryBuilders;
            .should(QueryBuilders.termQuery("f1", "v1"))
        assertThat(rewritten, instanceOf(BoolQueryBuilder.class));
        BoolQueryBuilder preserved = (BoolQueryBuilder) outer.must().get(0);
    }
public class BooleanFlatteningRewriterTests extends OpenSearchTestCase {
        assertSame(query, rewritten);
        assertThat(rewritten, instanceOf(BoolQueryBuilder.class));
        BoolQueryBuilder outer = (BoolQueryBuilder) rewritten;
            .minimumShouldMatch(1);
            .must(QueryBuilders.boolQuery().must(QueryBuilders.boolQuery().must(QueryBuilders.termQuery("field1", "value1"))));
        QueryBuilder rewritten = rewriter.rewrite(query, context);
        assertThat(rewrittenBool.queryName(), equalTo("qn"));
        assertSame(query, rewritten); // Should not flatten due to different minimumShouldMatch
        assertThat(rewrittenBool.mustNot().size(), equalTo(1));
        // Mixed clause types with different minimumShouldMatch settings
package org.opensearch.search.query.rewriters;
        assertThat(rewrittenBool.filter().size(), equalTo(1));
        BoolQueryBuilder nested = QueryBuilders.boolQuery().boost(2.0f).must(QueryBuilders.termQuery("field", "value"));
        BoolQueryBuilder query = QueryBuilders.boolQuery().must(nested);
        assertThat(rewrittenBool.must().size(), equalTo(2));
        // Test with 10 levels of nesting
        QueryBuilder once = rewriter.rewrite(query, context);
        QueryBuilder inner = QueryBuilders.boolQuery().mustNot(QueryBuilders.termQuery("product", "Oranges"));
        QueryBuilder rewritten = rewriter.rewrite(query, context);
        assertThat(rewrittenBool.mustNot().get(0), instanceOf(BoolQueryBuilder.class));
        QueryBuilder rewritten = rewriter.rewrite(query, context);
    }
    }
            .should(QueryBuilders.boolQuery().should(QueryBuilders.termQuery("f2", "v2")));
        BoolQueryBuilder query = QueryBuilders.boolQuery()
        assertThat(rewrittenBool.mustNot().size(), equalTo(1));
        // Should be flattened significantly
        QueryBuilder rewritten = rewriter.rewrite(innermost, context);
    public void testSimpleBooleanQuery() {
        QueryBuilder query = QueryBuilders.boolQuery().mustNot(inner);
    public void testDeepNesting() {
        assertThat(outer.should().get(0), instanceOf(BoolQueryBuilder.class));
        // Verify the term query details
import org.opensearch.test.OpenSearchTestCase;
        for (int i = 0; i < n; i++) {
        QueryBuilder query = QueryBuilders.termQuery("field", "value");
import static org.hamcrest.Matchers.equalTo;
        // Build inner bool with random number of must_not terms
    public void testVeryDeepNesting() {
        assertThat(rewrittenBool.mustNot().get(0), instanceOf(BoolQueryBuilder.class));
        QueryBuilder rewritten = rewriter.rewrite(query, context);
    }
    }
        QueryBuilder nestedBool = QueryBuilders.boolQuery().must(QueryBuilders.termQuery("field1", "value1"));
        QueryBuilder nested1 = QueryBuilders.boolQuery()
        QueryBuilder rewritten = rewriter.rewrite(query, context);
        QueryBuilder query = QueryBuilders.boolQuery().mustNot(inner);
    }
        QueryBuilder rewritten = rewriter.rewrite(deepNested, context);
        assertThat(rewrittenBool.must().get(0), instanceOf(QueryBuilders.termQuery("field1", "value1").getClass()));
        QueryBuilder query = QueryBuilders.boolQuery();
        assertThat(rewrittenBool.mustNot().size(), equalTo(1));
        // Simple boolean query should not be modified
        BoolQueryBuilder inner = QueryBuilders.boolQuery();
        assertThat(rewrittenBool.mustNot().get(0), instanceOf(BoolQueryBuilder.class));
        }
        }
        QueryBuilder rewritten = rewriter.rewrite(query, context);
        BoolQueryBuilder rewrittenBool = (BoolQueryBuilder) rewritten;
        assertThat(rewritten, instanceOf(BoolQueryBuilder.class));
        assertThat(rewritten, instanceOf(BoolQueryBuilder.class));
        // Nested bool with non-default boost should not be flattened
    private final BooleanFlatteningRewriter rewriter = BooleanFlatteningRewriter.INSTANCE;
 */
        for (int i = 0; i < 10; i++) {
    @AwaitsFix(bugUrl = "https://github.com/opensearch-project/OpenSearch/issues/18906")
        QueryBuilder query = QueryBuilders.boolQuery().must(nested).minimumShouldMatch(2);
        // Non-boolean queries should be returned as-is
        BoolQueryBuilder rewrittenBool = (BoolQueryBuilder) rewritten;
        assertThat(preserved.boost(), equalTo(2.0f));
            .filter(QueryBuilders.boolQuery().filter(QueryBuilders.termQuery("g", "w")));
    public void testRandomizedMustNotInnerNotFlattened() {
        // Should clauses should also be flattened
    public void testTopLevelPropertiesPreserved() {
 * compatible open source license.
import static org.hamcrest.Matchers.instanceOf;
            .must(QueryBuilders.boolQuery().must(QueryBuilders.termQuery("field", "v")))
        int n = between(1, 5);
import org.apache.lucene.tests.util.LuceneTestCase.AwaitsFix;
        // not( bool( must_not: [ term ] ) ) should NOT be flattened by the rewriter
        QueryBuilder rewritten = rewriter.rewrite(query, context);
            .minimumShouldMatch(1);
        assertThat(termQuery.fieldName(), equalTo("field1"));
        QueryBuilder twice = rewriter.rewrite(once, context);
    }
        QueryBuilder query = QueryBuilders.boolQuery()
            .queryName("outer")
    private final QueryShardContext context = mock(QueryShardContext.class);
        // Nested boolean query with single must clause should be flattened
        assertThat(rewrittenBool.mustNot().size(), equalTo(1));
        QueryBuilder nestedShould = QueryBuilders.boolQuery()
        BoolQueryBuilder result = (BoolQueryBuilder) rewritten;
    public void testNonBooleanQuery() {
        QueryBuilder nested2 = QueryBuilders.boolQuery().filter(QueryBuilders.termQuery("field3", "value3"));
        assertThat(preserved.minimumShouldMatch(), equalTo("1"));
    }
        QueryBuilder query = QueryBuilders.boolQuery().must(nestedBool).filter(QueryBuilders.termQuery("field2", "value2"));
    }
        assertThat(rewrittenBool.must().size(), equalTo(1));
        assertThat(termQuery.value(), equalTo("value1"));
        assertThat(rewrittenBool.mustNot().get(0), instanceOf(BoolQueryBuilder.class));
        QueryBuilder rewritten = rewriter.rewrite(query, context);
import org.opensearch.index.query.BoolQueryBuilder;
        assertThat(rewrittenBool.must().get(0), instanceOf(TermQueryBuilder.class));
        BoolQueryBuilder outer = (BoolQueryBuilder) rewritten;
