        );
    public void testRegisterConverterSucceeds() {
        assertTrue("Metadata should contain key2", metaMap.getFieldsMap().containsKey("key2"));
import org.opensearch.test.OpenSearchTestCase;
import java.util.Map;
            @Override
        assertNotNull("Result should not be null", result);
import org.opensearch.search.aggregations.InternalAggregation;
        Aggregate result = registry.toProto(internalMax);
        assertNotNull("Result should not be null", result);
        AggregateProtoConverterRegistryImpl registry = new AggregateProtoConverterRegistryImpl();
import org.opensearch.search.aggregations.BucketOrder;
package org.opensearch.transport.grpc.proto.response.search.aggregation;
    public void testPublicRegistryConvertsMaxAggregation() throws IOException {
import org.opensearch.transport.grpc.spi.AggregateProtoConverter;
        assertTrue("Value should be double", result.getMin().getValue().hasDouble());
    public void testRegisterConverterWithNullTypeThrowsException() {
            10,
import org.opensearch.protobufs.ObjectMap;
        Aggregate result = registry.toProto(internalMax);
        InternalMax subAgg = new InternalMax("max_price", 42.0, DocValueFormat.RAW, Collections.emptyMap());
        IllegalArgumentException ex = expectThrows(IllegalArgumentException.class, () -> registry.registerConverter(null));
        AggregateProtoConverterSpiRegistry registry = new AggregateProtoConverterSpiRegistry();
        assertTrue("Should have min set", result.hasMin());
    public void testRegisterNullConverterThrowsException() {
            new TermsAggregator.BucketCountThresholds(1, 0, 10, -1)
    }
 * Tests for {@link AggregateProtoConverterSpiRegistry} and {@link AggregateProtoConverterRegistryImpl}
import java.io.IOException;
        AggregateProtoConverterSpiRegistry registry = new AggregateProtoConverterSpiRegistry();
public class AggregateProtoConverterRegistryTests extends OpenSearchTestCase {
        assertNotNull("Result should not be null", result);
        assertEquals("Value should match", 99.9, result.getMax().getValue().getDouble(), 0.001);
    }
 * The OpenSearch Contributors require contributions made to
        var protoBucket = result.getSterms().getBuckets(0);
        assertNotNull("Result should not be null", result);
        AggregateProtoConverterSpiRegistry registry = new AggregateProtoConverterSpiRegistry();
        assertTrue("Should have value set", result.getMin().hasValue());
        Aggregate result = registry.toProto(internalMin);
import org.opensearch.search.aggregations.metrics.InternalMax;
    }
import java.util.HashMap;
        assertTrue("Should have metadata", result.getMin().hasMeta());
        assertNotNull("Sub-aggregation max_price should exist", subResult);
        IllegalArgumentException ex = expectThrows(IllegalArgumentException.class, () -> registry.toProto(internalMin));
        ObjectMap metaMap = result.getMin().getMeta();
        assertTrue("Bucket should have sub-aggregations", protoBucket.getAggregateCount() > 0);
import org.opensearch.transport.grpc.proto.response.search.aggregation.metrics.MinAggregateProtoConverter;
            public Class<? extends InternalAggregation> getHandledAggregationType() {
            DocValueFormat.RAW,
        metadata.put("key2", 42);
 *
        AggregateProtoConverterSpiRegistry registry = new AggregateProtoConverterSpiRegistry();
            false,
/*
 * compatible open source license.
        registry.registerConverter(converter);
        AggregateProtoConverterSpiRegistry registry = new AggregateProtoConverterSpiRegistry();
        assertEquals("Should have 7 built-in converters", 7, registry.size());
import org.opensearch.transport.grpc.proto.response.search.aggregation.metrics.MaxAggregateProtoConverter;
        assertEquals("Value should match", 15.5, result.getMin().getValue().getDouble(), 0.001);
        IllegalArgumentException ex = expectThrows(IllegalArgumentException.class, () -> registry.registerConverter(converter));
    }
    public void testConverterHandlesMetadata() throws IOException {
        assertTrue("Exception message should mention null", ex.getMessage().contains("must not be null"));
        assertEquals("Should have 1 converter registered", 1, registry.size());
        Aggregate result = registry.toProto(internalMin);
}
        InternalMax internalMax = new InternalMax("max_price", 99.9, DocValueFormat.RAW, Collections.emptyMap());
        AggregateProtoConverterRegistryImpl registry = new AggregateProtoConverterRegistryImpl();
        registry.registerConverter(new MinAggregateProtoConverter());
        assertNotNull("Result should not be null", result);
                return null;
        assertNotNull("Result should not be null", result);
    public void testRegisterAndConvertMinAggregation() throws IOException {
    public void testConverterWithEmptyMetadataDoesNotSetMeta() throws IOException {
        Map<String, Object> metadata = new HashMap<>();
 */
    public void testPublicRegistryConvertsMinAggregation() throws IOException {
    }
        AggregateProtoConverterRegistryImpl registry = new AggregateProtoConverterRegistryImpl();
 * verifying the registry pattern works correctly for aggregate converters.
import org.opensearch.search.aggregations.InternalAggregations;
        registry.registerConverter(new MaxAggregateProtoConverter());
        assertTrue("Should have max set", result.hasMax());
        assertTrue("Should have min set", result.hasMin());
import java.util.Collections;
        AggregateProtoConverterRegistryImpl registry = new AggregateProtoConverterRegistryImpl();
        IllegalArgumentException ex = expectThrows(IllegalArgumentException.class, () -> registry.toProto(null));
    public void testConvertNullAggregationThrowsException() {
        assertTrue("Exception message should mention null converter", ex.getMessage().contains("Converter cannot be null"));
        assertTrue("Value should be double", result.getMax().getValue().hasDouble());
        assertEquals("Sub-aggregation value should match", 42.0, subResult.getMax().getValue().getDouble(), 0.001);
            BucketOrder.count(false),
import java.util.List;
        registry.registerConverter(new MinAggregateProtoConverter());
    public void testConvertUnregisteredTypeThrowsException() {
        InternalAggregations subAggs = new InternalAggregations(List.of(subAgg));
            }
        AggregateProtoConverterSpiRegistry registry = new AggregateProtoConverterSpiRegistry();
        AggregateProtoConverterSpiRegistry registry = new AggregateProtoConverterSpiRegistry();
            List.of(bucket),
        Aggregate subResult = protoBucket.getAggregateMap().get("max_price");
    public void testRegistryLoadsBuiltInConverters() {
        registry.registerConverter(new MinAggregateProtoConverter());
        assertTrue("Exception message should mention unsupported type", ex.getMessage().contains("Unsupported aggregation type"));
    }
        assertEquals(10L, protoBucket.getDocCount());
        InternalMin internalMin = new InternalMin("min_with_meta", 15.5, DocValueFormat.RAW, metadata);
        assertTrue("Should have max set", result.hasMax());
import org.opensearch.search.aggregations.bucket.terms.TermsAggregator;
    }
            0,
        StringTerms terms = new StringTerms(
        InternalMin internalMin = new InternalMin("min_price", 10.5, DocValueFormat.RAW, Collections.emptyMap());
    }
    }
import org.opensearch.search.DocValueFormat;
    }
        assertEquals("Value should match", 99.9, result.getMax().getValue().getDouble(), 0.001);
        InternalMin internalMin = new InternalMin("min_price", 10.5, DocValueFormat.RAW, Collections.emptyMap());
        assertEquals("Value should match", 10.5, result.getMin().getValue().getDouble(), 0.001);
        assertTrue("Should have sterms set", result.hasSterms());
            Collections.emptyMap(),
        assertTrue("Exception message should include class name", ex.getMessage().contains("InternalMin"));
        Aggregate result = registry.toProto(internalMin);
            }
        StringTerms.Bucket bucket = new StringTerms.Bucket(new BytesRef("active"), 10, subAggs, false, 0, DocValueFormat.RAW);
        assertTrue("Sub-aggregation should be max", subResult.hasMax());
import org.opensearch.search.aggregations.bucket.terms.StringTerms;
    public void testRegisterAndConvertMaxAggregation() throws IOException {
        MinAggregateProtoConverter converter = new MinAggregateProtoConverter();
        assertTrue("Metadata should contain key1", metaMap.getFieldsMap().containsKey("key1"));
            @Override
        Aggregate result = registry.toProto(internalMin);
        };
        Aggregate result = registry.toProto(terms);
    }
        assertFalse("Should not have metadata for empty map", result.getMin().hasMeta());
    }
            BucketOrder.count(false),
import org.opensearch.search.aggregations.metrics.InternalMin;
        metadata.put("key1", "value1");
        InternalMax internalMax = new InternalMax("max_price", 99.9, DocValueFormat.RAW, Collections.emptyMap());
            "status_terms",
        AggregateProtoConverterSpiRegistry registry = new AggregateProtoConverterSpiRegistry();
    public void testNestedAggregation() throws IOException {
        AggregateProtoConverter converter = new AggregateProtoConverter() {
        assertEquals("Should have 1 bucket", 1, result.getSterms().getBucketsCount());
/**
        InternalMin internalMin = new InternalMin("min_no_meta", 20.0, DocValueFormat.RAW, Collections.emptyMap());
        assertEquals("active", protoBucket.getKey());
import org.opensearch.protobufs.Aggregate;
        assertFalse("Should not have metadata", result.getMin().hasMeta());
                return Aggregate.newBuilder();
        InternalMin internalMin = new InternalMin("min_price", 10.5, DocValueFormat.RAW, Collections.emptyMap());
        assertFalse("Should not have metadata", result.getMax().hasMeta());
        assertNotNull("Result should not be null", result);
 * SPDX-License-Identifier: Apache-2.0
        AggregateProtoConverterSpiRegistry registry = new AggregateProtoConverterSpiRegistry();
            public Aggregate.Builder toProto(InternalAggregation aggregation) {
 */
        assertTrue("Exception message should mention null type", ex.getMessage().contains("Handled aggregation type cannot be null"));
        assertEquals("Value should match", 10.5, result.getMin().getValue().getDouble(), 0.001);
    }
import org.apache.lucene.util.BytesRef;
 * this file be licensed under the Apache-2.0 license or a
            0,
