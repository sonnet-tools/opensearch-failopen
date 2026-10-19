        assertEquals("Inner query field should match", "status", termQueryBuilder.fieldName());
import org.opensearch.test.OpenSearchTestCase;
            .build();
        TermQueryBuilder termQueryBuilder = (TermQueryBuilder) innerQuery;  
        TermQuery termQuery = TermQuery.newBuilder()
            .setBoost(2.5f)  
        QueryContainer innerQueryContainer = QueryContainer.newBuilder().setTerm(termQuery).build();
/*  
        QueryBuilder innerQuery = constantScoreQueryBuilder.innerQuery();
        super.setUp();  
            .build();
            IllegalArgumentException.class,
    private QueryBuilderProtoConverterRegistryImpl registry;
        QueryContainer innerQueryContainer = QueryContainer.newBuilder().setTerm(termQuery).build();
import org.opensearch.protobufs.TermQuery;  
        TermQuery termQuery = TermQuery.newBuilder()  
        ConstantScoreQuery constantScoreQuery = ConstantScoreQuery.newBuilder()
    public void testFromProtoWithMissingFilter() {
    }
        TermQuery termQuery = TermQuery.newBuilder().setField("active").setValue(FieldValue.newBuilder().setBool(true).build()).build();  
            .setValue(FieldValue.newBuilder().setString("active").build())  
}
        QueryBuilder innerQuery = constantScoreQueryBuilder.innerQuery();
        assertEquals("ConstantScore query must have a filter query", exception.getMessage());  
        // Create a simple term query to wrap
        assertNotNull("Inner query should not be null", innerQuery);  
package org.opensearch.transport.grpc.proto.request.search.query;
public class ConstantScoreQueryBuilderProtoUtilsTests extends OpenSearchTestCase {  
        ConstantScoreQuery constantScoreQuery = ConstantScoreQuery.newBuilder().setFilter(innerQueryContainer).build();  
    }
        assertNotNull("Inner query should not be null", innerQuery);
            () -> ConstantScoreQueryBuilderProtoUtils.fromProto(constantScoreQuery, registry)  
        assertNotNull("ConstantScoreQueryBuilder should not be null", constantScoreQueryBuilder);
        assertEquals("Boost should match", 2.5f, constantScoreQueryBuilder.boost(), 0.001f);
        QueryContainer innerQueryContainer = QueryContainer.newBuilder().setTerm(termQuery).build();
        ConstantScoreQueryBuilder constantScoreQueryBuilder = ConstantScoreQueryBuilderProtoUtils.fromProto(constantScoreQuery, registry);
        ConstantScoreQuery constantScoreQuery = ConstantScoreQuery.newBuilder().setFilter(innerQueryContainer).build();  
 * SPDX-License-Identifier: Apache-2.0
    }
import org.opensearch.protobufs.FieldValue;
        assertEquals("Default boost should be 1.0", 1.0f, constantScoreQueryBuilder.boost(), 0.0f);  
        assertTrue("Inner query should be a TermQueryBuilder", innerQuery instanceof TermQueryBuilder);
            .build();
        assertEquals("Inner query value should match", "active", termQueryBuilder.value());
import org.opensearch.protobufs.QueryContainer;
    }
        );
    public void setUp() throws Exception {
import org.opensearch.index.query.QueryBuilder;
import org.opensearch.protobufs.ConstantScoreQuery;  
        registry = new QueryBuilderProtoConverterRegistryImpl();
        assertNotNull("Inner query should not be null", constantScoreQueryBuilder.innerQuery());
    public void testFromProtoWithMinimalFields() {
    }  
    public void testFromProtoWithNullRegistry() {  
 * compatible open source license.
    }
        IllegalArgumentException exception = expectThrows(
            .setField("status")
 * The OpenSearch Contributors require contributions made to  
            .setFilter(innerQueryContainer)
        assertEquals("QueryBuilderProtoConverterRegistry cannot be null", exception.getMessage());
            .build();  
        TermQuery termQuery = TermQuery.newBuilder()
    public void testFromProtoWithAllParameters() {  
        assertTrue("Inner query should be a TermQueryBuilder", innerQuery instanceof TermQueryBuilder);  
        IllegalArgumentException exception = expectThrows(
        ConstantScoreQuery constantScoreQuery = ConstantScoreQuery.newBuilder().setFilter(innerQueryContainer).build();  
 */  
    @Override
        QueryContainer innerQueryContainer = QueryContainer.newBuilder().setTerm(termQuery).build();
            () -> ConstantScoreQueryBuilderProtoUtils.fromProto(constantScoreQuery, null)
            .setValue(FieldValue.newBuilder().setString("active").build())
        ConstantScoreQuery constantScoreQuery = ConstantScoreQuery.newBuilder().build();
        ConstantScoreQueryBuilder constantScoreQueryBuilder = ConstantScoreQueryBuilderProtoUtils.fromProto(constantScoreQuery, registry);
    public void testFromProtoWithBasicConstantScoreQuery() {
        assertEquals("Query name should match", "test_constant_score", constantScoreQueryBuilder.queryName());
 *
        ConstantScoreQueryBuilder constantScoreQueryBuilder = ConstantScoreQueryBuilderProtoUtils.fromProto(constantScoreQuery, registry);
        assertNotNull("ConstantScoreQueryBuilder should not be null", constantScoreQueryBuilder);
 * this file be licensed under the Apache-2.0 license or a
            IllegalArgumentException.class,  
import org.opensearch.index.query.TermQueryBuilder;
            .setValue(FieldValue.newBuilder().setString("active").build())  
        assertNotNull("ConstantScoreQueryBuilder should not be null", constantScoreQueryBuilder);  
            .setXName("test_constant_score")
            .setField("status")
        );
        assertNull("Query name should be null", constantScoreQueryBuilder.queryName());  
import org.opensearch.index.query.ConstantScoreQueryBuilder;  
            .setField("status")
