        assertNotNull("QueryBuilder should not be null", queryBuilder);
import org.opensearch.index.query.MatchNoneQueryBuilder;  
    }
 * compatible open source license.
        QueryBuilder queryBuilder = converter.fromProto(queryContainer);
        // Create a QueryContainer with a different query type  
package org.opensearch.transport.grpc.proto.request.search.query;
        // Create a QueryContainer with MatchNoneQuery
        assertEquals("Boost should match", 2.0f, matchNoneQueryBuilder.boost(), 0.0f);
import org.opensearch.protobufs.QueryContainer;  
        super.setUp();  
        IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> converter.fromProto(emptyContainer));
        assertEquals("Query name should match", "test_query", matchNoneQueryBuilder.queryName());
        // Verify the result  
import org.opensearch.test.OpenSearchTestCase;
    public void testFromProto() {
}  
/*  
        // Verify the exception message  
    }  
import org.opensearch.index.query.QueryBuilder;
        // Test that the converter throws an exception  
 */  
        assertEquals(  
    }
 * The OpenSearch Contributors require contributions made to  
            "Exception message should mention 'does not contain a MatchNone query'",
        converter = new MatchNoneQueryBuilderProtoConverter();
import org.opensearch.protobufs.MatchNoneQuery;
        );
        MatchNoneQueryBuilder matchNoneQueryBuilder = (MatchNoneQueryBuilder) queryBuilder;  
    public void testGetHandledQueryCase() {
 * this file be licensed under the Apache-2.0 license or a
            converter.getHandledQueryCase()  
        MatchNoneQuery matchNoneQuery = MatchNoneQuery.newBuilder().setBoost(2.0f).setXName("test_query").build();  
        assertTrue("QueryBuilder should be a MatchNoneQueryBuilder", queryBuilder instanceof MatchNoneQueryBuilder);
public class MatchNoneQueryBuilderProtoConverterTests extends OpenSearchTestCase {  
 * SPDX-License-Identifier: Apache-2.0
        );
    private MatchNoneQueryBuilderProtoConverter converter;
            "Converter should handle MATCH_NONE case",
    public void testFromProtoWithInvalidContainer() {
        assertTrue(
        // Convert the query  
            exception.getMessage().contains("does not contain a MatchNone query")  
    @Override
            QueryContainer.QueryContainerCase.MATCH_NONE,
        QueryContainer emptyContainer = QueryContainer.newBuilder().build();
        // Test that the converter returns the correct QueryContainerCase
    public void setUp() throws Exception {
        QueryContainer queryContainer = QueryContainer.newBuilder().setMatchNone(matchNoneQuery).build();
    }
 *
