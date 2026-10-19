        // Verify the exception message  
            .setBoost(2.0f)
        QueryContainer emptyContainer = QueryContainer.newBuilder().build();
        // Test that the converter throws an exception with null input
import org.opensearch.protobufs.QueryContainer;
        // Convert the query
    public void testFromProtoWithNullContainer() {
    }
        assertTrue(
}
    public void testFromProtoWithMinimalFields() {
import org.opensearch.protobufs.WildcardQuery;  
    }  
        // Create a QueryContainer with minimal WildcardQuery  
    public void testFromProto() {  
        assertNotNull("QueryBuilder should not be null", queryBuilder);
        assertTrue(  
import org.opensearch.index.query.QueryBuilder;  
        assertEquals("Field name should match", "field_name", wildcardQueryBuilder.fieldName());
        );  
public class WildcardQueryBuilderProtoConverterTests extends OpenSearchTestCase {  
        QueryContainer queryContainer = QueryContainer.newBuilder().setWildcard(wildcardQuery).build();
        assertEquals("Query name should match", "test_wildcard_query", wildcardQueryBuilder.queryName());
        QueryContainer queryContainer = QueryContainer.newBuilder().setWildcard(wildcardQuery).build();
        assertEquals("Field name should match", "test_field", wildcardQueryBuilder.fieldName());
            .setXName("test_wildcard_query")  
        // Verify the result
    }
    public void testFromProtoWithInvalidContainer() {
        // Verify the exception message
        // Verify the result
        WildcardQuery wildcardQuery = WildcardQuery.newBuilder()
        // Test that the converter throws an exception  
            .setField("test_field")  
import org.opensearch.test.OpenSearchTestCase;
            "Exception message should mention 'does not contain a Wildcard query'",
    }
        assertEquals("Converter should handle WILDCARD case", QueryContainer.QueryContainerCase.WILDCARD, converter.getHandledQueryCase());  
import org.opensearch.index.query.WildcardQueryBuilder;
        // Create a QueryContainer with WildcardQuery
            exception.getMessage().contains("does not contain a Wildcard query")  
 * SPDX-License-Identifier: Apache-2.0
 * compatible open source license.
        assertNotNull("QueryBuilder should not be null", queryBuilder);
        assertEquals("Value should match", "test*pattern", wildcardQueryBuilder.value());  
            "Exception message should mention null",
    public void testGetHandledQueryCase() {
        WildcardQuery wildcardQuery = WildcardQuery.newBuilder().setField("field_name").setValue("pattern*").build();
        assertTrue("QueryBuilder should be a WildcardQueryBuilder", queryBuilder instanceof WildcardQueryBuilder);  
        WildcardQueryBuilder wildcardQueryBuilder = (WildcardQueryBuilder) queryBuilder;
 */  
            .build();
            exception.getMessage().contains("null") || exception.getMessage().contains("does not contain a Wildcard query")
        );
        assertEquals("Default boost should be 1.0", 1.0f, wildcardQueryBuilder.boost(), 0.0f);
 * this file be licensed under the Apache-2.0 license or a
        // Create a QueryContainer with a different query type  
        QueryBuilder queryBuilder = converter.fromProto(queryContainer);
        assertNull("Query name should be null", wildcardQueryBuilder.queryName());
    }  
        super.setUp();  
        IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> converter.fromProto(emptyContainer));
 * The OpenSearch Contributors require contributions made to  
    public void setUp() throws Exception {
        WildcardQueryBuilder wildcardQueryBuilder = (WildcardQueryBuilder) queryBuilder;
        // Convert the query
    private WildcardQueryBuilderProtoConverter converter;
        // Test that the converter returns the correct QueryContainerCase
        assertEquals("Value should match", "pattern*", wildcardQueryBuilder.value());  
        IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> converter.fromProto(null));  
/*  
    @Override
package org.opensearch.transport.grpc.proto.request.search.query;
 *
    }
            .setValue("test*pattern")
        assertEquals("Boost should match", 2.0f, wildcardQueryBuilder.boost(), 0.0f);
        assertTrue("QueryBuilder should be a WildcardQueryBuilder", queryBuilder instanceof WildcardQueryBuilder);  
        QueryBuilder queryBuilder = converter.fromProto(queryContainer);
        converter = new WildcardQueryBuilderProtoConverter();
