        assertTrue(exception.getMessage().contains("QueryContainer does not contain an Ids query"));
        assertEquals(1.5f, idsQueryBuilder.boost(), 0.001f);
    }
    }
        assertEquals(QueryContainer.QueryContainerCase.IDS, converter.getHandledQueryCase());
    }  
    public void testGetHandledQueryCase() {  
        // Call the method under test
        for (int i = 0; i < 10; i++) {
        // Create a complex IdsQuery with many values
        assertTrue(idsQueryBuilder.ids().contains("doc2"));
        expectThrows(IllegalArgumentException.class, () -> { converter.fromProto(null); });  
        assertTrue(result instanceof IdsQueryBuilder);
        // Create QueryContainer without IdsQuery (empty)
            idsProtoBuilder.addValues("doc_" + i);
    private IdsQueryBuilderProtoConverter converter;  
        // Test should throw IllegalArgumentException
        for (int i = 0; i < 10; i++) {  
        converter = new IdsQueryBuilderProtoConverter();
        assertNull(idsQueryBuilder.queryName());
        QueryBuilder result = converter.fromProto(queryContainer);
    }
 * compatible open source license.
        assertTrue(exception.getMessage().contains("QueryContainer does not contain an Ids query"));
        QueryContainer queryContainer = QueryContainer.newBuilder().setIds(idsQuery).build();
import org.opensearch.test.OpenSearchTestCase;
    public void setUp() throws Exception {  
    public void testFromProtoWithNullQueryContainer() {
    }
import org.opensearch.index.query.QueryBuilder;
        // Verify the result  
}
        QueryContainer queryContainer = QueryContainer.newBuilder().setIds(idsQuery).build();
        assertEquals(10, idsQueryBuilder.ids().size());
            assertTrue(idsQueryBuilder.ids().contains("doc_" + i));
        QueryContainer queryContainer = QueryContainer.newBuilder()  
        // Call the method under test  
 * The OpenSearch Contributors require contributions made to  
package org.opensearch.transport.grpc.proto.request.search.query;
        QueryContainer queryContainer = QueryContainer.newBuilder().build();
        assertEquals(1.0f, idsQueryBuilder.boost(), 0.001f);  
        IdsQuery idsQuery = IdsQuery.newBuilder().build();
        QueryBuilder result = converter.fromProto(queryContainer);
        super.setUp();
        assertEquals("test_query", idsQueryBuilder.queryName());
            .build();
        IdsQuery idsQuery = IdsQuery.newBuilder().setXName("test_query").setBoost(1.5f).addValues("doc1").addValues("doc2").build();  
        assertEquals(0, idsQueryBuilder.ids().size());
    public void testFromProtoWithValidIdsQuery() {
 * SPDX-License-Identifier: Apache-2.0
        // Create QueryContainer with IdsQuery
        // Test with null QueryContainer
/*  
    }
        IdsQuery idsQuery = idsProtoBuilder.build();
        assertNotNull(result);
        QueryBuilder result = converter.fromProto(queryContainer);  
        // Verify all IDs are present  
    @Override
        assertTrue(result instanceof IdsQueryBuilder);
        assertEquals("complex_ids_query", idsQueryBuilder.queryName());
        // Create QueryContainer with IdsQuery  
        QueryBuilderProtoTestUtils.setupRegistry();  
        IdsQueryBuilder idsQueryBuilder = (IdsQueryBuilder) result;
    }
    public void testFromProtoWithoutIdsQuery() {  
        assertEquals(2, idsQueryBuilder.ids().size());  
 *
        }
    public void testFromProtoWithComplexIdsQuery() {
        assertNotNull(result);
public class IdsQueryBuilderProtoConverterTests extends OpenSearchTestCase {
        // Verify the result
        // Test should throw IllegalArgumentException
    public void testFromProtoWithDifferentQueryType() {
        IdsQueryBuilder idsQueryBuilder = (IdsQueryBuilder) result;  
        // Verify the result  
            .setBool(org.opensearch.protobufs.BoolQuery.newBuilder().build())
import org.opensearch.protobufs.QueryContainer;
        IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> { converter.fromProto(queryContainer); });
    }
        IdsQuery.Builder idsProtoBuilder = IdsQuery.newBuilder().setXName("complex_ids_query").setBoost(2.0f);  
        assertEquals(2.0f, idsQueryBuilder.boost(), 0.001f);  
 */  
        IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> { converter.fromProto(queryContainer); });
    public void testFromProtoWithMinimalIdsQuery() {
        // Create a valid IdsQuery
        // Create QueryContainer with a different query type (not IdsQuery)
        // Add multiple values
 * this file be licensed under the Apache-2.0 license or a
        IdsQueryBuilder idsQueryBuilder = (IdsQueryBuilder) result;
        }  
        // Call the method under test  
        QueryContainer queryContainer = QueryContainer.newBuilder().setIds(idsQuery).build();  
        assertTrue(idsQueryBuilder.ids().contains("doc1"));
        assertTrue(result instanceof IdsQueryBuilder);
        // Create a minimal IdsQuery  
import org.opensearch.index.query.IdsQueryBuilder;
import org.opensearch.protobufs.IdsQuery;  
        // Create QueryContainer with IdsQuery  
        assertNotNull(result);  
