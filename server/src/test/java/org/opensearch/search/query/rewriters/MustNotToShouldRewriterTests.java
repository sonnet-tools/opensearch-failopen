import org.apache.lucene.document.IntPoint;
        QueryBuilder query = QueryBuilders.boolQuery()
            Document doc = new Document();
 */
    public void setUp() throws Exception {
        BoolQueryBuilder rewrittenBool = (BoolQueryBuilder) rewritten;
        for (QueryBuilder must : rewrittenBool.must()) {
        assertSame(query, rewritten); // No changes
        assertThat(rewrittenBool.minimumShouldMatch(), equalTo("1"));
        QueryBuilder query = QueryBuilders.boolQuery().must(nested);
        // Test that must_not term query on numeric field is rewritten
        assertThat(rewrittenBool.mustNot().size(), equalTo(0));
import org.opensearch.index.query.QueryShardContext;
        MappedFieldType textFieldType = mock(MappedFieldType.class);
        assertThat(rewriter.priority(), equalTo(175));
        assertThat(rewritten, instanceOf(BoolQueryBuilder.class));
        });
        assertThat(rewrittenBool.adjustPureNegative(), equalTo(false));
    private QueryShardContext context;
        super.setUp();
        when(context.getIndexReader()).thenReturn(multiReader);
        BoolQueryBuilder nestedBool = null;
        assertThat(rewritten, instanceOf(BoolQueryBuilder.class));
    public void testNullContextNoRewrite() {
import org.opensearch.test.OpenSearchTestCase;
import org.opensearch.index.query.QueryBuilders;
            .must(QueryBuilders.termQuery("type", "product"))
import org.apache.lucene.document.Document;
        QueryBuilder rewritten = rewriter.rewrite(query, context);
        // Setup non-numeric field types
        when(intFieldType.numberType()).thenReturn(NumberFieldMapper.NumberType.INTEGER);
        // Setup numeric field types
    public void testMultiValuedNumericFieldNotRewritten() throws Exception {
import static org.mockito.Mockito.mock;
    }
        // Since we added a must clause, minimumShouldMatch should be set to 1
                nestedBool = (BoolQueryBuilder) must;
 *
        assertThat(rewrittenBool.should().size(), equalTo(1));
            if (must instanceof BoolQueryBuilder) {
    public void testNumericMatchQueryRewritten() {
        BoolQueryBuilder rewrittenBool = (BoolQueryBuilder) rewritten;
        assertThat(nestedBool.minimumShouldMatch(), equalTo("1"));
    public void testRangeQueryRewritten() {
    }
        assertSame(query, rewritten);
    public void tearDown() throws Exception {
    }
        QueryBuilder query = QueryBuilders.boolQuery()
        }
    }
        assertThat(rewrittenBool.must().size(), equalTo(2));
        context = mock(QueryShardContext.class);
        BoolQueryBuilder rewrittenBool = (BoolQueryBuilder) rewritten;
    public void testNoMustNotClausesNoChanges() {
        QueryBuilder rewritten = rewriter.rewrite(query, context);
        QueryBuilder rewritten = rewriter.rewrite(query, context);
        QueryBuilder rewritten = rewriter.rewrite(query, context);
    public void testNumericTermsQueryRewritten() {
        QueryBuilder query = QueryBuilders.boolQuery().mustNot(QueryBuilders.rangeQuery("age").gte(18));
    }
        writer.close();
        assertThat(rewritten, instanceOf(BoolQueryBuilder.class));
        assertThat(rewrittenBool.must().size(), equalTo(1));
        when(context.fieldMapper("description")).thenReturn(textFieldType);
        assertThat(rewrittenBool.mustNot().size(), equalTo(0));
        NumberFieldMapper.NumberFieldType intFieldType = mock(NumberFieldMapper.NumberFieldType.class);
            .should(QueryBuilders.termQuery("featured", true))
            .mustNot(QueryBuilders.rangeQuery("age").gte(18).lte(65));
        QueryBuilder rewritten = rewriter.rewrite(query, context);
        assertThat(rewrittenBool.must().size(), equalTo(1));
        // The must_not clause should be removed
import static org.mockito.Mockito.when;
            .mustNot(QueryBuilders.matchQuery("description", "product"));
    }
        BoolQueryBuilder rewrittenBool = (BoolQueryBuilder) rewritten;
        reader.close();
        when(context.fieldMapper("status")).thenReturn(intFieldType);
        QueryBuilder query = QueryBuilders.boolQuery().mustNot(QueryBuilders.termsQuery("status", new Object[] { 1, 2, 3 }));
import org.opensearch.index.query.BoolQueryBuilder;
public class MustNotToShouldRewriterTests extends OpenSearchTestCase {
        reader = DirectoryReader.open(directory);
        directory = newDirectory();
import static org.hamcrest.Matchers.instanceOf;
    public void testNestedBooleanQueriesRewritten() {
        assertThat(rewritten, instanceOf(BoolQueryBuilder.class));
        // Test that must_not match query on numeric field is rewritten
        assertThat(rewritten, instanceOf(BoolQueryBuilder.class));
    public void testMultipleQueriesOnSameFieldNotRewritten() {
        // Test that minimumShouldMatch is properly handled
        assertThat(rewrittenBool.filter().size(), equalTo(1));
        // Non-bool queries should not be changed
            .mustNot(QueryBuilders.termQuery("name", "test"))
        assertNotNull(nestedBool);
        QueryBuilder query = QueryBuilders.boolQuery()
        // Verify rewriter has correct priority
        assertThat(rewriter.name(), equalTo("must_not_to_should"));
        assertThat(rewrittenBool.mustNot().size(), equalTo(0));
        assertThat(rewritten, instanceOf(BoolQueryBuilder.class));
            writer.addDocument(doc);
                return (Number) arg;
 * SPDX-License-Identifier: Apache-2.0
        IndexWriterConfig config = new IndexWriterConfig(Lucene.STANDARD_ANALYZER);
        QueryBuilder once = rewriter.rewrite(query, context);
        QueryBuilder rewritten = rewriter.rewrite(query, null);
/*
        assertThat(rewrittenBool.queryName(), equalTo("my_query"));
 * The OpenSearch Contributors require contributions made to
    public void testTextFieldNotRewritten() {
        assertThat(rewritten, instanceOf(BoolQueryBuilder.class));
        QueryBuilder rewritten = rewriter.rewrite(query, context);
    private Directory directory;
        // Test that existing must/filter/should clauses are preserved
    public void testBoolQueryPropertiesPreserved() {
    }
        BoolQueryBuilder rewrittenBool = (BoolQueryBuilder) rewritten;
        assertThat(innerBool.mustNot().size(), equalTo(0));
import org.opensearch.index.query.QueryBuilder;
    @Override
}
            }
        // Test that nested boolean queries are also rewritten
        BoolQueryBuilder rewrittenBool = (BoolQueryBuilder) rewritten;
        when(intFieldType.parse(any())).thenAnswer(invocation -> {
        assertSame(query, rewritten);
 * compatible open source license.
        writer.addDocument(doc);
            }
package org.opensearch.search.query.rewriters;
    }
    public void testNonBoolQueryUnchanged() {
        // Create an index where a field has multiple values per doc
        BoolQueryBuilder nestedBool = (BoolQueryBuilder) rewrittenBool.must().get(0);
            .mustNot(QueryBuilders.rangeQuery("age").gte(18))
            .boost(2.0f)
    }
        assertThat(rewrittenBool.boost(), equalTo(2.0f));
        QueryBuilder query = QueryBuilders.boolQuery().mustNot(QueryBuilders.matchQuery("age", 25));
            return Integer.parseInt(arg.toString());
    public void testRewriterPriority() {
 * this file be licensed under the Apache-2.0 license or a
    }
            .must(QueryBuilders.termQuery("type", "product"))
        multiReader.close();
        QueryBuilder query = QueryBuilders.termQuery("field", "value");
import org.opensearch.common.lucene.Lucene;
        assertThat(rewrittenBool.must().size(), equalTo(1));
        assertThat(nestedBool.should().size(), equalTo(2)); // Two range queries for complement
        QueryBuilder twice = rewriter.rewrite(once, context);
            .adjustPureNegative(false);
            .mustNot(QueryBuilders.rangeQuery("age").lte(65));
        // Should have a new bool query from the rewrite
            .filter(QueryBuilders.rangeQuery("price").gte(100));
        QueryBuilder query = QueryBuilders.boolQuery()
    }
    public void testMinimumShouldMatchHandling() {
    public void testIdempotence() {
        // Create an index with single-valued numeric fields
        Document doc = new Document();
        when(context.fieldMapper("age")).thenReturn(intFieldType);
        assertSame(query, rewritten);
        QueryBuilder rewritten = rewriter.rewrite(query, context);
    }
    }
import static org.mockito.ArgumentMatchers.any;
                break;
import org.apache.lucene.index.IndexWriter;
        // Should have the original term query plus a new bool query from the rewrite
import org.opensearch.index.mapper.NumberFieldMapper;
    @Override
        QueryBuilder query = QueryBuilders.boolQuery().mustNot(QueryBuilders.rangeQuery("multi_age").gte(15));
import org.apache.lucene.store.Directory;
        when(context.fieldMapper("price")).thenReturn(intFieldType);
        BoolQueryBuilder rewrittenBool = (BoolQueryBuilder) rewritten;
        // Should not rewrite because docs can have multiple values
        // Test that must_not terms query on numeric field is rewritten
            Object arg = invocation.getArgument(0);
        // Should have a new bool query from the rewrite
import org.apache.lucene.index.IndexReader;
        IndexWriter writer = new IndexWriter(directory, config);
        // Test that must_not range query is rewritten to should clauses
        assertThat(nestedBool.should().size(), equalTo(2)); // Two range queries for complement
    }
        super.tearDown();
        // With null context, no rewriting should happen
        QueryBuilder rewritten = rewriter.rewrite(query, context);
import org.apache.lucene.index.IndexWriterConfig;
        multiDir.close();
        // Original clauses should be preserved
import static org.hamcrest.Matchers.equalTo;
            .should(QueryBuilders.termQuery("category", "B"))
            .should(QueryBuilders.termQuery("category", "A"))
        assertThat(rewrittenBool.must().size(), equalTo(1));
            .mustNot(QueryBuilders.rangeQuery("age").gte(18));
import org.opensearch.index.mapper.MappedFieldType;
        doc.add(new IntPoint("multi_age", 20));
    }
        BoolQueryBuilder rewrittenBool = (BoolQueryBuilder) rewritten;
        // Test that multiple must_not queries on the same field are not rewritten
        IndexWriter writer = new IndexWriter(multiDir, new IndexWriterConfig(Lucene.STANDARD_ANALYZER));
        when(context.getIndexReader()).thenReturn(reader);
        QueryBuilder nested = QueryBuilders.boolQuery().mustNot(QueryBuilders.rangeQuery("age").gte(18));
        assertThat(rewrittenBool.mustNot().size(), equalTo(0));
        assertThat(rewrittenBool.mustNot().size(), equalTo(0));
    public void testExistingMustClausesPreserved() {
        assertThat(rewritten, instanceOf(BoolQueryBuilder.class));
        QueryBuilder rewritten = rewriter.rewrite(query, context);
            .mustNot(QueryBuilders.rangeQuery("age").gte(18));
        assertThat(rewrittenBool.must().get(0), instanceOf(BoolQueryBuilder.class));
        assertThat(nestedBool.minimumShouldMatch(), equalTo("1"));
            doc.add(new IntPoint("age", i));
        QueryBuilder query = QueryBuilders.boolQuery()
            .filter(QueryBuilders.rangeQuery("price").gte(100))
        writer.close();
        QueryBuilder query = QueryBuilders.boolQuery().mustNot(QueryBuilders.termQuery("status", 3));
        Directory multiDir = newDirectory();
import org.apache.lucene.index.DirectoryReader;
        QueryBuilder query = QueryBuilders.boolQuery().mustNot(QueryBuilders.termQuery("status", 5));
        // Should have a new bool query from the rewrite
        when(context.fieldMapper("name")).thenReturn(textFieldType);
    }
            .queryName("my_query")
            if (arg instanceof Number) {
            .must(QueryBuilders.termQuery("type", "product"))
        assertSame(query, rewritten); // No changes
        // Properties should be preserved
        // Add some documents with single-valued numeric fields
        assertThat(rewrittenBool.must().size(), equalTo(2)); // Original + rewritten
        doc.add(new IntPoint("multi_age", 10));
        assertSame(query, rewritten);
        BoolQueryBuilder innerBool = (BoolQueryBuilder) rewrittenBool.must().get(0);
        for (int i = 0; i < 100; i++) {
        QueryBuilder rewritten = rewriter.rewrite(query, context);
        QueryBuilder query = QueryBuilders.boolQuery()
    private final MustNotToShouldRewriter rewriter = MustNotToShouldRewriter.INSTANCE;
        when(context.fieldMapper("multi_age")).thenReturn(intFieldType);
    }
        IndexReader multiReader = DirectoryReader.open(multiDir);
        // The nested bool should be rewritten
        // Make parse return the input value as a Number
        }
        QueryBuilder rewritten = rewriter.rewrite(query, context);
        // Find the nested bool query
            .mustNot(QueryBuilders.rangeQuery("age").gte(18))
        QueryBuilder rewritten = rewriter.rewrite(query, context);
    private IndexReader reader;
        // numeric field type mapping
    }
        // All bool query properties should be preserved
        QueryBuilder query = QueryBuilders.boolQuery()
        directory.close();
        // Test that must_not queries on text fields are not rewritten
        assertThat(innerBool.must().size(), equalTo(1)); // The rewritten clause
        QueryBuilder rewritten = rewriter.rewrite(query, context);
    public void testNumericTermQueryRewritten() {
        NumberFieldMapper.NumberFieldType intFieldType = mock(NumberFieldMapper.NumberFieldType.class);
            doc.add(new IntPoint("status", i % 10));
        assertEquals(once.toString(), twice.toString());
        // Query without must_not clauses should not be changed
