        assertTrue("QueryBuilder should be a MultiMatchQueryBuilder", queryBuilder instanceof MultiMatchQueryBuilder);
        converter = new MultiMatchQueryBuilderProtoConverter();
package org.opensearch.transport.grpc.proto.request.search.query;
        MultiMatchQuery multiMatchQuery = MultiMatchQuery.newBuilder().setQuery("test").addFields("field").build();
            .addFields("field1")
        // Test that the converter returns the correct QueryContainerCase
import org.opensearch.test.OpenSearchTestCase;
 * compatible open source license.
    }  
        IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> converter.fromProto(emptyContainer));
        IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> converter.fromProto(null));  
 * this file be licensed under the Apache-2.0 license or a
        assertTrue("Should contain field2", multiMatchQueryBuilder.fields().containsKey("field2"));
        // Test that the converter throws an exception  
    }
import org.opensearch.protobufs.QueryContainer;  
    public void testGetHandledQueryCase() {
        assertNotNull("QueryBuilder should not be null", queryBuilder);
    }
        QueryBuilder queryBuilder = converter.fromProto(queryContainer);
            "Converter should handle MULTI_MATCH case",
            exception.getMessage().contains("does not contain a MultiMatch query")  
        assertEquals("Query text should match", "test", multiMatchQueryBuilder.value());
            .setXName("test_multi_match_query")
        QueryContainer queryContainer = QueryContainer.newBuilder().setMultiMatch(multiMatchQuery).build();
        // Verify the result  
        assertTrue("Should contain field", multiMatchQueryBuilder.fields().containsKey("field"));
        assertEquals("Query text should match", "search text", multiMatchQueryBuilder.value());
        );
    }
        // Verify the exception message
}
 * The OpenSearch Contributors require contributions made to  
    public void testFromProtoWithNullContainer() {
    public void testFromProtoWithInvalidContainer() {
        assertEquals("Boost should match", 2.0f, multiMatchQueryBuilder.boost(), 0.0f);
        assertEquals(  
        QueryBuilder queryBuilder = converter.fromProto(queryContainer);
    }  
            QueryContainer.QueryContainerCase.MULTI_MATCH,
import org.opensearch.protobufs.MultiMatchQuery;
        MultiMatchQueryBuilder multiMatchQueryBuilder = (MultiMatchQueryBuilder) queryBuilder;  
        assertNotNull("QueryBuilder should not be null", queryBuilder);
        // Verify the result
            exception.getMessage().contains("null") || exception.getMessage().contains("does not contain a MultiMatch query")
    public void testFromProto() {
        // Convert the query  
        // Create a QueryContainer with minimal MultiMatchQuery  
        assertEquals("Query name should match", "test_multi_match_query", multiMatchQueryBuilder.queryName());  
        // Test that the converter throws an exception with null input
            "Exception message should mention 'does not contain a MultiMatch query'",
        // Create a QueryContainer with MultiMatchQuery
    public void testFromProtoWithMinimalFields() {
        super.setUp();  
/*  
import org.opensearch.index.query.QueryBuilder;
            .setQuery("search text")
            "Exception message should mention null",
        );  
        // Verify the exception message  
            converter.getHandledQueryCase()  
        assertTrue("QueryBuilder should be a MultiMatchQueryBuilder", queryBuilder instanceof MultiMatchQueryBuilder);  
        MultiMatchQueryBuilder multiMatchQueryBuilder = (MultiMatchQueryBuilder) queryBuilder;
        MultiMatchQuery multiMatchQuery = MultiMatchQuery.newBuilder()  
    }
            .setBoost(2.0f)
        assertTrue(
        QueryContainer queryContainer = QueryContainer.newBuilder().setMultiMatch(multiMatchQuery).build();
    private MultiMatchQueryBuilderProtoConverter converter;
public class MultiMatchQueryBuilderProtoConverterTests extends OpenSearchTestCase {  
            .addFields("field2")  
    public void setUp() throws Exception {
    @Override
        assertEquals("Default boost should be 1.0", 1.0f, multiMatchQueryBuilder.boost(), 0.0f);  
        // Create a QueryContainer with a different query type  
            .build();  
        );
 *
 */  
import org.opensearch.index.query.MultiMatchQueryBuilder;  
 * SPDX-License-Identifier: Apache-2.0
        assertTrue("Should contain field1", multiMatchQueryBuilder.fields().containsKey("field1"));
        QueryContainer emptyContainer = QueryContainer.newBuilder().build();
        assertTrue(  
        // Convert the query
        assertNull("Query name should be null", multiMatchQueryBuilder.queryName());
