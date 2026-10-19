import org.opensearch.protobufs.MatchBoolPrefixQuery;
        );
        assertTrue("QueryBuilder should be a MatchBoolPrefixQueryBuilder", queryBuilder instanceof MatchBoolPrefixQueryBuilder);
        assertEquals("Field name should match", "message", matchBoolPrefixQueryBuilder.fieldName());
package org.opensearch.transport.grpc.proto.request.search.query;
    }
            exception.getMessage().contains("does not contain a MatchBoolPrefix query")  
    private MatchBoolPrefixQueryBuilderProtoConverter converter;
        MatchBoolPrefixQueryBuilder matchBoolPrefixQueryBuilder = (MatchBoolPrefixQueryBuilder) queryBuilder;  
        MatchBoolPrefixQuery matchBoolPrefixQuery = MatchBoolPrefixQuery.newBuilder().setField("title").setQuery("test").build();
        assertEquals(
    }
            QueryContainer.QueryContainerCase.MATCH_BOOL_PREFIX,
        assertEquals("Field name should match", "title", matchBoolPrefixQueryBuilder.fieldName());  
        MatchBoolPrefixQueryBuilder matchBoolPrefixQueryBuilder = (MatchBoolPrefixQueryBuilder) queryBuilder;
        MatchBoolPrefixQuery matchBoolPrefixQuery = MatchBoolPrefixQuery.newBuilder()
        assertEquals("Value should match", "quick brown f", matchBoolPrefixQueryBuilder.value());
            exception.getMessage().contains("does not contain a MatchBoolPrefix query")  
        assertEquals("Default boost should be 1.0", 1.0f, matchBoolPrefixQueryBuilder.boost(), 0.0f);
 * The OpenSearch Contributors require contributions made to  
    public void testFromProtoWithNullContainer() {
        super.setUp();  
            "Exception message should mention 'does not contain a MatchBoolPrefix query'",
            .setField("message")
        QueryContainer queryContainer = QueryContainer.newBuilder().setMatchBoolPrefix(matchBoolPrefixQuery).build();
/*  
            .build();  
 * SPDX-License-Identifier: Apache-2.0
 */  
        assertNotNull("QueryBuilder should not be null", queryBuilder);  
        assertTrue("QueryBuilder should be a MatchBoolPrefixQueryBuilder", queryBuilder instanceof MatchBoolPrefixQueryBuilder);  
    }
import org.opensearch.protobufs.QueryContainer;  
    public void testGetHandledQueryCase() {
    public void testFromProtoWithInvalidContainer() {
    public void setUp() throws Exception {
 *
        assertEquals("Query name should match", "test_query", matchBoolPrefixQueryBuilder.queryName());
    public void testFromProtoWithMinimalFields() {
            .setXName("test_query")
        assertTrue(
    }
        QueryContainer emptyContainer = QueryContainer.newBuilder().build();  
public class MatchBoolPrefixQueryBuilderProtoConverterTests extends OpenSearchTestCase {  
    }  
 * compatible open source license.
        assertEquals("Value should match", "test", matchBoolPrefixQueryBuilder.value());
    @Override
        QueryContainer queryContainer = QueryContainer.newBuilder().setMatchBoolPrefix(matchBoolPrefixQuery).build();
        );
        QueryBuilder queryBuilder = converter.fromProto(queryContainer);  
            "Converter should handle MATCH_BOOL_PREFIX case",  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.test.OpenSearchTestCase;
            "Exception message should mention 'does not contain a MatchBoolPrefix query'",
            .setBoost(2.0f)
    public void testFromProto() {  
        converter = new MatchBoolPrefixQueryBuilderProtoConverter();
import org.opensearch.index.query.QueryBuilder;
        assertNotNull("QueryBuilder should not be null", queryBuilder);
        assertTrue(
            .setQuery("quick brown f")  
        IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> converter.fromProto(emptyContainer));
            converter.getHandledQueryCase()
import org.opensearch.index.query.MatchBoolPrefixQueryBuilder;  
        );  
}  
        IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> converter.fromProto(null));
        QueryBuilder queryBuilder = converter.fromProto(queryContainer);
        assertEquals("Boost should match", 2.0f, matchBoolPrefixQueryBuilder.boost(), 0.0f);  
    }
