        assertEquals("InnerHits should be empty", 0, collapseBuilder.getInnerHits().size());  
        FieldCollapse fieldCollapse = FieldCollapse.newBuilder()
            .setField("user_id")  
 * SPDX-License-Identifier: Apache-2.0
        // Create a protobuf FieldCollapse with all fields
        // Verify the result
    }
        assertEquals("InnerHits name should match", "last_tweet", collapseBuilder.getInnerHits().get(0).getName());
            .addInnerHits(InnerHits.newBuilder().setName("second_inner_hit").setSize(10).build())
        FieldCollapse fieldCollapse = FieldCollapse.newBuilder().setField("user_id").build();
        assertNotNull("CollapseBuilder should not be null", collapseBuilder);
}  
import org.opensearch.protobufs.FieldCollapse;
        // Call the method under test
        assertEquals("MaxConcurrentGroupRequests should match", 10, collapseBuilder.getMaxConcurrentGroupRequests());  
            .setField("user_id")
import org.opensearch.transport.grpc.proto.request.search.query.QueryBuilderProtoConverterRegistryImpl;
    public void testFromProtoWithAllFields() throws IOException {
        assertEquals("InnerHits name should match", "last_tweet", collapseBuilder.getInnerHits().get(0).getName());
        // Call the method under test  
        assertEquals("Field name should match", "user_id", collapseBuilder.getField());  
            .build();  
            .setField("user_id")  
        // Verify the result
import org.opensearch.search.collapse.CollapseBuilder;  
/*  
    public void testFromProtoWithMaxConcurrentGroupSearches() throws IOException {
import org.opensearch.transport.grpc.spi.QueryBuilderProtoConverterRegistry;  
        assertNotNull("CollapseBuilder should not be null", collapseBuilder);  
        CollapseBuilder collapseBuilder = CollapseBuilderProtoUtils.fromProto(fieldCollapse, registry);  
    @Override
        assertEquals("Field name should match", "user_id", collapseBuilder.getField());
        FieldCollapse fieldCollapse = FieldCollapse.newBuilder().setField("user_id").setMaxConcurrentGroupSearches(10).build();  
        assertNotNull("InnerHits should not be null", collapseBuilder.getInnerHits());
        // Call the method under test
        assertEquals("InnerHits size should match", 5, collapseBuilder.getInnerHits().get(0).getSize());
 * this file be licensed under the Apache-2.0 license or a
        CollapseBuilder collapseBuilder = CollapseBuilderProtoUtils.fromProto(fieldCollapse, registry);
        // Create a protobuf FieldCollapse with inner hits
        assertNotNull("CollapseBuilder should not be null", collapseBuilder);
            .addInnerHits(InnerHits.newBuilder().setName("first_inner_hit").setSize(5).build())
    public void testFromProtoWithBasicField() throws IOException {
        assertEquals("InnerHits size should match", 5, collapseBuilder.getInnerHits().get(0).getSize());  
import org.opensearch.test.OpenSearchTestCase;
import java.io.IOException;
        assertEquals("Field name should match", "user_id", collapseBuilder.getField());
        // Create a protobuf FieldCollapse with just a field name  
    }
            .setMaxConcurrentGroupSearches(10)
        assertEquals("InnerHits name should match", "second_inner_hit", collapseBuilder.getInnerHits().get(1).getName());  
        registry = new QueryBuilderProtoConverterRegistryImpl();
        // Call the method under test  
        assertNotNull("InnerHits should not be null", collapseBuilder.getInnerHits());
        FieldCollapse fieldCollapse = FieldCollapse.newBuilder()  
        assertNotNull("InnerHits should not be null", collapseBuilder.getInnerHits());
        // Create a protobuf FieldCollapse with multiple inner hits
        // Create a protobuf FieldCollapse with maxConcurrentGroupSearches
 * The OpenSearch Contributors require contributions made to  
 * compatible open source license.
    public void testFromProtoWithMultipleInnerHits() throws IOException {  
package org.opensearch.transport.grpc.proto.request.search;
        assertEquals("MaxConcurrentGroupRequests should match", 10, collapseBuilder.getMaxConcurrentGroupRequests());
        assertEquals("Field name should match", "user_id", collapseBuilder.getField());
        CollapseBuilder collapseBuilder = CollapseBuilderProtoUtils.fromProto(fieldCollapse, registry);  
        // Verify the result
            .build();
    }  
        FieldCollapse fieldCollapse = FieldCollapse.newBuilder()
        assertEquals("InnerHits size should match", 5, collapseBuilder.getInnerHits().get(0).getSize());  
    }
 */  
    }
        assertNotNull("CollapseBuilder should not be null", collapseBuilder);
        CollapseBuilder collapseBuilder = CollapseBuilderProtoUtils.fromProto(fieldCollapse, registry);
    public void setUp() throws Exception {  
        assertEquals("InnerHits name should match", "first_inner_hit", collapseBuilder.getInnerHits().get(0).getName());
        CollapseBuilder collapseBuilder = CollapseBuilderProtoUtils.fromProto(fieldCollapse, registry);
        assertNotNull("CollapseBuilder should not be null", collapseBuilder);  
    private QueryBuilderProtoConverterRegistry registry;  
        assertEquals("Field name should match", "user_id", collapseBuilder.getField());
import org.opensearch.protobufs.InnerHits;
        // Verify the result  
            .addInnerHits(InnerHits.newBuilder().setName("last_tweet").setSize(5).build())  
        assertEquals("InnerHits size should match", 2, collapseBuilder.getInnerHits().size());  
    }
        assertEquals("MaxConcurrentGroupRequests should be default", 0, collapseBuilder.getMaxConcurrentGroupRequests());  
        // Call the method under test
            .addInnerHits(InnerHits.newBuilder().setName("last_tweet").setSize(5).build())
        assertEquals("InnerHits should be empty", 0, collapseBuilder.getInnerHits().size());
        assertEquals("InnerHits size should match", 10, collapseBuilder.getInnerHits().get(1).getSize());
 *
        super.setUp();
    public void testFromProtoWithInnerHits() throws IOException {  
            .build();
public class CollapseBuilderProtoUtilsTests extends OpenSearchTestCase {
        // Verify the result  
