        assertTrue("Should be MaxAggregationBuilder", builder instanceof MaxAggregationBuilder);
    }  
        assertNotNull("Builder should not be null", builder);
    private MaxAggregationBuilderProtoConverter converter;
                MaxAggregation.newBuilder()
    public void setUp() throws Exception {
        assertNotNull("Builder should not be null", builder);
        AggregationContainer container = AggregationContainer.newBuilder()
     */  
 * compatible open source license.
            .build();
     */
        MaxAggregationBuilder maxBuilder = (MaxAggregationBuilder) builder;  
                    .setScript(Script.newBuilder().setInline(InlineScript.newBuilder().setSource("doc['price'].value * 2").build()).build())  
    }  
            .setMax(MaxAggregation.newBuilder().setField("price").setFormat("###.00").build())  
        AggregationContainer container = AggregationContainer.newBuilder()  
        AggregationContainer container = AggregationContainer.newBuilder().build();  
 * this file be licensed under the Apache-2.0 license or a
        assertNotNull("Script should not be null", maxBuilder.script());
/*  
import org.opensearch.test.OpenSearchTestCase;  
        assertTrue("Should be MaxAggregationBuilder", builder instanceof MaxAggregationBuilder);  
     * Test Max aggregation with script.  
 *
        converter.setRegistry(null);
        assertTrue(  
 */  
        MaxAggregationBuilder maxBuilder = (MaxAggregationBuilder) builder;
    /**
        assertEquals("Format should match", "###.00", maxBuilder.format());
        assertTrue("Should be MaxAggregationBuilder", builder instanceof MaxAggregationBuilder);
    }
    public void testContainerWithoutMax() {
    /**
        AggregationContainer container = AggregationContainer.newBuilder()  
        AggregationBuilder builder = converter.fromProto("max_price", container);
     */
    /**
     */  
        assertEquals("Script source should match", "doc['price'].value * 2", maxBuilder.script().getIdOrCode());
        AggregationBuilder builder = converter.fromProto("max_price", container);  
 * Tests for {@link MaxAggregationBuilderProtoConverter}.  
import org.opensearch.protobufs.MaxAggregation;
    @Override
        // Should not throw - default no-op implementation
        IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> converter.fromProto("test", container));
            "Exception should mention missing Max aggregation",
            .setMax(
    public void testMaxAggregationWithScript() {
        assertEquals("Name should match", "max_price", builder.getName());
     * Test Max aggregation with format.
import org.opensearch.protobufs.Script;  
 * Verifies that the converter properly handles the MAX case and delegates to MaxAggregationProtoUtils.
        MaxAggregationBuilder maxBuilder = (MaxAggregationBuilder) builder;  
     */
    }  
 */
    public void testSetRegistryNotImplemented() {  
import org.opensearch.search.aggregations.metrics.MaxAggregationBuilder;
import org.opensearch.protobufs.InlineScript;
    /**
package org.opensearch.transport.grpc.proto.request.search.aggregation.metrics;
     * Test that container without Max aggregation throws exception.  
        super.setUp();  
        AggregationBuilder builder = converter.fromProto("max_price", container);
/**
            .build();  
import org.opensearch.protobufs.AggregationContainer;  
     * Test that the converter reports the correct aggregation case.
        assertEquals("Should handle MAX case", AggregationContainer.AggregationContainerCase.MAX, converter.getHandledAggregationCase());
     * Test that converter does not implement setRegistry (metric aggregation).
public class MaxAggregationBuilderProtoConverterTests extends OpenSearchTestCase {  
    /**
import org.opensearch.search.aggregations.AggregationBuilder;
    }  
     * Test basic Max aggregation conversion with field only.  
            .build();
    public void testGetHandledAggregationCase() {
     */
                    .build()
            )
        converter = new MaxAggregationBuilderProtoConverter();
    }
    public void testMaxAggregationWithFormat() {
 * SPDX-License-Identifier: Apache-2.0
            .setMax(MaxAggregation.newBuilder().setField("price").build())
        assertNotNull("Builder should not be null", builder);  
    public void testBasicMaxAggregation() {
        );  
    }
}
    /**  
        assertEquals("Field should match", "price", maxBuilder.field());
            exception.getMessage().contains("Container does not contain Max aggregation")
 * The OpenSearch Contributors require contributions made to  
