public class FunctionScoreQueryBuilderProtoConverterTests extends OpenSearchTestCase {
    public void testFromProto_DifferentQueryType() {
/*  
        assertEquals("QueryContainer does not contain a FunctionScore query", exception.getMessage());
        IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> { converter.fromProto(queryContainer); });
        QueryContainer queryContainer = QueryContainer.newBuilder()  
    }
    }
/**
        FunctionScoreQuery functionScoreQuery = FunctionScoreQuery.newBuilder().build();
import org.opensearch.transport.grpc.proto.request.search.query.QueryBuilderProtoConverterRegistryImpl;
    }  
    }
 *
 * SPDX-License-Identifier: Apache-2.0
    public void setUp() throws Exception {  
 * Tests for {@link FunctionScoreQueryBuilderProtoConverter}.
}
 */  
        assertEquals(QueryContainer.QueryContainerCase.FUNCTION_SCORE, converter.getHandledQueryCase());  
        // Create a query container without function score  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.protobufs.FunctionScoreQuery;
        converter.setRegistry(registry);
    public void testFromProto_NullQueryContainer() {  
            .build();
        QueryContainer queryContainer = QueryContainer.newBuilder().setFunctionScore(functionScoreQuery).build();
        // Set up the registry with all built-in converters  
 * The OpenSearch Contributors require contributions made to  
        // Create a query container with a different query type
        QueryContainer queryContainer = QueryContainer.newBuilder().build();
import org.opensearch.test.OpenSearchTestCase;
        super.setUp();
        assertEquals("QueryContainer does not contain a FunctionScore query", exception.getMessage());
        QueryBuilder result = converter.fromProto(queryContainer);  
        assertTrue("Should be FunctionScoreQueryBuilder", result instanceof FunctionScoreQueryBuilder);  
    public void testGetHandledQueryCase() {
        // Create a simple function score query
        converter = new FunctionScoreQueryBuilderProtoConverter();
        IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> { converter.fromProto(null); });
    private FunctionScoreQueryBuilderProtoConverter converter;  
        IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> { converter.fromProto(queryContainer); });  
    public void testFromProto_ValidFunctionScoreQuery() {  
        assertNotNull(result);
            .setMatchAll(org.opensearch.protobufs.MatchAllQuery.newBuilder().build())
import org.opensearch.index.query.QueryBuilder;  
    @Override
package org.opensearch.transport.grpc.proto.request.search.query.functionscore;
 */  
    public void testFromProto_MissingFunctionScore() {
        assertEquals("QueryContainer does not contain a FunctionScore query", exception.getMessage());
        QueryBuilderProtoConverterRegistryImpl registry = new QueryBuilderProtoConverterRegistryImpl();
 * compatible open source license.
    }  
    }  
import org.opensearch.protobufs.QueryContainer;  
import org.opensearch.index.query.functionscore.FunctionScoreQueryBuilder;
