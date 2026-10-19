        );  
 * SPDX-License-Identifier: Apache-2.0
}
        // Verify the result
/*  
        // Convert the query
    public void testFromProtoWithNullContainer() {  
        // Create a QueryContainer with ExistsQuery
        assertNull("Query name should be null", existsQueryBuilder.queryName());
            "Exception message should mention 'does not contain an Exists query'",
 */  
import org.opensearch.test.OpenSearchTestCase;
    }  
        QueryBuilder queryBuilder = converter.fromProto(queryContainer);
        IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> converter.fromProto(null));
        assertNotNull("QueryBuilder should not be null", queryBuilder);  
 * compatible open source license.
        assertEquals("Field name should match", "field_name", existsQueryBuilder.fieldName());
        assertTrue("QueryBuilder should be an ExistsQueryBuilder", queryBuilder instanceof ExistsQueryBuilder);  
        ExistsQuery existsQuery = ExistsQuery.newBuilder().setField("field_name").build();
        assertEquals("Default boost should be 1.0", 1.0f, existsQueryBuilder.boost(), 0.0f);  
        ExistsQueryBuilder existsQueryBuilder = (ExistsQueryBuilder) queryBuilder;
package org.opensearch.transport.grpc.proto.request.search.query;
import org.opensearch.protobufs.ExistsQuery;
        // Test that the converter throws an exception with null input
        assertEquals("Boost should match", 2.0f, existsQueryBuilder.boost(), 0.0f);
    @Override
    public void testFromProto() {  
 * The OpenSearch Contributors require contributions made to  
        ExistsQueryBuilder existsQueryBuilder = (ExistsQueryBuilder) queryBuilder;
        );
        // Test that the converter returns the correct QueryContainerCase
    }  
    }
        assertTrue(  
        converter = new ExistsQueryBuilderProtoConverter();
        QueryContainer queryContainer = QueryContainer.newBuilder().setExists(existsQuery).build();
        assertEquals("Converter should handle EXISTS case", QueryContainer.QueryContainerCase.EXISTS, converter.getHandledQueryCase());  
        // Verify the result
        assertTrue(
    }
        assertNotNull("QueryBuilder should not be null", queryBuilder);
        QueryBuilder queryBuilder = converter.fromProto(queryContainer);  
    }
        // Verify the exception message
            exception.getMessage().contains("null") || exception.getMessage().contains("does not contain an Exists query")
        QueryContainer queryContainer = QueryContainer.newBuilder().setExists(existsQuery).build();  
import org.opensearch.protobufs.QueryContainer;  
 *
        // Create a QueryContainer with minimal ExistsQuery  
        IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> converter.fromProto(emptyContainer));  
    private ExistsQueryBuilderProtoConverter converter;
            "Exception message should mention null",  
        // Verify the exception message
 * this file be licensed under the Apache-2.0 license or a
        assertEquals("Query name should match", "test_exists_query", existsQueryBuilder.queryName());
        ExistsQuery existsQuery = ExistsQuery.newBuilder().setField("test_field").setBoost(2.0f).setXName("test_exists_query").build();
public class ExistsQueryBuilderProtoConverterTests extends OpenSearchTestCase {  
import org.opensearch.index.query.ExistsQueryBuilder;  
    public void testFromProtoWithMinimalFields() {
    public void setUp() throws Exception {
        // Convert the query
        assertTrue("QueryBuilder should be an ExistsQueryBuilder", queryBuilder instanceof ExistsQueryBuilder);
    public void testFromProtoWithInvalidContainer() {
        assertEquals("Field name should match", "test_field", existsQueryBuilder.fieldName());  
        super.setUp();  
            exception.getMessage().contains("does not contain an Exists query")
    public void testGetHandledQueryCase() {
        // Test that the converter throws an exception
    }
        // Create a QueryContainer with a different query type
        QueryContainer emptyContainer = QueryContainer.newBuilder().build();  
import org.opensearch.index.query.QueryBuilder;
