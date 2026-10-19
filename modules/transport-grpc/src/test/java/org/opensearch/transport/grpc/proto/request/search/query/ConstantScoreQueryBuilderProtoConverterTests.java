    }
        TermQueryBuilder termQueryBuilder = (TermQueryBuilder) innerQuery;
        assertEquals("Field name should match", "test-field", termQueryBuilder.fieldName());
    public void testFromProtoWithInvalidContainer() {  
    }
 * compatible open source license.
        );
    }
        assertTrue(
        // Verify the inner filter query  
package org.opensearch.transport.grpc.proto.request.search.query;
            exception.getMessage().contains("does not contain a ConstantScore query")
        IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> converter.fromProto(emptyContainer));  
import org.opensearch.protobufs.QueryContainer;
            .setBoost(2.0f)  
    }
        QueryContainer queryContainer = QueryContainer.newBuilder().setConstantScore(constantScoreQuery).build();
        QueryBuilderProtoConverterRegistryImpl registry = new QueryBuilderProtoConverterRegistryImpl();
 */  
        QueryContainer queryContainer = QueryContainer.newBuilder().setConstantScore(constantScoreQuery).build();
            QueryContainer.QueryContainerCase.CONSTANT_SCORE,  
public class ConstantScoreQueryBuilderProtoConverterTests extends OpenSearchTestCase {  
    private ConstantScoreQueryBuilderProtoConverter converter;
}
        QueryContainer filterContainer = QueryContainer.newBuilder().setTerm(termQuery).build();
            converter.getHandledQueryCase()
        assertEquals("Boost should match", 2.0f, constantScoreQueryBuilder.boost(), 0.0f);  
        assertTrue(
 *
import org.opensearch.index.query.QueryBuilder;
        QueryBuilder queryBuilder = converter.fromProto(queryContainer);  
        TermQuery termQuery = TermQuery.newBuilder().setField("test-field").setValue(fieldValue).build();
        ConstantScoreQueryBuilder constantScoreQueryBuilder = (ConstantScoreQueryBuilder) queryBuilder;
 * The OpenSearch Contributors require contributions made to  
        FieldValue fieldValue = FieldValue.newBuilder().setString("test-value").build();  
    @Override
        QueryContainer emptyContainer = QueryContainer.newBuilder().build();
    public void testFromProtoWithOnlyFilter() {  
        QueryBuilder innerQuery = constantScoreQueryBuilder.innerQuery();
            "Converter should handle CONSTANT_SCORE case",
    }  
        assertEquals("Value should match", "test-value", termQueryBuilder.value());  
        assertEquals("Query name should match", "test_query", constantScoreQueryBuilder.queryName());
        assertTrue("Inner query should be a TermQueryBuilder", innerQuery instanceof TermQueryBuilder);  
        ConstantScoreQueryBuilder constantScoreQueryBuilder = (ConstantScoreQueryBuilder) queryBuilder;
        ConstantScoreQuery constantScoreQuery = ConstantScoreQuery.newBuilder()
    public void testFromProto() {
        TermQuery termQuery = TermQuery.newBuilder().setField("field").setValue(fieldValue).build();
        assertNotNull("QueryBuilder should not be null", queryBuilder);
    public void testFromProtoWithMissingFilter() {
        QueryBuilder innerQuery = constantScoreQueryBuilder.innerQuery();  
        FieldValue fieldValue = FieldValue.newBuilder().setString("test").build();
import org.opensearch.protobufs.TermQuery;  
        IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> converter.fromProto(queryContainer));
    public void testGetHandledQueryCase() {  
import org.opensearch.index.query.TermQueryBuilder;
        ConstantScoreQuery constantScoreQuery = ConstantScoreQuery.newBuilder().setFilter(filterContainer).build();
        assertNotNull("Inner query should not be null", innerQuery);
        assertNotNull("Inner query should not be null", innerQuery);
            .setXName("test_query")
        assertTrue("Inner query should be a TermQueryBuilder", innerQuery instanceof TermQueryBuilder);
        QueryContainer queryContainer = QueryContainer.newBuilder().setConstantScore(constantScoreQuery).build();
            .setFilter(filterContainer)
        converter = new ConstantScoreQueryBuilderProtoConverter();
            "Exception message should indicate missing ConstantScore query",  
        IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> converter.fromProto(null));  
            "Exception message should indicate missing ConstantScore query",  
        converter.setRegistry(registry);  
import org.opensearch.protobufs.FieldValue;
    }  
        );
 * SPDX-License-Identifier: Apache-2.0
        QueryBuilder queryBuilder = converter.fromProto(queryContainer);  
        );
        assertTrue("QueryBuilder should be a ConstantScoreQueryBuilder", queryBuilder instanceof ConstantScoreQueryBuilder);  
        assertNull("Query name should be null", constantScoreQueryBuilder.queryName());
/*  
        assertNotNull("QueryBuilder should not be null", queryBuilder);
import org.opensearch.index.query.ConstantScoreQueryBuilder;  
            .build();
import org.opensearch.test.OpenSearchTestCase;
        ConstantScoreQuery constantScoreQuery = ConstantScoreQuery.newBuilder().setBoost(2.0f).build();  
            exception.getMessage().contains("does not contain a ConstantScore query")
    }  
import org.opensearch.protobufs.ConstantScoreQuery;  
        assertTrue("Exception message should indicate missing filter", exception.getMessage().contains("must have a filter query"));  
    public void testFromProtoWithNullContainer() {
    public void setUp() throws Exception {
        assertEquals("Default boost should be 1.0", 1.0f, constantScoreQueryBuilder.boost(), 0.0f);  
 * this file be licensed under the Apache-2.0 license or a
        super.setUp();  
        assertTrue("QueryBuilder should be a ConstantScoreQueryBuilder", queryBuilder instanceof ConstantScoreQueryBuilder);  
        assertEquals(
        QueryContainer filterContainer = QueryContainer.newBuilder().setTerm(termQuery).build();  
