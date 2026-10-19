        assertEquals(
import org.opensearch.index.query.QueryBuilder;
            "Converter should handle MATCH_PHRASE_PREFIX case",  
import org.opensearch.protobufs.MatchPhrasePrefixQuery;
    }  
    }
        MatchPhrasePrefixQueryBuilder matchPhrasePrefixQueryBuilder = (MatchPhrasePrefixQueryBuilder) queryBuilder;
    public void testFromProtoWithInvalidContainer() {  
    public void setUp() throws Exception {
 */  
        QueryContainer emptyContainer = QueryContainer.newBuilder().build();
        assertEquals("Slop should match", 2, matchPhrasePrefixQueryBuilder.slop());
        MatchPhrasePrefixQuery matchPhrasePrefixQuery = MatchPhrasePrefixQuery.newBuilder()
        assertNotNull("QueryBuilder should not be null", queryBuilder);
        IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> converter.fromProto(null));  
        converter = new MatchPhrasePrefixQueryBuilderProtoConverter();
    public void testFromProtoWithMinimalFields() {
        assertEquals("Value should match", "quick bro", matchPhrasePrefixQueryBuilder.value());
        assertTrue("QueryBuilder should be a MatchPhrasePrefixQueryBuilder", queryBuilder instanceof MatchPhrasePrefixQueryBuilder);  
    }  
        assertEquals("Max expansions should match", 10, matchPhrasePrefixQueryBuilder.maxExpansions());  
        assertTrue("QueryBuilder should be a MatchPhrasePrefixQueryBuilder", queryBuilder instanceof MatchPhrasePrefixQueryBuilder);
            exception.getMessage().contains("does not contain a MatchPhrasePrefix query")
}
            "Exception message should mention 'does not contain a MatchPhrasePrefix query'",  
/*  
        assertTrue(
import org.opensearch.test.OpenSearchTestCase;
            "Exception message should mention 'does not contain a MatchPhrasePrefix query'",  
            .setQuery("quick bro")  
        );  
    @Override
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
import org.opensearch.protobufs.QueryContainer;  
            .setBoost(2.0f)  
 * The OpenSearch Contributors require contributions made to  
 *
            .setMaxExpansions(10)
    }
        assertEquals("Query name should match", "test_query", matchPhrasePrefixQueryBuilder.queryName());
        QueryBuilder queryBuilder = converter.fromProto(queryContainer);
        super.setUp();  
            converter.getHandledQueryCase()
        assertEquals("Field name should match", "message", matchPhrasePrefixQueryBuilder.fieldName());  
    public void testGetHandledQueryCase() {
            .setField("message")
        QueryContainer queryContainer = QueryContainer.newBuilder().setMatchPhrasePrefix(matchPhrasePrefixQuery).build();
    public void testFromProto() {  
    public void testFromProtoWithNullContainer() {
public class MatchPhrasePrefixQueryBuilderProtoConverterTests extends OpenSearchTestCase {  
        IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> converter.fromProto(emptyContainer));  
package org.opensearch.transport.grpc.proto.request.search.query;
        MatchPhrasePrefixQueryBuilder matchPhrasePrefixQueryBuilder = (MatchPhrasePrefixQueryBuilder) queryBuilder;  
            QueryContainer.QueryContainerCase.MATCH_PHRASE_PREFIX,
        assertTrue(
import org.opensearch.index.query.MatchPhrasePrefixQueryBuilder;  
        assertNotNull("QueryBuilder should not be null", queryBuilder);  
        QueryBuilder queryBuilder = converter.fromProto(queryContainer);  
        assertEquals("Boost should match", 2.0f, matchPhrasePrefixQueryBuilder.boost(), 0.0f);
        MatchPhrasePrefixQuery matchPhrasePrefixQuery = MatchPhrasePrefixQuery.newBuilder().setField("title").setQuery("test").build();  
        );
        assertEquals("Value should match", "test", matchPhrasePrefixQueryBuilder.value());
        QueryContainer queryContainer = QueryContainer.newBuilder().setMatchPhrasePrefix(matchPhrasePrefixQuery).build();
            .setXName("test_query")
        assertEquals("Field name should match", "title", matchPhrasePrefixQueryBuilder.fieldName());
    }  
        assertEquals("Default boost should be 1.0", 1.0f, matchPhrasePrefixQueryBuilder.boost(), 0.0f);  
    private MatchPhrasePrefixQueryBuilderProtoConverter converter;
 * SPDX-License-Identifier: Apache-2.0
    }
            exception.getMessage().contains("does not contain a MatchPhrasePrefix query")
            .setSlop(2)
            .build();
        );
