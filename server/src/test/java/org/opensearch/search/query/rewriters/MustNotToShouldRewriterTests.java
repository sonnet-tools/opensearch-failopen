    @Override  
    public void testMultipleQueriesOnSameFieldNotRewritten() {  
import static org.mockito.Mockito.mock;
        QueryBuilder query = QueryBuilders.boolQuery()
        assertThat(rewritten, instanceOf(BoolQueryBuilder.class));
            .must(QueryBuilders.termQuery("type", "product"))
        IndexWriter writer = new IndexWriter(multiDir, new IndexWriterConfig(Lucene.STANDARD_ANALYZER));
        assertThat(rewrittenBool.mustNot().size(), equalTo(0));
        assertThat(rewrittenBool.adjustPureNegative(), equalTo(false));
        assertThat(rewritten, instanceOf(BoolQueryBuilder.class));  
import org.opensearch.common.lucene.Lucene;
        QueryBuilder query = QueryBuilders.boolQuery().mustNot(QueryBuilders.termQuery("status", 5));
        // Make parse return the input value as a Number
 * this file be licensed under the Apache-2.0 license or a
    }  
    public void testRangeQueryRewritten() {
            if (must instanceof BoolQueryBuilder) {  
        // The must_not clause should be removed  
            .mustNot(QueryBuilders.rangeQuery("age").gte(18))
            .should(QueryBuilders.termQuery("category", "B"))
        assertThat(rewrittenBool.must().size(), equalTo(1));
        // Setup non-numeric field types
}  
        QueryBuilder rewritten = rewriter.rewrite(query, context);
        // Test that must_not terms query on numeric field is rewritten
            }  
        // Test that existing must/filter/should clauses are preserved
        // Original clauses should be preserved
        // Since we added a must clause, minimumShouldMatch should be set to 1  
    public void testNestedBooleanQueriesRewritten() {
import org.opensearch.index.query.BoolQueryBuilder;
        QueryBuilder query = QueryBuilders.boolQuery().mustNot(QueryBuilders.termsQuery("status", new Object[] { 1, 2, 3 }));
        }
        QueryBuilder nested = QueryBuilders.boolQuery().mustNot(QueryBuilders.rangeQuery("age").gte(18));
        assertThat(rewrittenBool.should().size(), equalTo(1));
        QueryBuilder query = QueryBuilders.boolQuery()  
        assertSame(query, rewritten);
import org.apache.lucene.index.IndexWriter;
        BoolQueryBuilder rewrittenBool = (BoolQueryBuilder) rewritten;
        // With null context, no rewriting should happen  
            Document doc = new Document();  
        assertThat(nestedBool.should().size(), equalTo(2)); // Two range queries for complement  
        NumberFieldMapper.NumberFieldType intFieldType = mock(NumberFieldMapper.NumberFieldType.class);
    public void testNonBoolQueryUnchanged() {
        assertThat(rewrittenBool.must().size(), equalTo(1));
        });
 * The OpenSearch Contributors require contributions made to  
        // Verify rewriter has correct priority
        // Should have the original term query plus a new bool query from the rewrite  
        assertThat(rewrittenBool.must().size(), equalTo(1));
        // Setup numeric field types
        doc.add(new IntPoint("multi_age", 10));
                return (Number) arg;
        assertThat(rewrittenBool.must().size(), equalTo(2));
    }  
        assertNotNull(nestedBool);  
                nestedBool = (BoolQueryBuilder) must;
        BoolQueryBuilder rewrittenBool = (BoolQueryBuilder) rewritten;
        Directory multiDir = newDirectory();
            .queryName("my_query")  
    public void testIdempotence() {
            .mustNot(QueryBuilders.termQuery("name", "test"))
        assertThat(rewritten, instanceOf(BoolQueryBuilder.class));
    public void testMinimumShouldMatchHandling() {
            doc.add(new IntPoint("status", i % 10));
        assertThat(rewritten, instanceOf(BoolQueryBuilder.class));  
        IndexWriterConfig config = new IndexWriterConfig(Lucene.STANDARD_ANALYZER);
            }  
        // Should have a new bool query from the rewrite  
        BoolQueryBuilder rewrittenBool = (BoolQueryBuilder) rewritten;
import org.apache.lucene.store.Directory;
        assertThat(rewriter.priority(), equalTo(175));  
        when(context.fieldMapper("price")).thenReturn(intFieldType);
        // Test that must_not range query is rewritten to should clauses  
            if (arg instanceof Number) {
        QueryBuilder query = QueryBuilders.boolQuery().mustNot(QueryBuilders.matchQuery("age", 25));  
            writer.addDocument(doc);  
    }
        QueryBuilder rewritten = rewriter.rewrite(query, context);
        // Should not rewrite because docs can have multiple values
            .adjustPureNegative(false);
    public void testNumericTermQueryRewritten() {
    public void testNumericMatchQueryRewritten() {
        assertThat(rewrittenBool.mustNot().size(), equalTo(0));
        QueryBuilder query = QueryBuilders.boolQuery().mustNot(QueryBuilders.rangeQuery("age").gte(18));
    public void testRewriterPriority() {
        context = mock(QueryShardContext.class);  
        // Create an index with single-valued numeric fields
            return Integer.parseInt(arg.toString());
        QueryBuilder query = QueryBuilders.boolQuery().must(nested);  
            .filter(QueryBuilders.rangeQuery("price").gte(100))
        assertSame(query, rewritten);
        // Test that must_not match query on numeric field is rewritten
        when(context.fieldMapper("age")).thenReturn(intFieldType);  
import static org.mockito.Mockito.when;  
        QueryBuilder query = QueryBuilders.boolQuery().mustNot(QueryBuilders.rangeQuery("multi_age").gte(15));  
    }
        QueryBuilder rewritten = rewriter.rewrite(query, context);
        when(intFieldType.parse(any())).thenAnswer(invocation -> {
import org.apache.lucene.document.Document;
        assertThat(rewrittenBool.must().size(), equalTo(2)); // Original + rewritten
        for (QueryBuilder must : rewrittenBool.must()) {
            .should(QueryBuilders.termQuery("category", "A"))
    }
        writer.addDocument(doc);  
        // numeric field type mapping
        }
        QueryBuilder query = QueryBuilders.boolQuery()
        // All bool query properties should be preserved
        assertThat(rewrittenBool.mustNot().size(), equalTo(0));
            .should(QueryBuilders.termQuery("featured", true))  
        assertThat(rewrittenBool.must().get(0), instanceOf(BoolQueryBuilder.class));
    }
        assertThat(rewritten, instanceOf(BoolQueryBuilder.class));  
        assertThat(rewrittenBool.boost(), equalTo(2.0f));
        MappedFieldType textFieldType = mock(MappedFieldType.class);
        assertThat(innerBool.mustNot().size(), equalTo(0));  
 */  
import org.opensearch.index.query.QueryShardContext;
    private IndexReader reader;
        QueryBuilder rewritten = rewriter.rewrite(query, context);
import org.apache.lucene.index.DirectoryReader;  
    public void testNumericTermsQueryRewritten() {  
    }
        assertThat(nestedBool.should().size(), equalTo(2)); // Two range queries for complement
    }
            .mustNot(QueryBuilders.rangeQuery("age").gte(18));
    }
import org.apache.lucene.index.IndexReader;
        QueryBuilder rewritten = rewriter.rewrite(query, null);  
import org.apache.lucene.index.IndexWriterConfig;  
    }
            .mustNot(QueryBuilders.rangeQuery("age").gte(18))  
        directory.close();
        QueryBuilder rewritten = rewriter.rewrite(query, context);
        when(context.fieldMapper("status")).thenReturn(intFieldType);
    public void testNullContextNoRewrite() {
        QueryBuilder query = QueryBuilders.boolQuery()  
package org.opensearch.search.query.rewriters;
        BoolQueryBuilder innerBool = (BoolQueryBuilder) rewrittenBool.must().get(0);
import org.opensearch.index.mapper.MappedFieldType;  
        BoolQueryBuilder nestedBool = null;
 * compatible open source license.
        // Test that nested boolean queries are also rewritten  
        // Test that must_not term query on numeric field is rewritten  
import org.opensearch.test.OpenSearchTestCase;  
        doc.add(new IntPoint("multi_age", 20));
        BoolQueryBuilder rewrittenBool = (BoolQueryBuilder) rewritten;  
        QueryBuilder query = QueryBuilders.boolQuery()
        // Test that must_not queries on text fields are not rewritten  
        multiReader.close();
        assertThat(nestedBool.minimumShouldMatch(), equalTo("1"));
        BoolQueryBuilder nestedBool = (BoolQueryBuilder) rewrittenBool.must().get(0);
            .must(QueryBuilders.termQuery("type", "product"))  
            .must(QueryBuilders.termQuery("type", "product"))
        assertThat(rewrittenBool.must().size(), equalTo(1));  
    }  
        QueryBuilder rewritten = rewriter.rewrite(query, context);  
            .mustNot(QueryBuilders.matchQuery("description", "product"));  
        // Should have a new bool query from the rewrite
        BoolQueryBuilder rewrittenBool = (BoolQueryBuilder) rewritten;
        QueryBuilder rewritten = rewriter.rewrite(query, context);
        IndexWriter writer = new IndexWriter(directory, config);
        // Test that minimumShouldMatch is properly handled
        QueryBuilder rewritten = rewriter.rewrite(query, context);  
    }
        BoolQueryBuilder rewrittenBool = (BoolQueryBuilder) rewritten;
import org.opensearch.index.query.QueryBuilders;
        // Properties should be preserved
        assertThat(rewritten, instanceOf(BoolQueryBuilder.class));  
        super.setUp();
        QueryBuilder query = QueryBuilders.boolQuery()  
        when(context.getIndexReader()).thenReturn(reader);
        QueryBuilder query = QueryBuilders.termQuery("field", "value");  
        writer.close();
/*  
        assertSame(query, rewritten); // No changes
        QueryBuilder rewritten = rewriter.rewrite(query, context);  
    @Override
        QueryBuilder twice = rewriter.rewrite(once, context);
        assertThat(rewrittenBool.queryName(), equalTo("my_query"));  
        QueryBuilder query = QueryBuilders.boolQuery()
        assertThat(rewrittenBool.minimumShouldMatch(), equalTo("1"));
import static org.mockito.ArgumentMatchers.any;
    public void tearDown() throws Exception {
        assertSame(query, rewritten);  
            .mustNot(QueryBuilders.rangeQuery("age").lte(65));
        multiDir.close();  
        // Non-bool queries should not be changed
        QueryBuilder rewritten = rewriter.rewrite(query, context);
import static org.hamcrest.Matchers.equalTo;
    public void testMultiValuedNumericFieldNotRewritten() throws Exception {
    private QueryShardContext context;
    public void testBoolQueryPropertiesPreserved() {
        QueryBuilder once = rewriter.rewrite(query, context);  
                break;
        when(intFieldType.numberType()).thenReturn(NumberFieldMapper.NumberType.INTEGER);  
        // Test that multiple must_not queries on the same field are not rewritten
        directory = newDirectory();  
        for (int i = 0; i < 100; i++) {
        assertThat(rewrittenBool.mustNot().size(), equalTo(0));
        when(context.fieldMapper("description")).thenReturn(textFieldType);
            .filter(QueryBuilders.rangeQuery("price").gte(100));
        QueryBuilder rewritten = rewriter.rewrite(query, context);
        reader.close();
    private Directory directory;  
        QueryBuilder rewritten = rewriter.rewrite(query, context);  
import org.opensearch.index.query.QueryBuilder;  
        QueryBuilder rewritten = rewriter.rewrite(query, context);  
        reader = DirectoryReader.open(directory);
    private final MustNotToShouldRewriter rewriter = MustNotToShouldRewriter.INSTANCE;
        // The nested bool should be rewritten  
        // Query without must_not clauses should not be changed
    }  
        QueryBuilder query = QueryBuilders.boolQuery().mustNot(QueryBuilders.termQuery("status", 3));
        BoolQueryBuilder rewrittenBool = (BoolQueryBuilder) rewritten;
        assertThat(rewrittenBool.filter().size(), equalTo(1));  
        assertThat(nestedBool.minimumShouldMatch(), equalTo("1"));
    public void testExistingMustClausesPreserved() {
        writer.close();  
        // Find the nested bool query  
        BoolQueryBuilder rewrittenBool = (BoolQueryBuilder) rewritten;
    public void setUp() throws Exception {
import org.apache.lucene.document.IntPoint;
        Document doc = new Document();  
        IndexReader multiReader = DirectoryReader.open(multiDir);  
import org.opensearch.index.mapper.NumberFieldMapper;
    public void testNoMustNotClausesNoChanges() {  
        assertThat(rewrittenBool.mustNot().size(), equalTo(0));  
    }  
 * SPDX-License-Identifier: Apache-2.0
        // Should have a new bool query from the rewrite
 *
        when(context.fieldMapper("multi_age")).thenReturn(intFieldType);
        assertThat(rewritten, instanceOf(BoolQueryBuilder.class));
            doc.add(new IntPoint("age", i));
        assertThat(rewritten, instanceOf(BoolQueryBuilder.class));
public class MustNotToShouldRewriterTests extends OpenSearchTestCase {
    }
        assertEquals(once.toString(), twice.toString());
        // Add some documents with single-valued numeric fields
        NumberFieldMapper.NumberFieldType intFieldType = mock(NumberFieldMapper.NumberFieldType.class);  
        assertSame(query, rewritten); // No changes  
            .boost(2.0f)
        assertThat(innerBool.must().size(), equalTo(1)); // The rewritten clause
import static org.hamcrest.Matchers.instanceOf;  
    }
    public void testTextFieldNotRewritten() {
    }  
        assertSame(query, rewritten);
        super.tearDown();  
            .mustNot(QueryBuilders.rangeQuery("age").gte(18));  
        // Create an index where a field has multiple values per doc  
        when(context.fieldMapper("name")).thenReturn(textFieldType);  
    }
            .mustNot(QueryBuilders.rangeQuery("age").gte(18).lte(65));  
            Object arg = invocation.getArgument(0);  
        assertThat(rewriter.name(), equalTo("must_not_to_should"));
        when(context.getIndexReader()).thenReturn(multiReader);
