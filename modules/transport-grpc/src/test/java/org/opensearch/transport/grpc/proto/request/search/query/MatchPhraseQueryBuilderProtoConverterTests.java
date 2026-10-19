        assertNotNull("QueryBuilder should not be null", queryBuilder);
            "Exception message should mention 'does not contain a MatchPhrase query'",
        // Convert the query
        assertEquals(  
            .setQuery("example text")
    public void setUp() throws Exception {
            .setZeroTermsQuery(ZeroTermsQuery.ZERO_TERMS_QUERY_ALL)
    public void testGetHandledQueryCase() {  
        // Test that the converter throws an exception
        assertEquals("Field name should match", "message", matchPhraseQueryBuilder.fieldName());
        // Create a QueryContainer with an invalid MatchPhraseQuery (empty field)  
            exception.getMessage().contains("Query value cannot be null or empty")
        assertEquals("Zero terms query should be NONE", MatchQuery.ZeroTermsQuery.NONE, matchPhraseQueryBuilder.zeroTermsQuery());
        // Test that the converter throws an exception
        MatchPhraseQuery matchPhraseQuery = MatchPhraseQuery.newBuilder().setField("").setQuery("test").build();
    public void testFromProtoWithInvalidMatchPhraseQuery() {
        assertTrue(  
    public void testFromProto() {  
        assertEquals("Default boost should be 1.0", 1.0f, matchPhraseQueryBuilder.boost(), 0.0f);
        // Test that the converter throws an exception with null input
        );  
        assertTrue("QueryBuilder should be a MatchPhraseQueryBuilder", queryBuilder instanceof MatchPhraseQueryBuilder);  
        );  
 * The OpenSearch Contributors require contributions made to  
        // Convert the query
 *
        QueryContainer queryContainer = QueryContainer.newBuilder().setMatchPhrase(matchPhraseQuery).build();
        // Create a QueryContainer with minimal MatchPhraseQuery  
        assertEquals("Analyzer should match", "standard", matchPhraseQueryBuilder.analyzer());
import org.opensearch.protobufs.MatchPhraseQuery;  
            matchPhraseQueryBuilder.zeroTermsQuery()  
        );
        assertEquals("Slop should match", 2, matchPhraseQueryBuilder.slop());
        IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> converter.fromProto(queryContainer));
            "Exception message should mention empty query value",  
            .setBoost(2.0f)
            .setXName("test_match_phrase_query")  
        assertEquals("Query value should match", "test phrase", matchPhraseQueryBuilder.value());  
        // Create a QueryContainer with a different query type
import org.opensearch.index.search.MatchQuery;
            QueryContainer.QueryContainerCase.MATCH_PHRASE,
        QueryContainer queryContainer = QueryContainer.newBuilder().setMatchPhrase(matchPhraseQuery).build();
 * compatible open source license.
            converter.getHandledQueryCase()
        MatchPhraseQuery matchPhraseQuery = MatchPhraseQuery.newBuilder().setField("message").setQuery("test phrase").setSlop(-1).build();
        converter = new MatchPhraseQueryBuilderProtoConverter();  
            "Default zero terms query should match",
    public void testFromProtoWithZeroTermsQueryNone() {  
            MatchQuery.DEFAULT_ZERO_TERMS_QUERY,
        // Test that the converter returns the correct QueryContainerCase
import org.opensearch.index.query.QueryBuilder;
        // Verify the exception message
/*  
        assertEquals("Query name should match", "test_match_phrase_query", matchPhraseQueryBuilder.queryName());
        // Verify the result
        assertTrue(
        MatchPhraseQuery matchPhraseQuery = MatchPhraseQuery.newBuilder()
        assertEquals("Boost should match", 2.0f, matchPhraseQueryBuilder.boost(), 0.0f);
        // Verify the exception message
package org.opensearch.transport.grpc.proto.request.search.query;
    }
            .setAnalyzer("standard")
        );
        assertTrue(
 */  
        // Create a QueryContainer with ZeroTermsQuery set to NONE
        );
    public void testFromProtoWithInvalidQuery() {
        QueryContainer queryContainer = QueryContainer.newBuilder().setMatchPhrase(matchPhraseQuery).build();
        assertNotNull("QueryBuilder should not be null", queryBuilder);
        assertTrue("QueryBuilder should be a MatchPhraseQueryBuilder", queryBuilder instanceof MatchPhraseQueryBuilder);  
 * SPDX-License-Identifier: Apache-2.0
        // Create a QueryContainer with an invalid MatchPhraseQuery (empty query)  
        assertNull("Query name should be null", matchPhraseQueryBuilder.queryName());
        // Convert the query  
        MatchPhraseQuery matchPhraseQuery = MatchPhraseQuery.newBuilder().setField("title").setQuery("test phrase").build();
        // Create a QueryContainer with an invalid MatchPhraseQuery (negative slop)  
        // Verify the result
        IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> converter.fromProto(queryContainer));
        assertEquals("Default slop should match", MatchQuery.DEFAULT_PHRASE_SLOP, matchPhraseQueryBuilder.slop());
        // Verify the result  
        // Verify the exception message
        IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> converter.fromProto(queryContainer));
        // Create a QueryContainer with MatchPhraseQuery
    }
 * this file be licensed under the Apache-2.0 license or a
    }  
        assertTrue("Exception message should mention negative slop", exception.getMessage().contains("No negative slop allowed"));
            "Converter should handle MATCH_PHRASE case",  
        MatchPhraseQuery matchPhraseQuery = MatchPhraseQuery.newBuilder()
        assertTrue("QueryBuilder should be a MatchPhraseQueryBuilder", queryBuilder instanceof MatchPhraseQueryBuilder);
    public void testFromProtoWithNullContainer() {  
            exception.getMessage().contains("null") || exception.getMessage().contains("does not contain a MatchPhrase query")
        // Verify the exception message
            "Exception message should mention null or MatchPhrase query",  
import org.opensearch.protobufs.ZeroTermsQuery;
import org.opensearch.index.query.MatchPhraseQueryBuilder;  
import org.opensearch.test.OpenSearchTestCase;  
public class MatchPhraseQueryBuilderProtoConverterTests extends OpenSearchTestCase {
    @Override  
    }  
        assertTrue(
        );
        // Test that the converter throws an exception
            .setSlop(2)  
        assertEquals(
            .setQuery("hello world")
        MatchPhraseQueryBuilder matchPhraseQueryBuilder = (MatchPhraseQueryBuilder) queryBuilder;  
        MatchPhraseQueryBuilder matchPhraseQueryBuilder = (MatchPhraseQueryBuilder) queryBuilder;
            .build();
        IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> converter.fromProto(emptyContainer));  
        QueryBuilder queryBuilder = converter.fromProto(queryContainer);
        assertEquals("Field name should match", "title", matchPhraseQueryBuilder.fieldName());
    }
    }  
            exception.getMessage().contains("Field name cannot be null or empty")
}
            .setField("content")  
    }  
    }
        IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> converter.fromProto(null));
    private MatchPhraseQueryBuilderProtoConverter converter;
        QueryContainer queryContainer = QueryContainer.newBuilder().setMatchPhrase(matchPhraseQuery).build();
        QueryContainer emptyContainer = QueryContainer.newBuilder().build();  
    public void testFromProtoWithMinimalFields() {
            exception.getMessage().contains("does not contain a MatchPhrase query")
import org.opensearch.protobufs.QueryContainer;
        // Verify the exception message
        assertEquals("Zero terms query should match", MatchQuery.ZeroTermsQuery.ALL, matchPhraseQueryBuilder.zeroTermsQuery());  
        // Test that the converter throws an exception
    public void testFromProtoWithInvalidContainer() {
        QueryContainer queryContainer = QueryContainer.newBuilder().setMatchPhrase(matchPhraseQuery).build();
    public void testFromProtoWithNegativeSlop() {
            .setField("message")  
        MatchPhraseQuery matchPhraseQuery = MatchPhraseQuery.newBuilder().setField("message").setQuery("").build();
        assertNull("Analyzer should be null", matchPhraseQueryBuilder.analyzer());  
    }
        QueryContainer queryContainer = QueryContainer.newBuilder().setMatchPhrase(matchPhraseQuery).build();
            "Exception message should mention empty field name",  
            .setZeroTermsQuery(ZeroTermsQuery.ZERO_TERMS_QUERY_NONE)
        QueryBuilder queryBuilder = converter.fromProto(queryContainer);
        assertNotNull("QueryBuilder should not be null", queryBuilder);
        super.setUp();
        QueryBuilder queryBuilder = converter.fromProto(queryContainer);
        MatchPhraseQueryBuilder matchPhraseQueryBuilder = (MatchPhraseQueryBuilder) queryBuilder;
            .build();  
        assertEquals("Query value should match", "hello world", matchPhraseQueryBuilder.value());  
    }  
