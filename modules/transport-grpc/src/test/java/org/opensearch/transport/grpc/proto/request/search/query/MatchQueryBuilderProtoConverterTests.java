        );  
import org.opensearch.index.query.MatchQueryBuilder;  
        MatchQueryBuilder matchQueryBuilder = (MatchQueryBuilder) queryBuilder;
    }  
        super.setUp();
    }  
        assertEquals("Converter should handle MATCH case", QueryContainer.QueryContainerCase.MATCH, converter.getHandledQueryCase());  
    }
 *
package org.opensearch.transport.grpc.proto.request.search.query;
        assertNotNull("QueryBuilder should not be null", queryBuilder);
 * The OpenSearch Contributors require contributions made to  
    }
            exception.getMessage().contains("does not contain a Match query")
    }
        MatchQueryBuilder matchQueryBuilder = (MatchQueryBuilder) queryBuilder;
        QueryBuilder queryBuilder = converter.fromProto(queryContainer);
 * SPDX-License-Identifier: Apache-2.0
        );  
    public void testFromProto() {  
    }
    @Override
            .setXName("test_query")  
            "Exception message should mention 'does not contain a Match query'",
            exception.getMessage().contains("does not contain a Match query")
import org.opensearch.test.OpenSearchTestCase;
    private MatchQueryBuilderProtoConverter converter;  
import org.opensearch.protobufs.MatchQuery;  
import org.opensearch.index.query.QueryBuilder;
        FieldValue queryValue = FieldValue.newBuilder().setString("test").build();  
        assertTrue(  
            .setBoost(2.0f)
        QueryContainer queryContainer = QueryContainer.newBuilder().setMatch(matchQuery).build();  
    public void testGetHandledQueryCase() {
        assertEquals("Field name should match", "message", matchQueryBuilder.fieldName());
    public void setUp() throws Exception {  
        assertEquals("Boost should match", 2.0f, matchQueryBuilder.boost(), 0.0f);
    public void testFromProtoWithMinimalFields() {
        IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> converter.fromProto(null));
        QueryContainer emptyContainer = QueryContainer.newBuilder().build();
        QueryBuilder queryBuilder = converter.fromProto(queryContainer);
        assertEquals("Query name should match", "test_query", matchQueryBuilder.queryName());
        QueryContainer queryContainer = QueryContainer.newBuilder().setMatch(matchQuery).build();  
        MatchQuery matchQuery = MatchQuery.newBuilder().setField("title").setQuery(queryValue).build();
    public void testFromProtoWithNullContainer() {  
import org.opensearch.protobufs.QueryContainer;
        IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> converter.fromProto(emptyContainer));
            "Exception message should mention 'does not contain a Match query'",
import org.opensearch.protobufs.FieldValue;
        assertTrue("QueryBuilder should be a MatchQueryBuilder", queryBuilder instanceof MatchQueryBuilder);
    public void testFromProtoWithInvalidContainer() {
            .build();
        assertTrue("QueryBuilder should be a MatchQueryBuilder", queryBuilder instanceof MatchQueryBuilder);
        assertEquals("Field name should match", "title", matchQueryBuilder.fieldName());
/*  
 * compatible open source license.
        assertNotNull("QueryBuilder should not be null", queryBuilder);
        assertEquals("Value should match", "search text", matchQueryBuilder.value());  
        MatchQuery matchQuery = MatchQuery.newBuilder()
        assertEquals("Default boost should be 1.0", 1.0f, matchQueryBuilder.boost(), 0.0f);
public class MatchQueryBuilderProtoConverterTests extends OpenSearchTestCase {
}
            .setQuery(queryValue)
 * this file be licensed under the Apache-2.0 license or a
        assertEquals("Value should match", "test", matchQueryBuilder.value());  
        converter = new MatchQueryBuilderProtoConverter();
            .setField("message")  
        assertTrue(  
 */  
        FieldValue queryValue = FieldValue.newBuilder().setString("search text").build();
