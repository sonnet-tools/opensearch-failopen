    }  
        assertTrue(
 */  
        // Create a QueryContainer with a different query type
        QueryContainer emptyContainer = QueryContainer.newBuilder().build();
    public void setUp() throws Exception {  
public class TermQueryBuilderProtoConverterTests extends OpenSearchTestCase {
        assertEquals("Boost should match", 2.0f, termQueryBuilder.boost(), 0.0f);
        // Test that the converter returns the correct QueryContainerCase  
        QueryContainer queryContainer = QueryContainer.newBuilder().setTerm(termQuery).build();
        TermQuery termQuery = TermQuery.newBuilder()
        assertEquals("Converter should handle TERM case", QueryContainer.QueryContainerCase.TERM, converter.getHandledQueryCase());
        );
    }
        assertTrue("Case insensitive should be true", termQueryBuilder.caseInsensitive());  
        FieldValue fieldValue = FieldValue.newBuilder().setString("test-value").build();  
/*  
        assertEquals("Query name should match", "test_query", termQueryBuilder.queryName());
    public void testFromProtoWithInvalidContainer() {  
}
    }  
 * The OpenSearch Contributors require contributions made to  
    }
        // Verify the exception message
package org.opensearch.transport.grpc.proto.request.search.query;
 * SPDX-License-Identifier: Apache-2.0
    public void testFromProto() {
        QueryBuilder queryBuilder = converter.fromProto(queryContainer);
        assertNotNull("QueryBuilder should not be null", queryBuilder);
import org.opensearch.index.query.TermQueryBuilder;
import org.opensearch.test.OpenSearchTestCase;
        converter = new TermQueryBuilderProtoConverter();
            "Exception message should mention 'does not contain a Term query'",  
        // Convert the query
        // Verify the result
        super.setUp();
    private TermQueryBuilderProtoConverter converter;  
        // Test that the converter throws an exception
        // Create a QueryContainer with TermQuery
import org.opensearch.protobufs.QueryContainer;  
            .build();
        assertTrue("QueryBuilder should be a TermQueryBuilder", queryBuilder instanceof TermQueryBuilder);  
        TermQueryBuilder termQueryBuilder = (TermQueryBuilder) queryBuilder;
        assertEquals("Field name should match", "test-field", termQueryBuilder.fieldName());
 * this file be licensed under the Apache-2.0 license or a
    @Override
            .setField("test-field")
            .setXName("test_query")
            .setValue(fieldValue)  
        IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> converter.fromProto(emptyContainer));
        assertEquals("Value should match", "test-value", termQueryBuilder.value());  
import org.opensearch.protobufs.FieldValue;
    public void testGetHandledQueryCase() {
import org.opensearch.protobufs.TermQuery;
            .setBoost(2.0f)
 *
            .setCaseInsensitive(true)  
            exception.getMessage().contains("does not contain a Term query")
 * compatible open source license.
import org.opensearch.index.query.QueryBuilder;  
