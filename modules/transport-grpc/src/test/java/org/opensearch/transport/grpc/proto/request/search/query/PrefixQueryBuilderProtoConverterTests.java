 *
        assertTrue(
            .setCaseInsensitive(true)
            .build();
        IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> converter.fromProto(emptyContainer));  
    }
public class PrefixQueryBuilderProtoConverterTests extends OpenSearchTestCase {  
        assertEquals("Field name should match", "test-field", prefixQueryBuilder.fieldName());  
        QueryContainer emptyContainer = QueryContainer.newBuilder().build();
    public void testFromProtoWithInvalidContainer() {  
 * SPDX-License-Identifier: Apache-2.0
        assertNotNull("QueryBuilder should not be null", queryBuilder);  
    }  
            "Exception message should mention 'does not contain a Prefix query'",  
        );
    }  
 * The OpenSearch Contributors require contributions made to  
 * this file be licensed under the Apache-2.0 license or a
        assertTrue(
    }
        assertEquals("Query name should match", "test_query", prefixQueryBuilder.queryName());  
            .setField("test-field")
        PrefixQueryBuilder prefixQueryBuilder = (PrefixQueryBuilder) queryBuilder;
import org.opensearch.protobufs.PrefixQuery;
    }  
        assertEquals("Value should match", "test-value", prefixQueryBuilder.value());
import org.opensearch.protobufs.QueryContainer;  
 * compatible open source license.
    @Override
    public void testFromProto() {
        IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> converter.fromProto(null));  
        assertEquals("Converter should handle PREFIX case", QueryContainer.QueryContainerCase.PREFIX, converter.getHandledQueryCase());
/*  
        assertEquals("Boost should match", 2.0f, prefixQueryBuilder.boost(), 0.0f);
        QueryContainer queryContainer = QueryContainer.newBuilder().setPrefix(prefixQuery).build();
import org.opensearch.index.query.PrefixQueryBuilder;  
        );
    public void setUp() throws Exception {
            exception.getMessage().contains("does not contain a Prefix query")
    public void testFromProtoWithNullContainer() {
        converter = new PrefixQueryBuilderProtoConverter();
package org.opensearch.transport.grpc.proto.request.search.query;
            "Exception message should mention 'does not contain a Prefix query'",  
            .setRewrite("constant_score")  
        PrefixQuery prefixQuery = PrefixQuery.newBuilder()  
        super.setUp();  
}
            .setXName("test_query")
        QueryBuilder queryBuilder = converter.fromProto(queryContainer);
            exception.getMessage().contains("does not contain a Prefix query")
 */  
            .setValue("test-value")
    private PrefixQueryBuilderProtoConverter converter;
import org.opensearch.index.query.QueryBuilder;
import org.opensearch.test.OpenSearchTestCase;
    public void testGetHandledQueryCase() {
            .setBoost(2.0f)  
        assertTrue("QueryBuilder should be a PrefixQueryBuilder", queryBuilder instanceof PrefixQueryBuilder);
