package org.opensearch.transport.grpc.proto.request.search.query;
}  
        QueryContainer queryContainer = QueryContainer.newBuilder().setMatchNone(matchNoneQuery).build();
        // Test that constructor throws IllegalArgumentException when registry is null  
import org.opensearch.protobufs.TermQuery;  
    public void testParseInnerQueryBuilderProtoWithUnsupportedQuery() {  
        // Verify the result
    }
        QueryBuilder queryBuilder = queryUtils.parseInnerQueryBuilderProto(queryContainer);
 */  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.index.query.TermQueryBuilder;
        // Create a QueryContainer with MatchAllQuery
import org.opensearch.protobufs.FieldValue;
        // Call parseInnerQueryBuilderProto using instance method, should throw IllegalArgumentException
        QueryBuilder queryBuilder = queryUtils.parseInnerQueryBuilderProto(queryContainer);
        assertTrue("QueryBuilder should be a TermQueryBuilder", queryBuilder instanceof TermQueryBuilder);  
        // Create an empty QueryContainer (no query type specified)
        assertEquals("Registry cannot be null", exception.getMessage());  
    }
        assertEquals("Field name should match", "test-field", termQueryBuilder.fieldName());
    public void testParseInnerQueryBuilderProtoWithMatchNone() {
 * compatible open source license.
            () -> queryUtils.parseInnerQueryBuilderProto(null)
    @Override
            IllegalArgumentException.class,  
        queryUtils = QueryBuilderProtoTestUtils.createQueryUtils();
        // Verify the result  
        );
        super.setUp();  
    private AbstractQueryBuilderProtoUtils queryUtils;
        MatchAllQuery matchAllQuery = MatchAllQuery.newBuilder().build();  
import org.opensearch.protobufs.QueryContainer;
        QueryContainer queryContainer = QueryContainer.newBuilder().setTerm(termQuery).build();
            () -> queryUtils.parseInnerQueryBuilderProto(queryContainer)
import org.opensearch.test.OpenSearchTestCase;
    }  
        QueryContainer queryContainer = QueryContainer.newBuilder().build();
        assertNotNull("QueryBuilder should not be null", queryBuilder);
    public void testParseInnerQueryBuilderProtoWithMatchAll() {
import org.opensearch.protobufs.MatchNoneQuery;
    }  
        QueryBuilder queryBuilder = queryUtils.parseInnerQueryBuilderProto(queryContainer);
        TermQuery termQuery = TermQuery.newBuilder().setField("test-field").setValue(fieldValue).build();  
/*  
    public void testConstructorWithNullRegistry() {
        TermQueryBuilder termQueryBuilder = (TermQueryBuilder) queryBuilder;
    }
    }  
        assertNotNull("QueryBuilder should not be null", queryBuilder);
    public void testGetRegistry() {
        );
        assertEquals("Registry should be the same instance", queryUtils.getRegistry(), queryUtils.getRegistry());
    public void setUp() throws Exception {
        assertNotNull("Registry should not be null", queryUtils.getRegistry());  
        assertEquals("Value should match", "test-value", termQueryBuilder.value());  
        // Verify the exception message
    }
        // Create a QueryContainer with Term query
            IllegalArgumentException.class,  
        // Call parseInnerQueryBuilderProto using instance method
        MatchNoneQuery matchNoneQuery = MatchNoneQuery.newBuilder().build();
        // Verify the result
        // Call parseInnerQueryBuilderProto using instance method  
    }
        assertEquals("Query container cannot be null", exception.getMessage());
        assertTrue("QueryBuilder should be a MatchAllQueryBuilder", queryBuilder instanceof MatchAllQueryBuilder);
        IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> new AbstractQueryBuilderProtoUtils(null));
        QueryContainer queryContainer = QueryContainer.newBuilder().setMatchAll(matchAllQuery).build();
 *
        // Test that method throws IllegalArgumentException when queryContainer is null
        // Call parseInnerQueryBuilderProto using instance method
public class AbstractQueryBuilderProtoUtilsTests extends OpenSearchTestCase {  
        IllegalArgumentException exception = expectThrows(
        assertTrue("QueryBuilder should be a MatchNoneQueryBuilder", queryBuilder instanceof MatchNoneQueryBuilder);  
import org.opensearch.index.query.MatchAllQueryBuilder;
        // Create a QueryContainer with MatchNoneQuery  
 * The OpenSearch Contributors require contributions made to  
    public void testParseInnerQueryBuilderProtoWithTerm() {  
        FieldValue fieldValue = FieldValue.newBuilder().setString("test-value").build();
        IllegalArgumentException exception = expectThrows(
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.index.query.QueryBuilder;  
import org.opensearch.index.query.MatchNoneQueryBuilder;
    public void testGetRegistryReturnsSameInstance() {  
import org.opensearch.protobufs.MatchAllQuery;  
        assertNotNull("QueryBuilder should not be null", queryBuilder);
        assertTrue("Exception message should mention 'Unsupported query type'", exception.getMessage().contains("Unsupported query type"));
        // Create an instance with all built-in converters
    public void testParseInnerQueryBuilderProtoWithNullContainer() {  
    }
