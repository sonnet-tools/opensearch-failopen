            .setMeta(metaBuilder.build())
     * Test that Min aggregation conversion works correctly.  
        IllegalArgumentException exception = expectThrows(  
                    .putAggregations("max_price", subAgg)  
        );
        IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> registry.fromProto("", container));  
            .build();
        IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> registry.fromProto("test_agg", null));
        assertTrue(subBuilder instanceof MaxAggregationBuilder);  
import org.opensearch.transport.grpc.spi.AggregationBuilderProtoConverter;  
            @Override  
    }  
        assertNotNull("Max aggregation should be converted", maxBuilder);
    public void testMaxAggregationConversion() {  
        AggregationBuilderProtoConverterRegistryImpl registry = new AggregationBuilderProtoConverterRegistryImpl();
        AggregationBuilderProtoConverterSpiRegistry emptyRegistry = new AggregationBuilderProtoConverterSpiRegistry();  
            }  
            IllegalArgumentException.class,
            .setMin(MinAggregation.newBuilder().setField("price").build())
        IllegalArgumentException exception = expectThrows(
        assertTrue("Exception should mention null or empty name", exception.getMessage().contains("cannot be null or empty"));
                return AggregationContainer.AggregationContainerCase.MIN;
        AggregationContainer subAgg = AggregationContainer.newBuilder()
    }  
        // Test that valid names work fine
        assertTrue("Exception should mention null container", exception.getMessage().contains("cannot be null"));
        assertEquals("valid_name-with.dots:and_more", validBuilder.getName());
    public void testNullAggregationContainer() {
        assertNotNull("Valid aggregation name should be accepted", validBuilder);
        assertEquals("Name should match", "max_price", builder.getName());
            .setMin(MinAggregation.newBuilder().setField("price").build())
        AggregationBuilderProtoConverterRegistryImpl registry = new AggregationBuilderProtoConverterRegistryImpl();  
        // Create metadata
        assertTrue("Should be MinAggregationBuilder", minBuilder instanceof MinAggregationBuilder);
        assertEquals("Aggregation name should match", "max_price", maxBuilder.getName());  
     * Test that external converters can be registered.
    }
        IllegalArgumentException ex1 = expectThrows(IllegalArgumentException.class, () -> registry.fromProto("invalid[name", container));
    public void testUnsupportedAggregationType() {
        MinAggregationBuilder minBuilder = (MinAggregationBuilder) builder;
        assertEquals("by_category", builder.getName());
    public void testAggregationContainerNotSet() {
    /**
            .build();
        Map<String, Object> expectedMetadata = new HashMap<>();
        // Verify Min converter is registered
    }  
/**
    /**
     * See {@link AggregatorFactories#parseAggregators}.
        AggregationBuilderProtoConverterRegistryImpl registry = new AggregationBuilderProtoConverterRegistryImpl();  
        AggregationBuilder builder = registry.fromProto("min_price", container);
        AggregationBuilder builder = registry.fromProto("by_category", container);
        AggregationBuilderProtoConverterRegistryImpl registry = new AggregationBuilderProtoConverterRegistryImpl();
        assertTrue(builder instanceof TermsAggregationBuilder);  
    public void testInvalidAggregationNames() {
            .build();
        AggregationBuilder builder = registry.fromProto("max_price", container);
            IllegalArgumentException.class,
 */  
        assertTrue(
    /**  
        AggregationBuilderProtoConverterRegistryImpl registry = new AggregationBuilderProtoConverterRegistryImpl();
        AggregationContainer container = AggregationContainer.newBuilder()
    public void testMinAggregationConversion() {
            "Exception should mention unsupported aggregation type",  
        assertTrue("Should be MaxAggregationBuilder", maxBuilder instanceof MaxAggregationBuilder);
        IllegalArgumentException ex2 = expectThrows(IllegalArgumentException.class, () -> registry.fromProto("invalid]name", container));
        };  
        );
        assertTrue("Exception should mention invalid aggregation name", ex3.getMessage().contains("Invalid aggregation name"));  
        // Create aggregation with metadata
                TermsAggregation.newBuilder()
    }  
     */
     */  
        AggregationBuilderProtoConverterRegistryImpl registry = new AggregationBuilderProtoConverterRegistryImpl();
            .build();
        AggregationBuilderProtoConverterRegistryImpl registry = new AggregationBuilderProtoConverterRegistryImpl();  
    /**
    public void testMetadataHandling() {
    /**
    public void testEmptyAggregationName() {
import java.util.Map;  
    public void testNestedAggregationsInfrastructure() {
     */  
    }
        assertTrue("Should be MaxAggregationBuilder", builder instanceof MaxAggregationBuilder);  
 * The OpenSearch Contributors require contributions made to  
        assertEquals("Should use external converter name", "external_test", builder.getName());
    }
        // Test name with ']' character  
     * Note: Duplicate registrations are allowed and replace the existing converter with a warning.
     * Test that built-in converters (Min, Max) are registered by default.  
     * Test that null aggregation container throws exception.
            .setMax(MaxAggregation.newBuilder().setField("price").build())
     */  
        // Registering duplicate converter should succeed (replaces with warning)
    /**
            .build();  
    /**
        assertTrue(
            .setMin(MinAggregation.newBuilder().setField("price").build())
        IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> registry.fromProto(null, container));
        AggregationContainer container = AggregationContainer.newBuilder()
        AggregationContainer container = AggregationContainer.newBuilder()
     */
            .build();
        assertEquals("Metadata should match", expectedMetadata, builder.getMetadata());  
    }
            .build();
    public void testNullAggregationName() {  
     * Test that unsupported aggregation types throw appropriate exception.  
    }  
            )
        AggregationContainer container = AggregationContainer.newBuilder()
        AggregationBuilder builder = registry.fromProto("min_price", container);  
                    .setTerms(TermsAggregationFields.newBuilder().setField("category").build())
        assertNotNull("Aggregation should have metadata", builder.getMetadata());
        AggregationBuilder subBuilder = builder.getSubAggregations().iterator().next();
            .setMin(MinAggregation.newBuilder().setField("price").build())  
import org.opensearch.protobufs.MaxAggregation;
import org.opensearch.search.aggregations.AggregationBuilder;  
        AggregationBuilderProtoConverter mockConverter = new AggregationBuilderProtoConverter() {
            () -> registry.fromProto("test_agg", emptyContainer)  
        assertNotNull("Aggregation builder should not be null", builder);
        expectedMetadata.put("key2", 42L);
                return new MinAggregationBuilder("external_" + name);
            .build();  
        assertNotNull("Aggregation builder should not be null", builder);
    /**
            () -> emptyRegistry.fromProto("min_price", container)
            .build();  
import org.opensearch.protobufs.ObjectMap;  
     * Test that Max aggregation conversion works correctly.
import org.opensearch.search.aggregations.AggregatorFactories;
        assertEquals(1, builder.getSubAggregations().size());
        AggregationContainer container = AggregationContainer.newBuilder()
 * compatible open source license.
            .build();
        assertTrue("Exception should mention null or empty name", exception.getMessage().contains("cannot be null or empty"));
            .setMin(MinAggregation.newBuilder().setField("price").build())
 * SPDX-License-Identifier: Apache-2.0
            .setMax(MaxAggregation.newBuilder().setField("price").build())
     * Test that aggregation container with no type set throws exception.  
            public AggregationBuilder fromProto(String name, AggregationContainer container) {  
        assertEquals("Field should match", "price", maxBuilder.field());
        AggregationBuilder builder = registry.fromProto("test", container);
     * Test that empty aggregation name throws exception.  
        assertEquals("Name should match", "min_price", builder.getName());  
     * Verifies that aggregation name validation matches REST API behavior.
        );  
import org.opensearch.test.OpenSearchTestCase;
    /**
        assertTrue("Should be MinAggregationBuilder", builder instanceof MinAggregationBuilder);
        assertNotNull("Min aggregation should be converted", minBuilder);
     */
        AggregationContainer maxContainer = AggregationContainer.newBuilder()  
     * Test nested aggregations via a terms aggregation with a max sub-aggregation.
        MaxAggregationBuilder maxBuilder = (MaxAggregationBuilder) builder;  
        AggregationContainer container = AggregationContainer.newBuilder()
     */
        IllegalArgumentException ex3 = expectThrows(IllegalArgumentException.class, () -> registry.fromProto("invalid>name", container));
import org.opensearch.search.aggregations.metrics.MaxAggregationBuilder;  
        metaBuilder.putFields("key1", ObjectMap.Value.newBuilder().setString("value1").build());
            @Override
            }
 * this file be licensed under the Apache-2.0 license or a
/*  
            .setMin(MinAggregation.newBuilder().setField("price").build())  
        AggregationBuilderProtoConverterRegistryImpl registry = new AggregationBuilderProtoConverterRegistryImpl();
            .setMax(MaxAggregation.newBuilder().setField("price").build())
     */
            .setTermsAggregation(  
        AggregationBuilderProtoConverterRegistryImpl registry = new AggregationBuilderProtoConverterRegistryImpl();
     */  
        // Verify Max converter is registered
    }  
 *
 * Tests for {@link AggregationBuilderProtoConverterRegistryImpl}.  
            public AggregationContainer.AggregationContainerCase getHandledAggregationCase() {
        ObjectMap.Builder metaBuilder = ObjectMap.newBuilder();  
import org.opensearch.protobufs.TermsAggregationFields;
     * Test that metadata is applied at the container level.
 * Verifies converter registration, lookup, metadata handling, and basic aggregation conversion.
    /**  
        assertTrue("Exception should mention invalid aggregation name", ex2.getMessage().contains("Invalid aggregation name"));
    }
        assertEquals("price", ((MaxAggregationBuilder) subBuilder).field());
        assertEquals("category", ((TermsAggregationBuilder) builder).field());
}
import org.opensearch.protobufs.TermsAggregation;
            .build();
    public void testBuiltInConvertersRegistered() {
     */
        // Create a mock converter that replaces the built-in Min converter
import java.util.HashMap;
            .setMin(MinAggregation.newBuilder().setField("price").build())  
        // Test name with '>' character
            "Exception should mention unsupported aggregation type",
        AggregationBuilder validBuilder = registry.fromProto("valid_name-with.dots:and_more", container);  
                    .build()
     */
        AggregationContainer emptyContainer = AggregationContainer.newBuilder().build();
        AggregationContainer container = AggregationContainer.newBuilder()  
import org.opensearch.protobufs.AggregationContainer;  
    }
package org.opensearch.transport.grpc.proto.request.search.aggregation;
            .setMin(MinAggregation.newBuilder().setField("price").build())  
import org.opensearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
        assertTrue("Exception should mention forbidden characters", ex1.getMessage().contains("'[', ']', and '>'"));
            exception.getMessage().contains("Unsupported aggregation type")
public class AggregationBuilderProtoConverterRegistryTests extends OpenSearchTestCase {  
        // Test name with '[' character
     */  
        assertEquals("Aggregation name should match", "min_price", minBuilder.getName());  
        assertTrue("Exception should mention invalid aggregation name", ex1.getMessage().contains("Invalid aggregation name"));  
        AggregationContainer container = AggregationContainer.newBuilder()  
    public void testExternalConverterRegistration() {
        AggregationContainer container = AggregationContainer.newBuilder()  
        // Verify that the new converter is used  
        AggregationContainer minContainer = AggregationContainer.newBuilder()  
        AggregationBuilderProtoConverterRegistryImpl registry = new AggregationBuilderProtoConverterRegistryImpl();  
        );
            exception.getMessage().contains("Unsupported aggregation type")  
     * Test that invalid aggregation names are rejected.  
        registry.registerConverter(mockConverter);  
        expectedMetadata.put("key1", "value1");  
    /**  
        AggregationBuilder minBuilder = registry.fromProto("min_price", minContainer);  
        assertEquals("max_price", subBuilder.getName());
        AggregationBuilder maxBuilder = registry.fromProto("max_price", maxContainer);  
        AggregationBuilderProtoConverterRegistryImpl registry = new AggregationBuilderProtoConverterRegistryImpl();
        registry.updateRegistryOnAllConverters();
 */
        assertEquals("Field should match", "price", minBuilder.field());  
        metaBuilder.putFields("key2", ObjectMap.Value.newBuilder().setInt64(42L).build());
     * Test that null aggregation name throws exception.
            .build();
import org.opensearch.search.aggregations.metrics.MinAggregationBuilder;
import org.opensearch.protobufs.MinAggregation;
    /**
