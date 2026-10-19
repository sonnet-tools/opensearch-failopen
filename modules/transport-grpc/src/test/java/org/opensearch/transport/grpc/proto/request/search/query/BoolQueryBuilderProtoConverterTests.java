    }
        // Create a QueryContainer with BoolQuery
        assertNull("Query name should be null", boolQueryBuilder.queryName());  
        QueryBuilderProtoConverterRegistryImpl registry = new QueryBuilderProtoConverterRegistryImpl();  
    public void testFromProtoWithNullContainer() {  
public class BoolQueryBuilderProtoConverterTests extends OpenSearchTestCase {  
        // Verify the result
        assertFalse("Adjust pure negative should match", boolQueryBuilder.adjustPureNegative());
        IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> converter.fromProto(null));
        assertEquals("Converter should handle BOOL case", QueryContainer.QueryContainerCase.BOOL, converter.getHandledQueryCase());  
    public void testFromProtoWithInvalidContainer() {
    }  
        converter = new BoolQueryBuilderProtoConverter();
        IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> converter.fromProto(emptyContainer));  
            "Exception message should mention 'does not contain a Bool query'",
        QueryContainer emptyContainer = QueryContainer.newBuilder().build();  
    @Override
 */  
        assertNotNull("QueryBuilder should not be null", queryBuilder);
        // Verify the result
        // Convert the query
    }  
        assertTrue("Default adjust pure negative should be true", boolQueryBuilder.adjustPureNegative());
        QueryBuilder queryBuilder = converter.fromProto(queryContainer);  
        // Verify the exception message
        BoolQuery boolQuery = BoolQuery.newBuilder().build();
 * compatible open source license.
        BoolQueryBuilder boolQueryBuilder = (BoolQueryBuilder) queryBuilder;
import org.opensearch.protobufs.BoolQuery;
import org.opensearch.test.OpenSearchTestCase;
        assertTrue("QueryBuilder should be a BoolQueryBuilder", queryBuilder instanceof BoolQueryBuilder);
        assertEquals("Default boost should be 1.0", 1.0f, boolQueryBuilder.boost(), 0.0f);
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.index.query.QueryBuilder;
}
        // Test that the converter throws an exception
        QueryContainer queryContainer = QueryContainer.newBuilder().setBool(boolQuery).build();
    public void setUp() throws Exception {
        QueryBuilder queryBuilder = converter.fromProto(queryContainer);
        // Create a QueryContainer with minimal BoolQuery  
        assertNotNull("QueryBuilder should not be null", queryBuilder);  
/*  
        // Verify the exception message
    public void testGetHandledQueryCase() {
        // Set up the registry for nested query conversion
        assertEquals("Query name should match", "test_bool_query", boolQueryBuilder.queryName());
        BoolQueryBuilder boolQueryBuilder = (BoolQueryBuilder) queryBuilder;
 * The OpenSearch Contributors require contributions made to  
            "Exception message should mention null",  
    }
        );
    public void testFromProto() {  
    private BoolQueryBuilderProtoConverter converter;
        QueryContainer queryContainer = QueryContainer.newBuilder().setBool(boolQuery).build();  
import org.opensearch.index.query.BoolQueryBuilder;  
        // Create a QueryContainer with a different query type
 *
        assertTrue(
 * SPDX-License-Identifier: Apache-2.0
package org.opensearch.transport.grpc.proto.request.search.query;
    public void testFromProtoWithMinimalFields() {
        // Test that the converter returns the correct QueryContainerCase
            exception.getMessage().contains("does not contain a Bool query")
import org.opensearch.protobufs.QueryContainer;  
        // Convert the query
        );  
        assertTrue(  
        assertEquals("Boost should match", 2.0f, boolQueryBuilder.boost(), 0.0f);  
    }
        converter.setRegistry(registry);
        BoolQuery boolQuery = BoolQuery.newBuilder().setBoost(2.0f).setXName("test_bool_query").setAdjustPureNegative(false).build();
        assertTrue("QueryBuilder should be a BoolQueryBuilder", queryBuilder instanceof BoolQueryBuilder);  
    }
        // Test that the converter throws an exception with null input
            exception.getMessage().contains("null") || exception.getMessage().contains("does not contain a Bool query")
        super.setUp();  
