        assertNotNull("Builder should not be null", builder);
        converter = new MinAggregationBuilderProtoConverter();
 *
                    .build()
            .build();
     */
     * Test basic Min aggregation conversion with field only.  
import org.opensearch.protobufs.MinAggregation;
    private MinAggregationBuilderProtoConverter converter;
import org.opensearch.protobufs.Script;  
    }  
        AggregationContainer container = AggregationContainer.newBuilder()
    /**
        converter.setRegistry(null);
     */
            "Exception should mention missing Min aggregation",
        assertEquals("Script source should match", "doc['price'].value * 2", minBuilder.script().getIdOrCode());
        assertEquals("Name should match", "min_price", builder.getName());
        AggregationContainer container = AggregationContainer.newBuilder()  
    public void testSetRegistryNotImplemented() {  
        assertEquals("Format should match", "###.00", minBuilder.format());
 * this file be licensed under the Apache-2.0 license or a
        MinAggregationBuilder minBuilder = (MinAggregationBuilder) builder;  
        assertNotNull("Script should not be null", minBuilder.script());
public class MinAggregationBuilderProtoConverterTests extends OpenSearchTestCase {  
/*  
 * The OpenSearch Contributors require contributions made to  
}
            .setMin(MinAggregation.newBuilder().setField("price").setFormat("###.00").build())  
    }  
    public void testBasicMinAggregation() {
        assertTrue("Should be MinAggregationBuilder", builder instanceof MinAggregationBuilder);  
    public void testContainerWithoutMin() {
    public void testMinAggregationWithScript() {
import org.opensearch.protobufs.InlineScript;
     */  
    public void testGetHandledAggregationCase() {
    public void testMinAggregationWithFormat() {
        );  
        AggregationContainer container = AggregationContainer.newBuilder().build();  
        MinAggregationBuilder minBuilder = (MinAggregationBuilder) builder;
 */
                    .setScript(Script.newBuilder().setInline(InlineScript.newBuilder().setSource("doc['price'].value * 2").build()).build())  
     */
        AggregationBuilder builder = converter.fromProto("min_price", container);
    @Override
    }  
     * Test that container without Min aggregation throws exception.  
    /**
 * compatible open source license.
 * Tests for {@link MinAggregationBuilderProtoConverter}.  
        assertTrue("Should be MinAggregationBuilder", builder instanceof MinAggregationBuilder);
 * Verifies that the converter properly handles the MIN case and delegates to MinAggregationProtoUtils.
    /**
        MinAggregationBuilder minBuilder = (MinAggregationBuilder) builder;  
        super.setUp();  
     * Test that converter does not implement setRegistry (metric aggregation).
        assertNotNull("Builder should not be null", builder);
    public void setUp() throws Exception {
    }  
            exception.getMessage().contains("Container does not contain Min aggregation")
    /**
            .build();
    }
    }
     * Test Min aggregation with format.
        AggregationBuilder builder = converter.fromProto("min_price", container);
                MinAggregation.newBuilder()
import org.opensearch.test.OpenSearchTestCase;  
        assertEquals("Should handle MIN case", AggregationContainer.AggregationContainerCase.MIN, converter.getHandledAggregationCase());
/**
package org.opensearch.transport.grpc.proto.request.search.aggregation.metrics;
        assertEquals("Field should match", "price", minBuilder.field());
            .build();  
 * SPDX-License-Identifier: Apache-2.0
        IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> converter.fromProto("test", container));
        assertTrue(  
    /**
        assertTrue("Should be MinAggregationBuilder", builder instanceof MinAggregationBuilder);
     * Test that the converter reports the correct aggregation case.
        // Should not throw - default no-op implementation
        AggregationBuilder builder = converter.fromProto("min_price", container);  
            )
     */  
        assertNotNull("Builder should not be null", builder);  
    }
     */
            .setMin(
    /**  
import org.opensearch.search.aggregations.AggregationBuilder;
     * Test Min aggregation with script.  
            .setMin(MinAggregation.newBuilder().setField("price").build())
import org.opensearch.search.aggregations.metrics.MinAggregationBuilder;
 */  
import org.opensearch.protobufs.AggregationContainer;  
        AggregationContainer container = AggregationContainer.newBuilder()  
