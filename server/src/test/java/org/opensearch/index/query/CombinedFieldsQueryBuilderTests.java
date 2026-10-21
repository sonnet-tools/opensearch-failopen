     * Tests minimum_should_match configuration and getter/setter methods.
    // ========================
     * Tests handling of empty query text.
    /**
        try {
        "artificial intelligence applications" };
            + "  }\n"
        String jsonWithPercentage = "{\n"
import org.apache.lucene.store.Directory;
        assertEquals("Query name should be set correctly", queryName, queryBuilder.queryName());
        CombinedFieldsQueryBuilder deserialized = (CombinedFieldsQueryBuilder) parseQuery(json);
            + "  \"combined_fields\" : {\n"
import org.apache.lucene.search.BooleanClause;
            MapperService.MergeReason.MAPPING_UPDATE
import org.apache.lucene.search.BooleanQuery;
    }
        Query luceneQueryMin75 = queryWithMin75.toQuery(createShardContext());
    // CONFIGURATION TESTS
        // Invalid boost format
            + "  \"combined_fields\" : {\n"
        CombinedFieldsQueryBuilder queryBuilder = new CombinedFieldsQueryBuilder(queryText, "unmapped_field_1", "unmapped_field_2");
            + "    \"operator\" : \"AND\",\n"
    // ========================
        CombinedFieldsQueryBuilder queryBuilder = new CombinedFieldsQueryBuilder(queryText, TEXT_FIELD_NAME);
                    "type=text",
        addTestDocument(writer, "content", "machine learning algorithms");
    // ========================
            + "    \"query\" : \"test query\",\n"
import org.apache.lucene.search.TermQuery;
        assertThat("Query should be generated for wildcard fields", query, notNullValue());
        // The documents should be: "machine learning algorithms" (3 terms), "machine learning" (2 terms), "learning algorithms" (2 terms)
    }
        String queryText = "machine learning algorithms";
    public void testMinimumShouldMatchEdgeCases() {
        // Should handle empty query gracefully
     * Helper method to add a document to the test index.
        TopDocs andResults = searcher.search(luceneAndQuery, 10);
            // If phrases are explicitly not supported, this is also acceptable
     * Tests field boost parsing validation.
        );
        assertEquals("Query name should match", "comprehensive_test", queryBuilder.queryName());
    public void testBoostConfiguration() {
 * this file be licensed under the Apache-2.0 license or a
        CombinedFieldsQueryBuilder parsedWithComplex = (CombinedFieldsQueryBuilder) parseQuery(jsonWithComplex);
        // Add minimum_should_match configuration
        assertEquals("Summary should have boost 0.5", 0.5f, fields.get("summary"), 1e-6);
        // Add additional fields with random boosts
    public void testConstructorValidation() {
                instanceOf(MatchAllDocsQuery.class),
     */
    }
        String queryText = "test query";
import org.apache.lucene.index.IndexWriterConfig;
        String queryText = "natural language processing";
        );
    protected void initializeAdditionalMappings(MapperService mapperService) throws IOException {
        addTestDocument(writer, "content", "learning");
    }
        assertEquals("Percentage minimum should match should be parsed correctly", "75%", parsedWithPercentage.minimumShouldMatch());
    /**
        assertEquals("Large number should be preserved", "999999", queryBuilder.minimumShouldMatch());
            + "}";
        CombinedFieldsQueryBuilder chained = queryBuilder.minimumShouldMatch("50%");
     * Tests basic query construction with single field.
                    "type=text",
        assertNull("Null minimum should match should be set correctly", queryBuilder.minimumShouldMatch());
                instanceOf(MatchNoDocsQuery.class),
 * The OpenSearch Contributors require contributions made to
                    "metadata",
     */
                    "content",
        assertEquals("Content should have boost 2.0", 2.0f, fields.get("content"), 1e-6);
 *
        assertEquals("Should have one field", 1, queryBuilder.fieldToWeight().size());
            containsString("does not support [combined_fields] queries")
    }
        // Test OR operator - should match all documents
            + "}";
        assertThat(
        writer.close();
import org.apache.lucene.search.MatchAllDocsQuery;
 * 5. Functional Behavior Tests
            () -> new CombinedFieldsQueryBuilder(queryText, "field^invalid")
        assertEquals("Query name should be preserved", original.queryName(), deserialized.queryName());
    public void testPhraseQueryHandling() throws IOException {
    /**
 * 1. Test Infrastructure Setup
            "_doc",
import org.apache.lucene.document.Field;
        queryBuilder.boost(positiveBoost);
    public void testOrOperatorQueryGeneration() throws IOException {
    @Override
        Map<String, Float> fields = queryBuilder.fieldToWeight();
            float boost = 1.0f + randomFloat() * 3.0f;
        "machine learning algorithms",
     */
     * Tests comprehensive query construction with all features.
        String queryText = "minimum should match test";
        CombinedFieldsQueryBuilder query2 = new CombinedFieldsQueryBuilder(queryText, field).minimumShouldMatch("75%");
    @Override
    /**
            + "    \"query\" : \"test query\",\n"
    public void testMinimumShouldMatchConfiguration() {
        );
    /**
    protected boolean builderGeneratesCacheableQueries() {
 * 7. Edge Case Tests
            + "  }\n"
        int additionalFields = randomIntBetween(0, 2);
                    "description",
        Document doc = new Document();
     * Tests serialization and deserialization consistency.
    // SERIALIZATION TESTS
        queryBuilder.minimumShouldMatch("");
        Query query = queryBuilder.toQuery(createShardContext());
            "title",
    }
        CombinedFieldsQueryBuilder query4 = new CombinedFieldsQueryBuilder(queryText, field).minimumShouldMatch(null);
        Query luceneQueryMin2 = queryWithMin2.toQuery(createShardContext());
            queryBuilder.operator(randomFrom(Operator.values()));
        queryBuilder.queryName(queryName);
 * SPDX-License-Identifier: Apache-2.0
        // Test setting minimum_should_match
    protected CombinedFieldsQueryBuilder doCreateTestQueryBuilder() {
        String queryText = randomFrom(TEST_QUERY_TEXTS);
    }
    }
        addTestDocument(writer, "content", "learning algorithms");
        }
        ).minimumShouldMatch("75%");
        Query query = queryBuilder.toQuery(createShardContext());
     */
    // ========================
            queryBuilder = new CombinedFieldsQueryBuilder(queryText, primaryField, fieldWithBoost);
        Analyzer analyzer = new StandardAnalyzer();
        assertEquals("Operator should be AND", Operator.AND, queryBuilder.operator());
            () -> new CombinedFieldsQueryBuilder(null, "content")
    }
        queryBuilder.minimumShouldMatch("   ");
            + "    \"fields\" : [ \"content\" ],\n"
 * Comprehensive test suite for CombinedFieldsQueryBuilder functionality.
        CombinedFieldsQueryBuilder queryBuilder = new CombinedFieldsQueryBuilder(queryText, TEXT_FIELD_NAME).operator(Operator.OR);
        CombinedFieldsQueryBuilder queryBuilder = new CombinedFieldsQueryBuilder(queryText, TEXT_FIELD_NAME);
                    "type=text"
    public void testOperatorConfiguration() {
            Float weight = expectedFieldToWeight.get(entry.getKey());
     */
        assertEquals("Queries with same minimum_should_match should be equal", query1, query2);
     */
        return true;
    // ========================
        assertEquals("Field count should match", 4, parsed.fieldToWeight().size());
    }
        String queryText = "test wildcard field patterns";
import org.opensearch.index.mapper.MapperService;
    /**
     */
import org.apache.lucene.search.IndexSearcher;
    public void testMinimumShouldMatchJsonSerialization() throws IOException {
     */
    }
        dir.close();
        booleanQuery.clauses().forEach(clause -> {
        );
 */
        // Test serialization round-trip
        assertTrue("Should contain the specified field", queryBuilder.fieldToWeight().containsKey(TEXT_FIELD_NAME));
        assertThat(
        IndexReader reader = DirectoryReader.open(dir);
        "natural language processing techniques",
import org.opensearch.test.AbstractQueryTestCase;
        assertEquals("Boost should match", 1.5f, parsed.boost(), 1e-6);
        String queryText = "test query";
        "distributed systems architecture",
    /**
        CombinedFieldsQueryBuilder queryWithMin2 = new CombinedFieldsQueryBuilder("machine learning algorithms", "content").operator(
    /**
    public void testMinimumShouldMatchFunctionalBehavior() throws IOException {
        assertNotEquals("Queries with different minimum_should_match should not be equal", query1, query3);
            exception.getMessage(),
        addTestDocument(writer, "content", "machine learning");
import org.apache.lucene.document.Document;
    public void testJsonSerializationWithMultipleFields() throws IOException {
        Directory dir = new ByteBuffersDirectory();
    @Override
        assertEquals("Query name should match", "test_combined_fields_query", parsed.queryName());
    // ERROR CONDITION TESTS
        // Test with complex value
    }
        // Test setting numeric value
     * Tests query name configuration.
    // ========================
        CombinedFieldsQueryBuilder queryBuilder = new CombinedFieldsQueryBuilder(queryText, TEXT_FIELD_NAME);
    public void testQueryNameConfiguration() {
            + "}";
     */
        // Test method chaining
package org.opensearch.index.query;
        assertThat("Should have clauses for multi-term query", booleanQuery.clauses().size(), notNullValue());
 * 6. Error Condition Tests
    public void testWhitespaceOnlyQueryText() throws IOException {
        dir.close();
        IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> queryBuilder.toQuery(createShardContext()));
        assertThat("Exception should mention query value", nullValueException.getMessage(), containsString("requires query value"));
    // ========================
        assertEquals("Boost should be 1.8", 1.8f, queryBuilder.boost(), 1e-6);
        for (Map.Entry<String, Float> entry : parsed.fieldToWeight().entrySet()) {
    }
        String queryText = "comprehensive test query with all features";
        assertThat("Generated query should not be null", query, notNullValue());
        assertEquals("Empty string should be preserved", "", queryBuilder.minimumShouldMatch());
            "content^2.0",
        );
            + "}";
        CombinedFieldsQueryBuilder orQuery = new CombinedFieldsQueryBuilder("machine learning", "content").operator(Operator.OR);
        assertEquals("Whitespace-only string should be preserved", "   ", queryBuilder.minimumShouldMatch());
        assertEquals("Numeric minimum should match should be set correctly", numericValue, queryBuilder.minimumShouldMatch());
        IndexReader reader = DirectoryReader.open(dir);
            new CompressedXContent(
            queryBuilder.minimumShouldMatch(randomMinimumShouldMatch());
            NumberFormatException.class,
        "data science methodologies",
     */
     */
            + "    \"fields\" : [ \"title^2.0\", \"content^1.5\", \"tags^0.8\", \"metadata^1.2\" ],\n"
        Query luceneOrQuery = orQuery.toQuery(createShardContext());
public class CombinedFieldsQueryBuilderTests extends AbstractQueryTestCase<CombinedFieldsQueryBuilder> {
    /**
            .boost(2.0f)
        CombinedFieldsQueryBuilder query5 = new CombinedFieldsQueryBuilder(queryText, field).minimumShouldMatch(null);
        IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> queryBuilder.boost(-1.0f));
        mapperService.merge(
    }
        assertEquals("Should parse boost correctly", 1.5f, fields.get("field"), 1e-6);
        String numericValue = "2";
    public void testNonTextFieldRejection() throws IOException {
        // Test with empty string
        CombinedFieldsQueryBuilder queryBuilder = new CombinedFieldsQueryBuilder(queryText, TEXT_FIELD_NAME);
     * Tests handling of wildcard field patterns.
        queryBuilder.minimumShouldMatch(numericValue);
     * Tests phrase query handling (should not support phrases).
            .operator(Operator.AND)
        // Test equals
            containsString("does not support [combined_fields] queries")
    /**
        return queryBuilder;
        queryBuilder.minimumShouldMatch("-25%");
            assertEquals("All clauses should be SHOULD for OR operator", BooleanClause.Occur.SHOULD, clause.occur());
    public void testComprehensiveQueryConstruction() throws IOException {
        IndexWriter writer = new IndexWriter(dir, iwc);
        reader.close();
        Map<String, Float> fields = validQuery.fieldToWeight();
    private static final String[] TEST_QUERY_TEXTS = {
        assertThat("Query should be MatchNoDocsQuery for unmapped fields", query, instanceOf(MatchNoDocsQuery.class));
    public void testWildcardFieldPatterns() throws IOException {
    /**
    // ========================
        assertEquals("Query text should match", queryText, queryBuilder.queryValue());
        queryBuilder.operator(Operator.OR);
     * Tests handling of unmapped fields.
    // ========================
    // ========================
        Query query = queryBuilder.toQuery(createShardContext());
        CombinedFieldsQueryBuilder queryBuilder = new CombinedFieldsQueryBuilder(queryText, TEXT_FIELD_NAME, TEXT_ALIAS_FIELD_NAME + "^1.5")
        CombinedFieldsQueryBuilder validQuery = new CombinedFieldsQueryBuilder(queryText, "field^1.5", "field2^2.0");
     */
        String queryText = "test query";
    @Override
 *
    }
        assertEquals("Query value should match", "distributed systems architecture", parsed.queryValue());
 * compatible open source license.
            + "    \"fields\" : [ \"content\" ],\n"
        for (int i = 0; i < additionalFields; i++) {
    }
    @Override
                    "type=keyword",
    /**
                PutMappingRequest.simpleMapping(
import org.opensearch.action.admin.indices.mapping.put.PutMappingRequest;
        // Test with whitespace-only string
    }
            + "    \"minimum_should_match\" : \"75%\"\n"
        CombinedFieldsQueryBuilder andQuery = new CombinedFieldsQueryBuilder("machine learning", "content").operator(Operator.AND);
import org.apache.lucene.search.TopDocs;
        Query query = queryBuilder.toQuery(createShardContext());
        String jsonWithNumber = "{\n"
    // ========================
        );
        String queryText = "named query test";
     */
        // Test hashCode
        IndexSearcher searcher = new IndexSearcher(reader);
            .queryName("serialization_test");
    // HELPER METHODS
        // Test with minimum_should_match = "75%" (75% of terms, rounded down, so 2 terms)
     * Tests minimum_should_match edge cases and validation.
import static org.hamcrest.Matchers.notNullValue;
        assertEquals("Should have 4 fields", 4, fields.size());
            + "    \"minimum_should_match\" : \"75%\",\n"
        // Valid boost values
        String field = "content";
     * Tests minimum_should_match functional behavior with real queries.
        assertEquals("Minimum should match should be set correctly", minimumShouldMatch, queryBuilder.minimumShouldMatch());
        assertThat(
            "Query should be of expected type",
                instanceOf(CombinedFieldQuery.class)
        Directory dir = new ByteBuffersDirectory();
     */
        assertEquals("Minimum should match should be 75%", "75%", queryBuilder.minimumShouldMatch());
        CombinedFieldsQueryBuilder queryBuilder = new CombinedFieldsQueryBuilder(queryText, primaryField);
                    "boosted_field",
import org.apache.lucene.index.IndexWriter;
        assertEquals("Queries with same minimum_should_match should have same hashCode", query1.hashCode(), query2.hashCode());
     */
    /**
        if (randomBoolean()) {
            assertThat("Query should be generated even with phrase-like text", query, notNullValue());
     * Tests constructor validation with null/invalid inputs.
        CombinedFieldsQueryBuilder queryBuilder = new CombinedFieldsQueryBuilder(
     * Tests OR operator query generation behavior.
        } catch (IllegalArgumentException e) {
                    "type=keyword",
    public void testUnmappedFieldsHandling() throws IOException {
        CombinedFieldsQueryBuilder deserialized = (CombinedFieldsQueryBuilder) parseQuery(serialized);
        TopDocs resultsMin2 = searcher.search(luceneQueryMin2, 10);
        addTestDocument(writer, "content", "machine learning");
            "Exception should mention field type support",
    // EDGE CASE TESTS
        IllegalArgumentException nullValueException = expectThrows(
 */
        assertEquals("Boost should be preserved", original.boost(), deserialized.boost(), 1e-6);
        assertEquals("Operator should match", Operator.AND, parsed.operator());
    public void testMixedFieldTypesRejection() throws IOException {
        assertEquals("Numeric minimum should match should be parsed correctly", "2", parsedWithNumber.minimumShouldMatch());
        Query luceneAndQuery = andQuery.toQuery(createShardContext());
        CombinedFieldsQueryBuilder parsedWithPercentage = (CombinedFieldsQueryBuilder) parseQuery(jsonWithPercentage);
        assertEquals("Query text should match", queryText, queryBuilder.queryValue());
        // Test AND operator - should only match "machine learning"
            + "  }\n"
        // Test with negative percentage
 * 3. Configuration Tests (operators, zero terms, etc.)
    public void testMultipleFieldsWithBoosts() {
        // Should work but phrase aspect may be ignored or handled appropriately
        assertEquals("Queries with null minimum_should_match should be equal", query4, query5);
        CombinedFieldsQueryBuilder queryBuilder = new CombinedFieldsQueryBuilder(queryText, INT_FIELD_NAME);
        assertEquals("Operator should be AND", Operator.AND, queryBuilder.operator());
            String additionalField = randomFrom(TEXT_FIELD_NAME, TEXT_ALIAS_FIELD_NAME, "content", "description", "summary");
     */
        assertThat("Query should be generated for empty text", query, notNullValue());
        CombinedFieldsQueryBuilder queryBuilder = new CombinedFieldsQueryBuilder(queryText, TEXT_FIELD_NAME);
        assertEquals("Fields should be preserved", original.fieldToWeight(), deserialized.fieldToWeight());
        String queryText = "\"phrase query\"";
    }
            .minimumShouldMatch("50%")
     * Tests minimum_should_match JSON serialization and parsing.
        writer.close();
        CombinedFieldsQueryBuilder original = new CombinedFieldsQueryBuilder("test query", "content").minimumShouldMatch("50%")
        assertThat("Exception should mention invalid input", exception.getMessage(), containsString("invalid"));
        assertSame("Method chaining should return same instance", queryBuilder, chained);
    }
        IndexWriterConfig iwc = new IndexWriterConfig(analyzer);
                    "type=text",
        assertTrue("Should match documents with 75% of terms", resultsMin75.totalHits.value() == 3);
        // 75% of 3 terms = 2.25, rounded up to 3 terms required
    public void testMinimumShouldMatchEqualsAndHashCode() {
     */
        queryBuilder.minimumShouldMatch(minimumShouldMatch);
    }
        Map<String, Float> expectedFieldToWeight = Map.of("title", 2.0f, "content", 1.5f, "tags", 0.8f, "metadata", 1.2f);
        queryBuilder.minimumShouldMatch("999999");
    /**
    // MINIMUM_SHOULD_MATCH TESTS
    /**
            + "    \"query\" : \"distributed systems architecture\",\n"
        queryBuilder.minimumShouldMatch(null);
        String queryText = "test query";
import org.apache.lucene.analysis.standard.StandardAnalyzer;
    }
        NumberFormatException exception = expectThrows(
     */
        String queryText = "serialization test query";
        assertEquals("Minimum should match should match", "75%", parsed.minimumShouldMatch());
                    "summary",
        String queryText = "boosted query test";
            .operator(Operator.OR);
        String primaryField = randomFrom(TEXT_FIELD_NAME, TEXT_ALIAS_FIELD_NAME, "content", "description", "summary");
        String jsonWithComplex = "{\n"
/**
    /**
    /**
    // ========================
        // Test with minimum_should_match = "2" (at least 2 terms)
        IndexWriterConfig iwc = new IndexWriterConfig(analyzer);
        CombinedFieldsQueryBuilder parsed = (CombinedFieldsQueryBuilder) parseQuery(json);
     */
    /**
            .boost(1.8f)
    // FUNCTIONAL BEHAVIOR TESTS
    /**
import java.io.IOException;
     */
        assertThat("Exception message should mention negative boost", exception.getMessage(), containsString("negative [boost]"));
            "Exception should mention field type support",
import org.apache.lucene.search.MatchNoDocsQuery;
        assertThat("Query should be a BooleanQuery for OR operator", query, instanceOf(BooleanQuery.class));
        reader.close();
                instanceOf(BooleanQuery.class),
        );
    // ========================
    @Override
    // TEST INFRASTRUCTURE SETUP
        // Test with null minimum_should_match
    protected boolean supportsBoost() {
    public void testFieldBoostValidation() {
        IndexWriter writer = new IndexWriter(dir, iwc);
            .minimumShouldMatch("75%")
     * Tests minimum_should_match in equals and hashCode methods.
            queryText,
        // Should match documents with at least 2 of the 3 terms
        assertEquals("Boost should be set correctly", positiveBoost, queryBuilder.boost(), 1e-6);
            + "    \"minimum_should_match\" : \"2<75%\"\n"
        assertEquals("Queries with null minimum_should_match should have same hashCode", query4.hashCode(), query5.hashCode());
        Query query = queryBuilder.toQuery(createShardContext());
    /**
            original.minimumShouldMatch(),
        assertTrue("Should match documents with at least 2 terms", resultsMin2.totalHits.value() == 3);
            Operator.OR
        return true;
    }
    }
        String queryText = "   ";
        assertEquals("Negative percentage should be preserved", "-25%", queryBuilder.minimumShouldMatch());
        Query query = queryBuilder.toQuery(createShardContext());
        assertEquals("AND operator should match only complete phrase", 1, andResults.totalHits.value());
    // ========================
}
        assertEquals("OR operator should match all documents", 3, orResults.totalHits.value());
        // Add test documents with multiple terms
        String queryText = "test query";
import static org.hamcrest.CoreMatchers.anyOf;
     * Tests rejection of mixed field types.
        // Test with very large number
            + "    \"_name\" : \"test_combined_fields_query\"\n"
        assertEquals("Chained minimum should match should be set", "50%", queryBuilder.minimumShouldMatch());
     */
        queryBuilder.operator(Operator.AND);
        float positiveBoost = 2.5f;
            ),
        assertEquals("Field count should be 2", 2, queryBuilder.fieldToWeight().size());
        String queryName = "test_named_query";
        CombinedFieldsQueryBuilder queryWithMin75 = new CombinedFieldsQueryBuilder("machine learning algorithms", "content").operator(
        "cloud computing infrastructure",
     * Tests handling of whitespace-only query text.
    protected void doAssertLuceneQuery(CombinedFieldsQueryBuilder queryBuilder, Query query, QueryShardContext context) {
        );
    // TEST DATA CONSTANTS
import org.apache.lucene.document.TextField;
     */
import org.apache.lucene.index.DirectoryReader;
            IllegalArgumentException.class,
            () -> new CombinedFieldsQueryBuilder("test", (String[]) null)
    public void testOperatorBehaviorFunctional() throws IOException {
    // ========================
        addTestDocument(writer, "content", "machine");
     * Tests JSON serialization with comprehensive field configuration.
            assertEquals("Field weight should match for " + entry.getKey(), weight, entry.getValue(), 1e-6);
            + "  \"combined_fields\" : {\n"
        String queryText = "distributed systems architecture";
            exception.getMessage(),
        // Should handle whitespace-only query gracefully
            "tags^1.5"
    // ========================
        // This should match fewer documents than the "2" minimum_should_match
            + "    \"boost\" : 1.5,\n"
        String serialized = original.toString();
        String queryText = "test query";
    public void testEmptyQueryTextHandling() throws IOException {
        assertEquals("Query value should be preserved", original.queryValue(), deserialized.queryValue());
        CombinedFieldsQueryBuilder queryBuilder = new CombinedFieldsQueryBuilder(queryText, TEXT_FIELD_NAME, INT_FIELD_NAME);
        CombinedFieldsQueryBuilder queryBuilder = new CombinedFieldsQueryBuilder(queryText, TEXT_FIELD_NAME);
        assertEquals("Operator should be preserved", original.operator(), deserialized.operator());
     * Tests query construction with multiple fields and boosts.
                    "tags",
        assertNotEquals("Queries with different minimum_should_match should have different hashCode", query1.hashCode(), query3.hashCode());
        // Test setting null value
        }
            )
import org.apache.lucene.analysis.Analyzer;
                instanceOf(TermQuery.class),
            .queryName("comprehensive_test");
        String json = original.toString();
import org.apache.lucene.search.CombinedFieldQuery;
            + "  \"combined_fields\" : {\n"
            IllegalArgumentException.class,
    private void addTestDocument(IndexWriter writer, String field, String value) throws IOException {
        assertEquals(
        BooleanQuery booleanQuery = (BooleanQuery) query;
        return true;
import java.util.Map;
import static org.hamcrest.Matchers.containsString;
        addTestDocument(writer, "content", "machine");
        CombinedFieldsQueryBuilder queryBuilder = new CombinedFieldsQueryBuilder(queryText, TEXT_FIELD_NAME);
 * 4. Serialization Tests
     * Tests boost configuration and validation.
        IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> queryBuilder.toQuery(createShardContext()));
        // Test with numeric value
     * Tests functional operator behavior with real Lucene index.
        if (randomBoolean()) {
        IndexSearcher searcher = new IndexSearcher(reader);
        assertEquals("Complex minimum should match should be parsed correctly", "2<75%", parsedWithComplex.minimumShouldMatch());
     */
        CombinedFieldsQueryBuilder query1 = new CombinedFieldsQueryBuilder(queryText, field).minimumShouldMatch("75%");
            query,
import org.apache.lucene.search.Query;
        Analyzer analyzer = new StandardAnalyzer();
        CombinedFieldsQueryBuilder original = new CombinedFieldsQueryBuilder(queryText, TEXT_FIELD_NAME, TEXT_ALIAS_FIELD_NAME + "^1.5")
    public void testBasicQueryConstruction() {
        // Test with percentage value
    }
        CombinedFieldsQueryBuilder queryBuilder = new CombinedFieldsQueryBuilder(queryText, "wildcard_field_*");
            assertThat("Exception should mention phrase support", e.getMessage(), containsString("phrases"));
        CombinedFieldsQueryBuilder queryBuilder = new CombinedFieldsQueryBuilder(queryText, TEXT_FIELD_NAME);
    // QUERY CONSTRUCTION TESTS
            + "    \"minimum_should_match\" : \"2\"\n"
        }
/*
        String queryText = "test query with unmapped fields";
        writer.addDocument(doc);
     * Tests rejection of non-text field types.
    /**
            .operator(Operator.OR)
        });
    }
            "Minimum should match should be preserved in serialization",
        doc.add(new TextField(field, value, Field.Store.NO));
    protected boolean supportsQueryName() {
        TopDocs orResults = searcher.search(luceneOrQuery, 10);
        String queryText = "";
     */
            + "    \"fields\" : [ \"content\" ],\n"
     * Tests operator configuration and behavior.
        CombinedFieldsQueryBuilder query3 = new CombinedFieldsQueryBuilder(queryText, field).minimumShouldMatch("50%");
    // ========================
import static org.hamcrest.CoreMatchers.instanceOf;
            Query query = queryBuilder.toQuery(createShardContext());
            "summary^0.5",
        }
 * Test Structure:
        assertEquals("Minimum should match should be preserved", original.minimumShouldMatch(), deserialized.minimumShouldMatch());
        String json = "{\n"
        assertEquals("Operator should be OR", Operator.OR, queryBuilder.operator());
    /**
        TopDocs resultsMin75 = searcher.search(luceneQueryMin75, 10);
        String minimumShouldMatch = "75%";
    }
            anyOf(
     */
            Operator.OR
            + "  }\n"
            + "    \"query\" : \"test query\",\n"
import org.apache.lucene.store.ByteBuffersDirectory;
        assertThat("Exception should mention field list", nullFieldsException.getMessage(), containsString("requires field list"));
    /**
        // Random configuration
        assertEquals("Tags should have boost 1.5", 1.5f, fields.get("tags"), 1e-6);
        CombinedFieldsQueryBuilder parsedWithNumber = (CombinedFieldsQueryBuilder) parseQuery(jsonWithNumber);
        assertEquals("Should parse boost correctly", 2.0f, fields.get("field2"), 1e-6);
        );
    public void testSerializationConsistency() throws IOException {
 * 2. Query Construction Tests
    // ========================
    }
            String fieldWithBoost = additionalField + "^" + boost;
    // ========================
        IllegalArgumentException nullFieldsException = expectThrows(
    /**
        assertThat("Query should not be null", query, notNullValue());
    }
    }
        CombinedFieldsQueryBuilder queryBuilder = new CombinedFieldsQueryBuilder(queryText, TEXT_FIELD_NAME);
    // ========================
    }
                ).toString()
        // Verify no exceptions are thrown
            deserialized.minimumShouldMatch()
import org.opensearch.common.compress.CompressedXContent;
import org.apache.lucene.index.IndexReader;
        }
        assertEquals("Title should have default boost", 1.0f, fields.get("title"), 1e-6);
        // Verify no exceptions are thrown
        ).minimumShouldMatch("2");
    }
    /**
        addTestDocument(writer, "content", "algorithms");
