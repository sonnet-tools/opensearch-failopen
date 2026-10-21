/**
        );
    public void testExternalConverterRegistration() {
        assertTrue("Should be MinAggregationBuilder", minBuilder instanceof MinAggregationBuilder);
        assertEquals("Aggregation name should match", "min_price", minBuilder.getName());
 */
        );
            .build();
        AggregationBuilder builder = registry.fromProto("min_price", container);
        AggregationContainer container = AggregationContainer.newBuilder()
import java.util.HashMap;
        AggregationContainer maxContainer = AggregationContainer.newBuilder()
            public AggregationBuilder fromProto(String name, AggregationContainer container) {
        AggregationBuilderProtoConverterRegistryImpl registry = new AggregationBuilderProtoConverterRegistryImpl();
        assertTrue("Exception should mention invalid aggregation name", ex1.getMessage().contains("Invalid aggregation name"));
        AggregationBuilderProtoConverterRegistryImpl registry = new AggregationBuilderProtoConverterRegistryImpl();
import org.opensearch.search.aggregations.metrics.MinAggregationBuilder;
        assertNotNull("Max aggregation should be converted", maxBuilder);
        AggregationBuilderProtoConverterRegistryImpl registry = new AggregationBuilderProtoConverterRegistryImpl();
        assertEquals("Aggregation name should match", "max_price", maxBuilder.getName());
            .setMin(MinAggregation.newBuilder().setField("price").build())
        // Create aggregation with metadata
                    .setTerms(TermsAggregationFields.newBuilder().setField("category").build())
                    .putAggregations("max_price", subAgg)
     * Test that built-in converters (Min, Max) are registered by default.
        // Test name with '[' character
        AggregationBuilderProtoConverterRegistryImpl registry = new AggregationBuilderProtoConverterRegistryImpl();
            () -> emptyRegistry.fromProto("min_price", container)
        // Verify that the new converter is used
        AggregationContainer container = AggregationContainer.newBuilder()
        assertTrue("Exception should mention forbidden characters", ex1.getMessage().contains("'[', ']', and '>'"));
import org.opensearch.search.aggregations.metrics.MaxAggregationBuilder;
            .setTermsAggregation(
        assertTrue("Exception should mention null or empty name", exception.getMessage().contains("cannot be null or empty"));
        assertTrue("Exception should mention null container", exception.getMessage().contains("cannot be null"));
     * Verifies that aggregation name validation matches REST API behavior.
        IllegalArgumentException ex1 = expectThrows(IllegalArgumentException.class, () -> registry.fromProto("invalid[name", container));
            .build();
            }
            .build();
        AggregationContainer container = AggregationContainer.newBuilder()
    /**
        assertEquals("max_price", subBuilder.getName());
        assertEquals("Field should match", "price", minBuilder.field());
    /**
            .setMin(MinAggregation.newBuilder().setField("price").build())
    public void testEmptyAggregationName() {
    public void testAggregationContainerNotSet() {
        AggregationContainer subAgg = AggregationContainer.newBuilder()
     */
 * Tests for {@link AggregationBuilderProtoConverterRegistryImpl}.
public class AggregationBuilderProtoConverterRegistryTests extends OpenSearchTestCase {
            .setMin(MinAggregation.newBuilder().setField("price").build())
        assertNotNull("Valid aggregation name should be accepted", validBuilder);
            .setMin(MinAggregation.newBuilder().setField("price").build())
        AggregationBuilderProtoConverterRegistryImpl registry = new AggregationBuilderProtoConverterRegistryImpl();
    /**
 * compatible open source license.
     */
        assertTrue(
        assertNotNull("Min aggregation should be converted", minBuilder);
    public void testBuiltInConvertersRegistered() {
        AggregationContainer minContainer = AggregationContainer.newBuilder()
     * Test that metadata is applied at the container level.
package org.opensearch.transport.grpc.proto.request.search.aggregation;
    /**
 * SPDX-License-Identifier: Apache-2.0
                return AggregationContainer.AggregationContainerCase.MIN;
    public void testUnsupportedAggregationType() {
import org.opensearch.transport.grpc.spi.AggregationBuilderProtoConverter;
            .setMin(MinAggregation.newBuilder().setField("price").build())
        metaBuilder.putFields("key1", ObjectMap.Value.newBuilder().setString("value1").build());
    /**
        };
        // Create a mock converter that replaces the built-in Min converter
     * Test that empty aggregation name throws exception.
            exception.getMessage().contains("Unsupported aggregation type")
     * Test that unsupported aggregation types throw appropriate exception.
        assertEquals(1, builder.getSubAggregations().size());
        // Verify Min converter is registered
     */
            .setMin(MinAggregation.newBuilder().setField("price").build())
    }
     * Test nested aggregations via a terms aggregation with a max sub-aggregation.
    public void testMinAggregationConversion() {
            )
        expectedMetadata.put("key1", "value1");
            .build();
        assertEquals("valid_name-with.dots:and_more", validBuilder.getName());
        AggregationContainer container = AggregationContainer.newBuilder()
            .setMin(MinAggregation.newBuilder().setField("price").build())
     * Test that null aggregation container throws exception.
     * Test that Max aggregation conversion works correctly.
        assertEquals("category", ((TermsAggregationBuilder) builder).field());
    }
        AggregationContainer container = AggregationContainer.newBuilder()
        assertTrue("Should be MaxAggregationBuilder", builder instanceof MaxAggregationBuilder);
            .setMin(MinAggregation.newBuilder().setField("price").build())
     */
        AggregationBuilderProtoConverterRegistryImpl registry = new AggregationBuilderProtoConverterRegistryImpl();
    }
        AggregationBuilder subBuilder = builder.getSubAggregations().iterator().next();
        AggregationContainer container = AggregationContainer.newBuilder()
        // Registering duplicate converter should succeed (replaces with warning)
        assertNotNull("Aggregation builder should not be null", builder);
        MaxAggregationBuilder maxBuilder = (MaxAggregationBuilder) builder;
        assertEquals("Should use external converter name", "external_test", builder.getName());
    }
        metaBuilder.putFields("key2", ObjectMap.Value.newBuilder().setInt64(42L).build());
import org.opensearch.protobufs.TermsAggregation;
        AggregationBuilderProtoConverterRegistryImpl registry = new AggregationBuilderProtoConverterRegistryImpl();
import org.opensearch.search.aggregations.AggregationBuilder;
        AggregationBuilder builder = registry.fromProto("max_price", container);
        IllegalArgumentException ex2 = expectThrows(IllegalArgumentException.class, () -> registry.fromProto("invalid]name", container));
                    .build()
        AggregationBuilder minBuilder = registry.fromProto("min_price", minContainer);
            IllegalArgumentException.class,
    /**
        AggregationContainer container = AggregationContainer.newBuilder()
import java.util.Map;
     * Test that external converters can be registered.
            exception.getMessage().contains("Unsupported aggregation type")
    }
        assertTrue("Should be MaxAggregationBuilder", maxBuilder instanceof MaxAggregationBuilder);
            @Override
import org.opensearch.protobufs.ObjectMap;
        IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> registry.fromProto("", container));
            .setMax(MaxAggregation.newBuilder().setField("price").build())
     * Note: Duplicate registrations are allowed and replace the existing converter with a warning.
        // Test name with ']' character
            "Exception should mention unsupported aggregation type",
            .build();
        MinAggregationBuilder minBuilder = (MinAggregationBuilder) builder;
        registry.registerConverter(mockConverter);
import org.opensearch.protobufs.TermsAggregationFields;
        );
        AggregationBuilder builder = registry.fromProto("min_price", container);
     * Test that null aggregation name throws exception.
    public void testMaxAggregationConversion() {
        // Test that valid names work fine
        assertEquals("Name should match", "max_price", builder.getName());
            "Exception should mention unsupported aggregation type",
            .build();
            @Override
        assertEquals("price", ((MaxAggregationBuilder) subBuilder).field());
                TermsAggregation.newBuilder()
    /**
            .build();
     * See {@link AggregatorFactories#parseAggregators}.
        AggregationContainer container = AggregationContainer.newBuilder()
        assertEquals("by_category", builder.getName());
import org.opensearch.test.OpenSearchTestCase;
        AggregationContainer emptyContainer = AggregationContainer.newBuilder().build();
            .setMax(MaxAggregation.newBuilder().setField("price").build())
     */
        assertTrue(subBuilder instanceof MaxAggregationBuilder);
            .setMeta(metaBuilder.build())
     */
        assertNotNull("Aggregation builder should not be null", builder);
     * Test that aggregation container with no type set throws exception.
            () -> registry.fromProto("test_agg", emptyContainer)
        // Test name with '>' character
    }
     */
        AggregationBuilderProtoConverter mockConverter = new AggregationBuilderProtoConverter() {
            public AggregationContainer.AggregationContainerCase getHandledAggregationCase() {
     */
import org.opensearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
        AggregationBuilderProtoConverterRegistryImpl registry = new AggregationBuilderProtoConverterRegistryImpl();
            .build();
    /**
import org.opensearch.protobufs.MaxAggregation;
    /**
    public void testNullAggregationContainer() {
                return new MinAggregationBuilder("external_" + name);
        AggregationBuilderProtoConverterRegistryImpl registry = new AggregationBuilderProtoConverterRegistryImpl();
        assertEquals("Name should match", "min_price", builder.getName());
            }
        AggregationBuilder validBuilder = registry.fromProto("valid_name-with.dots:and_more", container);
        AggregationBuilder builder = registry.fromProto("by_category", container);
        AggregationContainer container = AggregationContainer.newBuilder()
        // Create metadata
 * The OpenSearch Contributors require contributions made to
    public void testMetadataHandling() {
        IllegalArgumentException exception = expectThrows(
        ObjectMap.Builder metaBuilder = ObjectMap.newBuilder();
 * Verifies converter registration, lookup, metadata handling, and basic aggregation conversion.
 */
    }
        IllegalArgumentException exception = expectThrows(
    }
    }
        // Verify Max converter is registered
        IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> registry.fromProto(null, container));
            IllegalArgumentException.class,
 * this file be licensed under the Apache-2.0 license or a
            .setMax(MaxAggregation.newBuilder().setField("price").build())
    public void testNullAggregationName() {
    /**
        Map<String, Object> expectedMetadata = new HashMap<>();
        assertTrue("Should be MinAggregationBuilder", builder instanceof MinAggregationBuilder);
        assertTrue("Exception should mention invalid aggregation name", ex2.getMessage().contains("Invalid aggregation name"));
        expectedMetadata.put("key2", 42L);
            .build();
}
/*
    }
    public void testInvalidAggregationNames() {
    /**
        AggregationBuilderProtoConverterRegistryImpl registry = new AggregationBuilderProtoConverterRegistryImpl();
     * Test that invalid aggregation names are rejected.
        registry.updateRegistryOnAllConverters();
    /**
        assertEquals("Metadata should match", expectedMetadata, builder.getMetadata());
        IllegalArgumentException ex3 = expectThrows(IllegalArgumentException.class, () -> registry.fromProto("invalid>name", container));
    }
        AggregationBuilderProtoConverterRegistryImpl registry = new AggregationBuilderProtoConverterRegistryImpl();
            .build();
            .build();
        assertTrue("Exception should mention invalid aggregation name", ex3.getMessage().contains("Invalid aggregation name"));
        AggregationBuilderProtoConverterSpiRegistry emptyRegistry = new AggregationBuilderProtoConverterSpiRegistry();
        AggregationBuilder builder = registry.fromProto("test", container);
        IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> registry.fromProto("test_agg", null));
            .build();
        AggregationBuilder maxBuilder = registry.fromProto("max_price", maxContainer);
    public void testNestedAggregationsInfrastructure() {
     */
     */
        assertTrue(builder instanceof TermsAggregationBuilder);
 *
    }
import org.opensearch.search.aggregations.AggregatorFactories;
import org.opensearch.protobufs.AggregationContainer;
        assertTrue("Exception should mention null or empty name", exception.getMessage().contains("cannot be null or empty"));
import org.opensearch.protobufs.MinAggregation;
     * Test that Min aggregation conversion works correctly.
        );
        assertNotNull("Aggregation should have metadata", builder.getMetadata());
     */
        assertEquals("Field should match", "price", maxBuilder.field());
        assertTrue(
     */
