        assertTrue("QueryBuilder should be a RegexpQueryBuilder", queryBuilder instanceof RegexpQueryBuilder);  
        // Convert the query
            .setField("test_field")  
import org.opensearch.index.query.RegexpQueryBuilder;
    public void testGetHandledQueryCase() {
        // Test that the converter returns the correct QueryContainerCase
        super.setUp();  
    public void setUp() throws Exception {
        // Create a QueryContainer with a different query type  
    @Override
 * this file be licensed under the Apache-2.0 license or a
        // Verify the exception message  
        // Create a QueryContainer with minimal RegexpQuery  
        IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> converter.fromProto(emptyContainer));
import org.opensearch.index.query.QueryBuilder;  
import org.opensearch.protobufs.RegexpQuery;  
 *
 * SPDX-License-Identifier: Apache-2.0
    }  
    public void testFromProtoWithMinimalFields() {
        converter = new RegexpQueryBuilderProtoConverter();
    }  
        assertEquals("Boost should match", 2.0f, regexpQueryBuilder.boost(), 0.0f);
    }
        QueryBuilder queryBuilder = converter.fromProto(queryContainer);
            .build();
        // Convert the query
        RegexpQuery regexpQuery = RegexpQuery.newBuilder()
        assertEquals("Value should match", "test.*pattern", regexpQueryBuilder.value());  
        assertEquals("Query name should match", "test_regexp_query", regexpQueryBuilder.queryName());
    public void testFromProtoWithInvalidContainer() {
    public void testFromProto() {  
    }
        assertEquals("Converter should handle REGEXP case", QueryContainer.QueryContainerCase.REGEXP, converter.getHandledQueryCase());  
        assertTrue(
 */  
        assertEquals("Field name should match", "field_name", regexpQueryBuilder.fieldName());
        IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> converter.fromProto(null));  
public class RegexpQueryBuilderProtoConverterTests extends OpenSearchTestCase {  
        assertTrue("QueryBuilder should be a RegexpQueryBuilder", queryBuilder instanceof RegexpQueryBuilder);  
            exception.getMessage().contains("does not contain a Regexp query")  
        // Create a QueryContainer with RegexpQuery
    }
        // Test that the converter throws an exception with null input
            "Exception message should mention 'does not contain a Regexp query'",
        assertNull("Query name should be null", regexpQueryBuilder.queryName());
        assertEquals("Default boost should be 1.0", 1.0f, regexpQueryBuilder.boost(), 0.0f);
        assertEquals("Value should match", "pattern.*", regexpQueryBuilder.value());  
            .setBoost(2.0f)
        QueryContainer queryContainer = QueryContainer.newBuilder().setRegexp(regexpQuery).build();
        RegexpQueryBuilder regexpQueryBuilder = (RegexpQueryBuilder) queryBuilder;
        QueryContainer queryContainer = QueryContainer.newBuilder().setRegexp(regexpQuery).build();
/*  
        );  
        // Verify the result
 * compatible open source license.
    }
        );
        // Verify the exception message
            .setXName("test_regexp_query")  
        assertEquals("Field name should match", "test_field", regexpQueryBuilder.fieldName());
import org.opensearch.protobufs.QueryContainer;
 * The OpenSearch Contributors require contributions made to  
            exception.getMessage().contains("null") || exception.getMessage().contains("does not contain a Regexp query")
        QueryBuilder queryBuilder = converter.fromProto(queryContainer);
            "Exception message should mention null",
    public void testFromProtoWithNullContainer() {
        // Test that the converter throws an exception  
        assertNotNull("QueryBuilder should not be null", queryBuilder);
        RegexpQueryBuilder regexpQueryBuilder = (RegexpQueryBuilder) queryBuilder;
        QueryContainer emptyContainer = QueryContainer.newBuilder().build();
        RegexpQuery regexpQuery = RegexpQuery.newBuilder().setField("field_name").setValue("pattern.*").build();
        // Verify the result
    private RegexpQueryBuilderProtoConverter converter;
            .setValue("test.*pattern")
package org.opensearch.transport.grpc.proto.request.search.query;
        assertNotNull("QueryBuilder should not be null", queryBuilder);
        assertTrue(  
}
import org.opensearch.test.OpenSearchTestCase;
