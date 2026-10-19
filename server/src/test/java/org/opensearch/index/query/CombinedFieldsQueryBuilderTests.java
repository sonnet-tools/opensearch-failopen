                    "type=text",
        ).minimumShouldMatch("75%");
            + "    \"query\" : \"test query\",\n"
        Query query = queryBuilder.toQuery(createShardContext());
     * Tests handling of whitespace-only query text.
                    "boosted_field",
        CombinedFieldsQueryBuilder queryBuilder = new CombinedFieldsQueryBuilder(
    public void testBoostConfiguration() {
        );  
    // ========================  
        TopDocs resultsMin2 = searcher.search(luceneQueryMin2, 10);
            + "    \"fields\" : [ \"content\" ],\n"
        assertThat("Query should be generated for empty text", query, notNullValue());  
        });  
    /**
        String queryText = "distributed systems architecture";
            anyOf(  
import org.apache.lucene.analysis.Analyzer;
            String additionalField = randomFrom(TEXT_FIELD_NAME, TEXT_ALIAS_FIELD_NAME, "content", "description", "summary");
        // Add minimum_should_match configuration
     */
        "distributed systems architecture",  
            + "}";
        assertEquals("OR operator should match all documents", 3, orResults.totalHits.value());  
        // Invalid boost format  
        assertEquals("Queries with null minimum_should_match should be equal", query4, query5);
import org.apache.lucene.search.BooleanClause;
    /**  
    /**
        // Test OR operator - should match all documents
            "Exception should mention field type support",  
            + "  }\n"
            containsString("does not support [combined_fields] queries")
    }
    public void testMinimumShouldMatchConfiguration() {  
            .operator(Operator.AND)  
    public void testWhitespaceOnlyQueryText() throws IOException {  
/**
        Map<String, Float> expectedFieldToWeight = Map.of("title", 2.0f, "content", 1.5f, "tags", 0.8f, "metadata", 1.2f);
        CombinedFieldsQueryBuilder queryBuilder = new CombinedFieldsQueryBuilder(queryText, TEXT_FIELD_NAME, INT_FIELD_NAME);
    /**  
    public void testMinimumShouldMatchJsonSerialization() throws IOException {  
        IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> queryBuilder.boost(-1.0f));
        Query luceneOrQuery = orQuery.toQuery(createShardContext());
    public void testOrOperatorQueryGeneration() throws IOException {
     * Tests field boost parsing validation.
        ).minimumShouldMatch("2");
        assertThat(
        "natural language processing techniques",
        assertEquals("Fields should be preserved", original.fieldToWeight(), deserialized.fieldToWeight());
    /**  
        String queryText = "test wildcard field patterns";  
    }  
        CombinedFieldsQueryBuilder original = new CombinedFieldsQueryBuilder(queryText, TEXT_FIELD_NAME, TEXT_ALIAS_FIELD_NAME + "^1.5")  
        CombinedFieldsQueryBuilder queryBuilder = new CombinedFieldsQueryBuilder(queryText, TEXT_FIELD_NAME);
    // ========================
        IndexWriterConfig iwc = new IndexWriterConfig(analyzer);  
     */
            + "    \"minimum_should_match\" : \"75%\"\n"  
import org.apache.lucene.search.Query;
        // Test with very large number  
        );
    // ========================
     * Tests query construction with multiple fields and boosts.  
            deserialized.minimumShouldMatch()
    }
        assertEquals("Should have 4 fields", 4, fields.size());
        }  
    }
    }  
        String queryText = "   ";
        Query query = queryBuilder.toQuery(createShardContext());  
        // Verify no exceptions are thrown  
            "Exception should mention field type support",  
    /**
import java.util.Map;  
        // Valid boost values  
    }
 * 1. Test Infrastructure Setup
    }
        assertEquals("Complex minimum should match should be parsed correctly", "2<75%", parsedWithComplex.minimumShouldMatch());
    /**
            () -> new CombinedFieldsQueryBuilder("test", (String[]) null)
     */
        String json = "{\n"
    /**
    }  
     */
        IndexWriterConfig iwc = new IndexWriterConfig(analyzer);  
    public void testNonTextFieldRejection() throws IOException {  
    protected void initializeAdditionalMappings(MapperService mapperService) throws IOException {
        String queryText = "comprehensive test query with all features";
     */
     */
            + "  }\n"
    }  
import static org.hamcrest.Matchers.containsString;
            new CompressedXContent(
    }  
        CombinedFieldsQueryBuilder query1 = new CombinedFieldsQueryBuilder(queryText, field).minimumShouldMatch("75%");
    public void testJsonSerializationWithMultipleFields() throws IOException {
    }
    }
            assertThat("Query should be generated even with phrase-like text", query, notNullValue());
            queryBuilder.minimumShouldMatch(randomMinimumShouldMatch());  
        queryBuilder.minimumShouldMatch(null);  
 * this file be licensed under the Apache-2.0 license or a
import static org.hamcrest.Matchers.notNullValue;
        addTestDocument(writer, "content", "machine learning");
 * Test Structure:
        queryBuilder.minimumShouldMatch("-25%");
    /**
     * Tests JSON serialization with comprehensive field configuration.
    /**  
        queryBuilder.minimumShouldMatch(minimumShouldMatch);  
    /**  
    /**  
     */
     * Tests basic query construction with single field.  
        assertEquals("Operator should be preserved", original.operator(), deserialized.operator());
        CombinedFieldsQueryBuilder queryBuilder = new CombinedFieldsQueryBuilder(queryText, "wildcard_field_*");
                    "description",  
        IndexWriter writer = new IndexWriter(dir, iwc);
            + "    \"fields\" : [ \"content\" ],\n"
            + "    \"_name\" : \"test_combined_fields_query\"\n"  
        assertEquals("Query text should match", queryText, queryBuilder.queryValue());  
        CombinedFieldsQueryBuilder deserialized = (CombinedFieldsQueryBuilder) parseQuery(json);
        CombinedFieldsQueryBuilder queryBuilder = new CombinedFieldsQueryBuilder(queryText, TEXT_FIELD_NAME);
    protected CombinedFieldsQueryBuilder doCreateTestQueryBuilder() {
            "title",  
        Query luceneQueryMin75 = queryWithMin75.toQuery(createShardContext());
     */
        CombinedFieldsQueryBuilder queryBuilder = new CombinedFieldsQueryBuilder(queryText, TEXT_FIELD_NAME);
            assertEquals("All clauses should be SHOULD for OR operator", BooleanClause.Occur.SHOULD, clause.occur());
        CombinedFieldsQueryBuilder queryBuilder = new CombinedFieldsQueryBuilder(queryText, TEXT_FIELD_NAME);
        CombinedFieldsQueryBuilder parsedWithNumber = (CombinedFieldsQueryBuilder) parseQuery(jsonWithNumber);
        assertEquals("Tags should have boost 1.5", 1.5f, fields.get("tags"), 1e-6);  
        queryBuilder.minimumShouldMatch("   ");  
     */
        assertEquals("Boost should match", 1.5f, parsed.boost(), 1e-6);  
    /**  
        // Test setting minimum_should_match
            + "  \"combined_fields\" : {\n"  
     */  
        assertEquals("Queries with null minimum_should_match should have same hashCode", query4.hashCode(), query5.hashCode());  
                    "tags",  
            query,
    }
            + "    \"minimum_should_match\" : \"2<75%\"\n"  
 * 4. Serialization Tests
        String queryText = "";
                    "type=text",
        );
            + "  \"combined_fields\" : {\n"  
        Query query = queryBuilder.toQuery(createShardContext());
        // Test with complex value
     */
        );
    /**
        assertThat("Query should not be null", query, notNullValue());
        Map<String, Float> fields = validQuery.fieldToWeight();
import static org.hamcrest.CoreMatchers.instanceOf;  
        // Should handle whitespace-only query gracefully
    // ========================  
        reader.close();
        assertThat(
        assertThat("Exception should mention invalid input", exception.getMessage(), containsString("invalid"));
    // ========================
        IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> queryBuilder.toQuery(createShardContext()));
        // Test with negative percentage
 */  
                    "type=keyword",
     * Tests operator configuration and behavior.  
        // Test with empty string
    public void testBasicQueryConstruction() {
        assertEquals("Operator should be AND", Operator.AND, queryBuilder.operator());
            .queryName("serialization_test");
     * Helper method to add a document to the test index.
 * Comprehensive test suite for CombinedFieldsQueryBuilder functionality.
        // 75% of 3 terms = 2.25, rounded up to 3 terms required
    @Override  
        addTestDocument(writer, "content", "learning");
        Query query = queryBuilder.toQuery(createShardContext());
        String queryName = "test_named_query";  
    // ========================
     * Tests rejection of non-text field types.
        assertEquals("Query name should be set correctly", queryName, queryBuilder.queryName());
        assertEquals("AND operator should match only complete phrase", 1, andResults.totalHits.value());  
            + "    \"fields\" : [ \"content\" ],\n"
        assertEquals("Should have one field", 1, queryBuilder.fieldToWeight().size());
        assertThat("Exception should mention query value", nullValueException.getMessage(), containsString("requires query value"));  
     */  
import org.apache.lucene.document.Field;
    // ========================
        // Test equals
            .boost(2.0f)  
     */  
    public void testSerializationConsistency() throws IOException {
                instanceOf(MatchNoDocsQuery.class),
        assertEquals("Operator should match", Operator.AND, parsed.operator());
            + "  \"combined_fields\" : {\n"  
        mapperService.merge(  
        assertEquals("Should parse boost correctly", 1.5f, fields.get("field"), 1e-6);  
 * 5. Functional Behavior Tests  
                instanceOf(CombinedFieldQuery.class)
import java.io.IOException;
            .operator(Operator.OR)
    }
        String queryText = "test query";
        assertEquals("Query value should be preserved", original.queryValue(), deserialized.queryValue());  
        IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> queryBuilder.toQuery(createShardContext()));
        String jsonWithComplex = "{\n"
        Map<String, Float> fields = queryBuilder.fieldToWeight();  
            )  
        );  
    public void testMixedFieldTypesRejection() throws IOException {  
    private static final String[] TEST_QUERY_TEXTS = {
     * Tests minimum_should_match edge cases and validation.
        return true;
            float boost = 1.0f + randomFloat() * 3.0f;  
        CombinedFieldsQueryBuilder query2 = new CombinedFieldsQueryBuilder(queryText, field).minimumShouldMatch("75%");  
        // Should handle empty query gracefully
        } catch (IllegalArgumentException e) {
    /**  
    }
    private void addTestDocument(IndexWriter writer, String field, String value) throws IOException {  
            "content^2.0",
        Query luceneQueryMin2 = queryWithMin2.toQuery(createShardContext());
        assertEquals("Boost should be preserved", original.boost(), deserialized.boost(), 1e-6);
 * compatible open source license.
        BooleanQuery booleanQuery = (BooleanQuery) query;  
 * 7. Edge Case Tests
     */
        CombinedFieldsQueryBuilder queryBuilder = new CombinedFieldsQueryBuilder(queryText, primaryField);  
    }
}
            queryBuilder.operator(randomFrom(Operator.values()));
        assertEquals("Query name should match", "test_combined_fields_query", parsed.queryName());
        addTestDocument(writer, "content", "machine learning");  
        String field = "content";
        int additionalFields = randomIntBetween(0, 2);  
            + "    \"minimum_should_match\" : \"75%\",\n"
    /**  
        IndexSearcher searcher = new IndexSearcher(reader);  
 *  
import org.apache.lucene.search.MatchAllDocsQuery;
        }
import org.apache.lucene.document.TextField;
        assertTrue("Should match documents with at least 2 terms", resultsMin2.totalHits.value() == 3);  
            String fieldWithBoost = additionalField + "^" + boost;
        assertEquals("Title should have default boost", 1.0f, fields.get("title"), 1e-6);  
            + "    \"query\" : \"distributed systems architecture\",\n"
        writer.addDocument(doc);  
        assertEquals("Queries with same minimum_should_match should have same hashCode", query1.hashCode(), query2.hashCode());  
        assertEquals(
     * Tests constructor validation with null/invalid inputs.
    /**
            () -> new CombinedFieldsQueryBuilder(null, "content")
        NumberFormatException exception = expectThrows(
            exception.getMessage(),
        // Test with minimum_should_match = "2" (at least 2 terms)
    /**  
import org.apache.lucene.search.TermQuery;
    public void testFieldBoostValidation() {  
        for (Map.Entry<String, Float> entry : parsed.fieldToWeight().entrySet()) {  
        assertEquals("Minimum should match should be set correctly", minimumShouldMatch, queryBuilder.minimumShouldMatch());
import org.opensearch.action.admin.indices.mapping.put.PutMappingRequest;  
     */
        CombinedFieldsQueryBuilder parsed = (CombinedFieldsQueryBuilder) parseQuery(json);
        float positiveBoost = 2.5f;  
        assertThat("Query should be a BooleanQuery for OR operator", query, instanceOf(BooleanQuery.class));
        // Test with numeric value
        String numericValue = "2";
     */
     * Tests handling of unmapped fields.
    }
            () -> new CombinedFieldsQueryBuilder(queryText, "field^invalid")  
    public void testMultipleFieldsWithBoosts() {
        String minimumShouldMatch = "75%";
            original.minimumShouldMatch(),
 * SPDX-License-Identifier: Apache-2.0
            + "    \"query\" : \"test query\",\n"
/*  
                instanceOf(TermQuery.class),
            containsString("does not support [combined_fields] queries")
            "tags^1.5"  
    protected boolean supportsQueryName() {
        queryBuilder.queryName(queryName);
import org.opensearch.index.mapper.MapperService;
        // Test hashCode
            .queryName("comprehensive_test");  
        for (int i = 0; i < additionalFields; i++) {
        }
        assertEquals("Query name should be preserved", original.queryName(), deserialized.queryName());
    protected void doAssertLuceneQuery(CombinedFieldsQueryBuilder queryBuilder, Query query, QueryShardContext context) {
        assertThat("Exception should mention field list", nullFieldsException.getMessage(), containsString("requires field list"));  
        }  
        assertEquals("Numeric minimum should match should be parsed correctly", "2", parsedWithNumber.minimumShouldMatch());
        doc.add(new TextField(field, value, Field.Store.NO));
        queryBuilder.operator(Operator.AND);  
        TopDocs orResults = searcher.search(luceneOrQuery, 10);
        writer.close();  
        // Random configuration
        Query luceneAndQuery = andQuery.toQuery(createShardContext());
            + "    \"fields\" : [ \"title^2.0\", \"content^1.5\", \"tags^0.8\", \"metadata^1.2\" ],\n"
import org.apache.lucene.search.IndexSearcher;
            .operator(Operator.OR);  
        String queryText = "natural language processing";  
        // Verify no exceptions are thrown
    public void testMinimumShouldMatchFunctionalBehavior() throws IOException {  
     */
            "Query should be of expected type",
        queryBuilder.minimumShouldMatch("");
    public void testOperatorBehaviorFunctional() throws IOException {  
        assertEquals("Percentage minimum should match should be parsed correctly", "75%", parsedWithPercentage.minimumShouldMatch());
        String queryText = "machine learning algorithms";  
        // Add test documents with multiple terms  
        CombinedFieldsQueryBuilder queryBuilder = new CombinedFieldsQueryBuilder(queryText, INT_FIELD_NAME);
        assertThat("Should have clauses for multi-term query", booleanQuery.clauses().size(), notNullValue());
    }  
    @Override  
import org.apache.lucene.store.Directory;
    // ========================
    // CONFIGURATION TESTS
    // TEST INFRASTRUCTURE SETUP
    // QUERY CONSTRUCTION TESTS
                    "summary",
        Document doc = new Document();
            queryText,
import org.apache.lucene.index.IndexWriterConfig;  
    // SERIALIZATION TESTS
            + "}";
        assertEquals("Field count should match", 4, parsed.fieldToWeight().size());
        addTestDocument(writer, "content", "learning algorithms");
        CombinedFieldsQueryBuilder queryBuilder = new CombinedFieldsQueryBuilder(queryText, TEXT_FIELD_NAME);
        Analyzer analyzer = new StandardAnalyzer();
import org.apache.lucene.search.BooleanQuery;
        CombinedFieldsQueryBuilder queryBuilder = new CombinedFieldsQueryBuilder(queryText, TEXT_FIELD_NAME);
        // Should match documents with at least 2 of the 3 terms
        assertNotEquals("Queries with different minimum_should_match should not be equal", query1, query3);  
        assertEquals("Minimum should match should match", "75%", parsed.minimumShouldMatch());
        if (randomBoolean()) {  
    }
        queryBuilder.minimumShouldMatch(numericValue);
        // Test with null minimum_should_match  
     * Tests comprehensive query construction with all features.
            "Minimum should match should be preserved in serialization",  
    /**
            .minimumShouldMatch("50%")
            Operator.OR
            MapperService.MergeReason.MAPPING_UPDATE  
        // Test with whitespace-only string
     * Tests minimum_should_match functional behavior with real queries.
     * Tests query name configuration.  
        assertEquals("Chained minimum should match should be set", "50%", queryBuilder.minimumShouldMatch());  
     */
        assertEquals("Field count should be 2", 2, queryBuilder.fieldToWeight().size());  
        assertEquals("Numeric minimum should match should be set correctly", numericValue, queryBuilder.minimumShouldMatch());  
        // Add additional fields with random boosts
        CombinedFieldsQueryBuilder parsedWithComplex = (CombinedFieldsQueryBuilder) parseQuery(jsonWithComplex);
import org.apache.lucene.search.MatchNoDocsQuery;  
        "machine learning algorithms",
import org.apache.lucene.index.IndexReader;
    public void testPhraseQueryHandling() throws IOException {  
        CombinedFieldsQueryBuilder queryBuilder = new CombinedFieldsQueryBuilder(queryText, TEXT_FIELD_NAME);
            .boost(1.8f)
        try {
        queryBuilder.operator(Operator.OR);  
        TopDocs resultsMin75 = searcher.search(luceneQueryMin75, 10);
        Directory dir = new ByteBuffersDirectory();
    // ========================  
     * Tests handling of wildcard field patterns.  
    // FUNCTIONAL BEHAVIOR TESTS  
        Directory dir = new ByteBuffersDirectory();
    public void testUnmappedFieldsHandling() throws IOException {  
 * 2. Query Construction Tests  
    // MINIMUM_SHOULD_MATCH TESTS  
import org.apache.lucene.store.ByteBuffersDirectory;
            "_doc",
    // ========================  
        addTestDocument(writer, "content", "machine learning algorithms");
package org.opensearch.index.query;
        CombinedFieldsQueryBuilder chained = queryBuilder.minimumShouldMatch("50%");
        CombinedFieldsQueryBuilder queryBuilder = new CombinedFieldsQueryBuilder(queryText, TEXT_FIELD_NAME);  
        IndexReader reader = DirectoryReader.open(dir);
        assertTrue("Should contain the specified field", queryBuilder.fieldToWeight().containsKey(TEXT_FIELD_NAME));
        IndexSearcher searcher = new IndexSearcher(reader);  
    public void testMinimumShouldMatchEdgeCases() {  
    /**  
        assertEquals("Minimum should match should be 75%", "75%", queryBuilder.minimumShouldMatch());
        CombinedFieldsQueryBuilder queryBuilder = new CombinedFieldsQueryBuilder(queryText, "unmapped_field_1", "unmapped_field_2");
    protected boolean supportsBoost() {
        CombinedFieldsQueryBuilder queryBuilder = new CombinedFieldsQueryBuilder(queryText, TEXT_FIELD_NAME, TEXT_ALIAS_FIELD_NAME + "^1.5")
            + "  }\n"
        assertEquals("Queries with same minimum_should_match should be equal", query1, query2);
        CombinedFieldsQueryBuilder validQuery = new CombinedFieldsQueryBuilder(queryText, "field^1.5", "field2^2.0");
     * Tests handling of empty query text.
        String queryText = "test query";  
        "cloud computing infrastructure",
        String queryText = "named query test";  
        // Test setting numeric value  
        // The documents should be: "machine learning algorithms" (3 terms), "machine learning" (2 terms), "learning algorithms" (2 terms)
        Analyzer analyzer = new StandardAnalyzer();
    // HELPER METHODS  
     * Tests rejection of mixed field types.
        assertEquals("Large number should be preserved", "999999", queryBuilder.minimumShouldMatch());
    }
import org.apache.lucene.index.IndexWriter;
            + "}";
    protected boolean builderGeneratesCacheableQueries() {  
        assertEquals("Should parse boost correctly", 2.0f, fields.get("field2"), 1e-6);
        assertEquals("Operator should be AND", Operator.AND, queryBuilder.operator());
        CombinedFieldsQueryBuilder original = new CombinedFieldsQueryBuilder("test query", "content").minimumShouldMatch("50%")
    }
    /**  
                PutMappingRequest.simpleMapping(  
     * Tests minimum_should_match in equals and hashCode methods.
            + "    \"operator\" : \"AND\",\n"  
            NumberFormatException.class,
        CombinedFieldsQueryBuilder queryBuilder = new CombinedFieldsQueryBuilder(queryText, TEXT_FIELD_NAME).operator(Operator.OR);  
            // If phrases are explicitly not supported, this is also acceptable  
        // Test serialization round-trip
        addTestDocument(writer, "content", "machine");  
    @Override
        // Test AND operator - should only match "machine learning"
            + "    \"query\" : \"test query\",\n"
     */
            Operator.OR
        // This should match fewer documents than the "2" minimum_should_match
        assertEquals("Content should have boost 2.0", 2.0f, fields.get("content"), 1e-6);
        CombinedFieldsQueryBuilder queryWithMin75 = new CombinedFieldsQueryBuilder("machine learning algorithms", "content").operator(  
    }
        assertTrue("Should match documents with 75% of terms", resultsMin75.totalHits.value() == 3);  
            .minimumShouldMatch("75%")
        assertEquals("Boost should be 1.8", 1.8f, queryBuilder.boost(), 1e-6);  
        assertEquals("Empty string should be preserved", "", queryBuilder.minimumShouldMatch());  
        TopDocs andResults = searcher.search(luceneAndQuery, 10);
        dir.close();  
        assertEquals("Negative percentage should be preserved", "-25%", queryBuilder.minimumShouldMatch());  
    // ========================
    // ========================
        // Test setting null value
     */
        CombinedFieldsQueryBuilder query5 = new CombinedFieldsQueryBuilder(queryText, field).minimumShouldMatch(null);  
     * Tests minimum_should_match JSON serialization and parsing.
        CombinedFieldsQueryBuilder queryWithMin2 = new CombinedFieldsQueryBuilder("machine learning algorithms", "content").operator(  
        String queryText = "test query with unmapped fields";
        String queryText = "boosted query test";  
public class CombinedFieldsQueryBuilderTests extends AbstractQueryTestCase<CombinedFieldsQueryBuilder> {
     * Tests boost configuration and validation.  
            exception.getMessage(),
        dir.close();  
            + "    \"boost\" : 1.5,\n"
     */
    public void testMinimumShouldMatchEqualsAndHashCode() {  
        "data science methodologies",  
    public void testWildcardFieldPatterns() throws IOException {
    public void testConstructorValidation() {
        assertEquals("Whitespace-only string should be preserved", "   ", queryBuilder.minimumShouldMatch());
        "artificial intelligence applications" };
    }
        addTestDocument(writer, "content", "machine");
     */
    public void testEmptyQueryTextHandling() throws IOException {
    // ========================  
        CombinedFieldsQueryBuilder queryBuilder = new CombinedFieldsQueryBuilder(queryText, TEXT_FIELD_NAME);
        CombinedFieldsQueryBuilder parsedWithPercentage = (CombinedFieldsQueryBuilder) parseQuery(jsonWithPercentage);
            + "}";
                ).toString()
        IllegalArgumentException nullFieldsException = expectThrows(
        // Should work but phrase aspect may be ignored or handled appropriately
     * Tests OR operator query generation behavior.
    }
                    "type=text",  
    // ========================
     */
    // ========================
 * 6. Error Condition Tests
    }
import org.opensearch.common.compress.CompressedXContent;
import org.apache.lucene.search.CombinedFieldQuery;  
        String queryText = "serialization test query";
import org.apache.lucene.analysis.standard.StandardAnalyzer;
    @Override
        return queryBuilder;  
        assertEquals("Query name should match", "comprehensive_test", queryBuilder.queryName());
        assertEquals("Query value should match", "distributed systems architecture", parsed.queryValue());
        String queryText = "test query";
        assertThat("Generated query should not be null", query, notNullValue());
    /**
import org.apache.lucene.search.TopDocs;  
        String queryText = "test query";
    }  
        IndexReader reader = DirectoryReader.open(dir);
 */  
        assertThat("Exception message should mention negative boost", exception.getMessage(), containsString("negative [boost]"));
     * Tests minimum_should_match configuration and getter/setter methods.
        assertThat(  
    /**  
        CombinedFieldsQueryBuilder query3 = new CombinedFieldsQueryBuilder(queryText, field).minimumShouldMatch("50%");
            assertEquals("Field weight should match for " + entry.getKey(), weight, entry.getValue(), 1e-6);
import org.apache.lucene.index.DirectoryReader;  
            IllegalArgumentException.class,  
        // Test method chaining  
        assertEquals("Boost should be set correctly", positiveBoost, queryBuilder.boost(), 1e-6);
        );
        IndexWriter writer = new IndexWriter(dir, iwc);
                    "content",
        addTestDocument(writer, "content", "algorithms");
        CombinedFieldsQueryBuilder query4 = new CombinedFieldsQueryBuilder(queryText, field).minimumShouldMatch(null);
        // Test with minimum_should_match = "75%" (75% of terms, rounded down, so 2 terms)
    public void testComprehensiveQueryConstruction() throws IOException {  
            "summary^0.5",
     */  
            Float weight = expectedFieldToWeight.get(entry.getKey());
     */  
    }
        assertThat("Query should be generated for wildcard fields", query, notNullValue());
        String queryText = "test query";
        );
    // ========================
        String json = original.toString();  
        );
        CombinedFieldsQueryBuilder orQuery = new CombinedFieldsQueryBuilder("machine learning", "content").operator(Operator.OR);  
        if (randomBoolean()) {
        assertNotEquals("Queries with different minimum_should_match should have different hashCode", query1.hashCode(), query3.hashCode());
                    "type=keyword",
        queryBuilder.minimumShouldMatch("999999");
        reader.close();
                instanceOf(BooleanQuery.class),
        Query query = queryBuilder.toQuery(createShardContext());  
        booleanQuery.clauses().forEach(clause -> {
        assertEquals("Minimum should match should be preserved", original.minimumShouldMatch(), deserialized.minimumShouldMatch());  
        assertSame("Method chaining should return same instance", queryBuilder, chained);
import org.apache.lucene.document.Document;  
 * The OpenSearch Contributors require contributions made to  
    // ========================
            + "  \"combined_fields\" : {\n"  
    }  
        assertEquals("Query text should match", queryText, queryBuilder.queryValue());
import org.opensearch.test.AbstractQueryTestCase;  
    @Override
    }
    /**
     * Tests serialization and deserialization consistency.
        Query query = queryBuilder.toQuery(createShardContext());  
    // EDGE CASE TESTS  
        String queryText = "\"phrase query\"";
            IllegalArgumentException.class,  
     * Tests phrase query handling (should not support phrases).
        CombinedFieldsQueryBuilder deserialized = (CombinedFieldsQueryBuilder) parseQuery(serialized);  
    // ========================
        return true;  
                instanceOf(MatchAllDocsQuery.class),  
    // TEST DATA CONSTANTS
        CombinedFieldsQueryBuilder andQuery = new CombinedFieldsQueryBuilder("machine learning", "content").operator(Operator.AND);  
                    "type=text"  
    }
    // ========================
                    "metadata",
        queryBuilder.boost(positiveBoost);
            assertThat("Exception should mention phrase support", e.getMessage(), containsString("phrases"));
 *
            + "    \"minimum_should_match\" : \"2\"\n"  
            Query query = queryBuilder.toQuery(createShardContext());  
        writer.close();  
        );  
        String jsonWithNumber = "{\n"
        IllegalArgumentException nullValueException = expectThrows(
import static org.hamcrest.CoreMatchers.anyOf;
        assertThat("Query should be MatchNoDocsQuery for unmapped fields", query, instanceOf(MatchNoDocsQuery.class));
     * Tests functional operator behavior with real Lucene index.
        }
        assertEquals("Operator should be OR", Operator.OR, queryBuilder.operator());
    public void testOperatorConfiguration() {
    }  
 * 3. Configuration Tests (operators, zero terms, etc.)
        String queryText = "minimum should match test";
            ),
        String primaryField = randomFrom(TEXT_FIELD_NAME, TEXT_ALIAS_FIELD_NAME, "content", "description", "summary");
        return true;
    @Override
            queryBuilder = new CombinedFieldsQueryBuilder(queryText, primaryField, fieldWithBoost);
        assertEquals("Summary should have boost 0.5", 0.5f, fields.get("summary"), 1e-6);
    // ========================  
        String queryText = "test query";
        String serialized = original.toString();
        String queryText = randomFrom(TEST_QUERY_TEXTS);  
        String jsonWithPercentage = "{\n"
    /**  
    public void testQueryNameConfiguration() {
        // Test with percentage value
        assertNull("Null minimum should match should be set correctly", queryBuilder.minimumShouldMatch());
    // ERROR CONDITION TESTS
            + "  }\n"
