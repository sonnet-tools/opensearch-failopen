        QueryContainer emptyContainer = QueryContainer.newBuilder().build();
        converter = new MatchAllQueryBuilderProtoConverter();
    }
            "Converter should handle MATCH_ALL case",
        assertNotNull("QueryBuilder should not be null", queryBuilder);
        // Verify the result  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.protobufs.MatchAllQuery;
        MatchAllQueryBuilder matchAllQueryBuilder = (MatchAllQueryBuilder) queryBuilder;  
        super.setUp();  
        QueryContainer queryContainer = QueryContainer.newBuilder().setMatchAll(matchAllQuery).build();
        assertEquals(  
 * The OpenSearch Contributors require contributions made to  
 *
}  
        assertTrue(
        );
    }  
public class MatchAllQueryBuilderProtoConverterTests extends OpenSearchTestCase {  
        QueryBuilder queryBuilder = converter.fromProto(queryContainer);
/*  
 * compatible open source license.
        MatchAllQuery matchAllQuery = MatchAllQuery.newBuilder().setBoost(2.0f).setXName("test_query").build();  
    }
        assertTrue("QueryBuilder should be a MatchAllQueryBuilder", queryBuilder instanceof MatchAllQueryBuilder);
            "Exception message should mention 'does not contain a MatchAll query'",
        );
    private MatchAllQueryBuilderProtoConverter converter;
        // Verify the exception message  
 * SPDX-License-Identifier: Apache-2.0
    public void testFromProtoWithInvalidContainer() {
    public void testGetHandledQueryCase() {
        // Convert the query  
 */  
            exception.getMessage().contains("does not contain a MatchAll query")  
        assertEquals("Boost should match", 2.0f, matchAllQueryBuilder.boost(), 0.0f);
        // Test that the converter returns the correct QueryContainerCase
        assertEquals("Query name should match", "test_query", matchAllQueryBuilder.queryName());
    public void setUp() throws Exception {
import org.opensearch.index.query.QueryBuilder;
package org.opensearch.transport.grpc.proto.request.search.query;
            QueryContainer.QueryContainerCase.MATCH_ALL,
        // Test that the converter throws an exception  
    @Override
import org.opensearch.index.query.MatchAllQueryBuilder;  
import org.opensearch.protobufs.QueryContainer;  
        IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> converter.fromProto(emptyContainer));
        // Create a QueryContainer with MatchAllQuery
    }
import org.opensearch.test.OpenSearchTestCase;
    public void testFromProto() {
            converter.getHandledQueryCase()  
        // Create a QueryContainer with a different query type  
