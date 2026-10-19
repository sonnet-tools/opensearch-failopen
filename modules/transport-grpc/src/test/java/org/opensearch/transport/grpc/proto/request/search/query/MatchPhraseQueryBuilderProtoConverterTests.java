        // Convert the query
        // Test that the converter throws an exception
        // Verify the exception message
    }
            .build();
        assertEquals("Zero terms query should match", MatchQuery.ZeroTermsQuery.ALL, matchPhraseQueryBuilder.zeroTermsQuery());
        // Test that the converter returns the correct QueryContainerCase
        assertEquals("Field name should match", "message", matchPhraseQueryBuilder.fieldName());
        // Verify the result
    public void testFromProtoWithMinimalFields() {
        assertTrue(
            QueryContainer.QueryContainerCase.MATCH_PHRASE,
        MatchPhraseQueryBuilder matchPhraseQueryBuilder = (MatchPhraseQueryBuilder) queryBuilder;
public class MatchPhraseQueryBuilderProtoConverterTests extends OpenSearchTestCase {
        assertEquals(
        assertEquals("Query name should match", "test_match_phrase_query", matchPhraseQueryBuilder.queryName());
    }
            .setAnalyzer("standard")
            MatchQuery.DEFAULT_ZERO_TERMS_QUERY,
    public void setUp() throws Exception {
        // Create a QueryContainer with an invalid MatchPhraseQuery (empty field)
        assertTrue(
        assertNotNull("QueryBuilder should not be null", queryBuilder);
    public void testFromProtoWithInvalidQuery() {
        assertEquals("Field name should match", "title", matchPhraseQueryBuilder.fieldName());
        // Test that the converter throws an exception
        // Verify the exception message
        QueryBuilder queryBuilder = converter.fromProto(queryContainer);
        assertTrue(
        MatchPhraseQuery matchPhraseQuery = MatchPhraseQuery.newBuilder().setField("").setQuery("test").build();
        assertNotNull("QueryBuilder should not be null", queryBuilder);
            "Exception message should mention empty query value",
        // Convert the query
            exception.getMessage().contains("Field name cannot be null or empty")
            .build();
        IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> converter.fromProto(queryContainer));
            "Exception message should mention empty field name",
}
package org.opensearch.transport.grpc.proto.request.search.query;
        assertEquals("Query value should match", "hello world", matchPhraseQueryBuilder.value());
        QueryContainer emptyContainer = QueryContainer.newBuilder().build();
    }
        assertEquals("Boost should match", 2.0f, matchPhraseQueryBuilder.boost(), 0.0f);
        // Create a QueryContainer with MatchPhraseQuery
        assertTrue("QueryBuilder should be a MatchPhraseQueryBuilder", queryBuilder instanceof MatchPhraseQueryBuilder);
        assertNull("Query name should be null", matchPhraseQueryBuilder.queryName());
        IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> converter.fromProto(queryContainer));
/*
            .setBoost(2.0f)
        IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> converter.fromProto(queryContainer));
        // Create a QueryContainer with an invalid MatchPhraseQuery (empty query)
            .setQuery("hello world")
        // Verify the result
    public void testFromProtoWithInvalidMatchPhraseQuery() {
        // Create a QueryContainer with minimal MatchPhraseQuery
        QueryContainer queryContainer = QueryContainer.newBuilder().setMatchPhrase(matchPhraseQuery).build();
    public void testFromProto() {
        );
            "Exception message should mention 'does not contain a MatchPhrase query'",
        QueryContainer queryContainer = QueryContainer.newBuilder().setMatchPhrase(matchPhraseQuery).build();
        assertTrue("QueryBuilder should be a MatchPhraseQueryBuilder", queryBuilder instanceof MatchPhraseQueryBuilder);
        MatchPhraseQueryBuilder matchPhraseQueryBuilder = (MatchPhraseQueryBuilder) queryBuilder;
        QueryContainer queryContainer = QueryContainer.newBuilder().setMatchPhrase(matchPhraseQuery).build();
        assertTrue("QueryBuilder should be a MatchPhraseQueryBuilder", queryBuilder instanceof MatchPhraseQueryBuilder);
import org.opensearch.index.query.QueryBuilder;
            "Converter should handle MATCH_PHRASE case",
        QueryContainer queryContainer = QueryContainer.newBuilder().setMatchPhrase(matchPhraseQuery).build();
        QueryContainer queryContainer = QueryContainer.newBuilder().setMatchPhrase(matchPhraseQuery).build();
 * The OpenSearch Contributors require contributions made to
    public void testFromProtoWithNullContainer() {
        assertEquals("Default boost should be 1.0", 1.0f, matchPhraseQueryBuilder.boost(), 0.0f);
            exception.getMessage().contains("does not contain a MatchPhrase query")
import org.opensearch.protobufs.MatchPhraseQuery;
        // Create a QueryContainer with ZeroTermsQuery set to NONE
        );
        // Verify the result
import org.opensearch.protobufs.QueryContainer;
            .setXName("test_match_phrase_query")
 * compatible open source license.
import org.opensearch.index.search.MatchQuery;
        );
        MatchPhraseQuery matchPhraseQuery = MatchPhraseQuery.newBuilder().setField("title").setQuery("test phrase").build();
        assertEquals("Slop should match", 2, matchPhraseQueryBuilder.slop());
 * SPDX-License-Identifier: Apache-2.0
        IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> converter.fromProto(emptyContainer));
 * this file be licensed under the Apache-2.0 license or a
    }
    }
        // Create a QueryContainer with an invalid MatchPhraseQuery (negative slop)
            .setSlop(2)
        QueryContainer queryContainer = QueryContainer.newBuilder().setMatchPhrase(matchPhraseQuery).build();
        MatchPhraseQueryBuilder matchPhraseQueryBuilder = (MatchPhraseQueryBuilder) queryBuilder;
    }
        assertEquals("Query value should match", "test phrase", matchPhraseQueryBuilder.value());
        QueryBuilder queryBuilder = converter.fromProto(queryContainer);
 */
    public void testFromProtoWithNegativeSlop() {
        assertEquals("Zero terms query should be NONE", MatchQuery.ZeroTermsQuery.NONE, matchPhraseQueryBuilder.zeroTermsQuery());
        MatchPhraseQuery matchPhraseQuery = MatchPhraseQuery.newBuilder()
    }
    private MatchPhraseQueryBuilderProtoConverter converter;
        assertNotNull("QueryBuilder should not be null", queryBuilder);
        );
import org.opensearch.protobufs.ZeroTermsQuery;
        assertTrue(
            .setQuery("example text")
        // Test that the converter throws an exception with null input
 *
            "Exception message should mention null or MatchPhrase query",
            .setZeroTermsQuery(ZeroTermsQuery.ZERO_TERMS_QUERY_NONE)
    public void testFromProtoWithInvalidContainer() {
    @Override
            converter.getHandledQueryCase()
            .setField("message")
import org.opensearch.test.OpenSearchTestCase;
        // Verify the exception message
        assertTrue("Exception message should mention negative slop", exception.getMessage().contains("No negative slop allowed"));
    public void testFromProtoWithZeroTermsQueryNone() {
import org.opensearch.index.query.MatchPhraseQueryBuilder;
        // Create a QueryContainer with a different query type
        // Verify the exception message
        QueryBuilder queryBuilder = converter.fromProto(queryContainer);
        // Test that the converter throws an exception
        MatchPhraseQuery matchPhraseQuery = MatchPhraseQuery.newBuilder().setField("message").setQuery("").build();
            exception.getMessage().contains("Query value cannot be null or empty")
            matchPhraseQueryBuilder.zeroTermsQuery()
            .setZeroTermsQuery(ZeroTermsQuery.ZERO_TERMS_QUERY_ALL)
    }
            "Default zero terms query should match",
        assertEquals("Analyzer should match", "standard", matchPhraseQueryBuilder.analyzer());
        super.setUp();
    public void testGetHandledQueryCase() {
        assertEquals("Default slop should match", MatchQuery.DEFAULT_PHRASE_SLOP, matchPhraseQueryBuilder.slop());
        assertEquals(
        IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> converter.fromProto(null));
        MatchPhraseQuery matchPhraseQuery = MatchPhraseQuery.newBuilder()
        );
        MatchPhraseQuery matchPhraseQuery = MatchPhraseQuery.newBuilder().setField("message").setQuery("test phrase").setSlop(-1).build();
        );
            .setField("content")
            exception.getMessage().contains("null") || exception.getMessage().contains("does not contain a MatchPhrase query")
        converter = new MatchPhraseQueryBuilderProtoConverter();
    }
        assertNull("Analyzer should be null", matchPhraseQueryBuilder.analyzer());
        // Test that the converter throws an exception
        // Verify the exception message
    }
        // Convert the query
