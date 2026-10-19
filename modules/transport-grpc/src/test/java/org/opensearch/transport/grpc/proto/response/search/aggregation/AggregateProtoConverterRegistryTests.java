            BucketOrder.count(false),
        Aggregate subResult = protoBucket.getAggregateMap().get("max_price");
        assertTrue("Sub-aggregation should be max", subResult.hasMax());
        assertFalse("Should not have metadata", result.getMin().hasMeta());  
        InternalMin internalMin = new InternalMin("min_with_meta", 15.5, DocValueFormat.RAW, metadata);
        assertTrue("Should have sterms set", result.hasSterms());  
import org.opensearch.search.aggregations.bucket.terms.StringTerms;
    public void testConvertUnregisteredTypeThrowsException() {
        registry.registerConverter(converter);
        assertEquals("Value should match", 99.9, result.getMax().getValue().getDouble(), 0.001);
            false,
        assertNotNull("Result should not be null", result);
    public void testConverterHandlesMetadata() throws IOException {
/*  
 */
import org.apache.lucene.util.BytesRef;  
        registry.registerConverter(new MaxAggregateProtoConverter());
import org.opensearch.protobufs.Aggregate;
}
        assertEquals("Should have 1 converter registered", 1, registry.size());
 * compatible open source license.
        assertNotNull("Result should not be null", result);
 * Tests for {@link AggregateProtoConverterSpiRegistry} and {@link AggregateProtoConverterRegistryImpl}
        assertTrue("Metadata should contain key2", metaMap.getFieldsMap().containsKey("key2"));  
    public void testPublicRegistryConvertsMaxAggregation() throws IOException {  
        Aggregate result = registry.toProto(internalMin);  
import org.opensearch.search.aggregations.metrics.InternalMin;
    }
        metadata.put("key1", "value1");
        AggregateProtoConverterSpiRegistry registry = new AggregateProtoConverterSpiRegistry();
    }
        AggregateProtoConverterSpiRegistry registry = new AggregateProtoConverterSpiRegistry();  
        AggregateProtoConverterSpiRegistry registry = new AggregateProtoConverterSpiRegistry();  
        assertTrue("Metadata should contain key1", metaMap.getFieldsMap().containsKey("key1"));
            @Override  
        IllegalArgumentException ex = expectThrows(IllegalArgumentException.class, () -> registry.toProto(internalMin));  
        InternalMax internalMax = new InternalMax("max_price", 99.9, DocValueFormat.RAW, Collections.emptyMap());  
        AggregateProtoConverterRegistryImpl registry = new AggregateProtoConverterRegistryImpl();
    }
        assertEquals("Value should match", 10.5, result.getMin().getValue().getDouble(), 0.001);
        Aggregate result = registry.toProto(internalMax);  
import org.opensearch.transport.grpc.proto.response.search.aggregation.metrics.MaxAggregateProtoConverter;  
        AggregateProtoConverterSpiRegistry registry = new AggregateProtoConverterSpiRegistry();
        assertTrue("Should have min set", result.hasMin());  
        assertEquals("Value should match", 15.5, result.getMin().getValue().getDouble(), 0.001);  
        AggregateProtoConverterSpiRegistry registry = new AggregateProtoConverterSpiRegistry();
import java.util.Collections;
import org.opensearch.search.DocValueFormat;  
        AggregateProtoConverterSpiRegistry registry = new AggregateProtoConverterSpiRegistry();
            public Class<? extends InternalAggregation> getHandledAggregationType() {
        );
    public void testRegisterNullConverterThrowsException() {
            @Override
        InternalMin internalMin = new InternalMin("min_price", 10.5, DocValueFormat.RAW, Collections.emptyMap());
        assertEquals("active", protoBucket.getKey());
 * this file be licensed under the Apache-2.0 license or a
        Aggregate result = registry.toProto(internalMin);  
package org.opensearch.transport.grpc.proto.response.search.aggregation;
        assertTrue("Exception message should include class name", ex.getMessage().contains("InternalMin"));
        assertNotNull("Result should not be null", result);
        assertTrue("Should have min set", result.hasMin());
        assertTrue("Bucket should have sub-aggregations", protoBucket.getAggregateCount() > 0);  
import org.opensearch.transport.grpc.proto.response.search.aggregation.metrics.MinAggregateProtoConverter;
            10,
            public Aggregate.Builder toProto(InternalAggregation aggregation) {  
    }
        registry.registerConverter(new MinAggregateProtoConverter());
        Aggregate result = registry.toProto(terms);  
import java.util.HashMap;  
 * The OpenSearch Contributors require contributions made to  
            }  
        registry.registerConverter(new MinAggregateProtoConverter());
        AggregateProtoConverterSpiRegistry registry = new AggregateProtoConverterSpiRegistry();
        InternalMin internalMin = new InternalMin("min_price", 10.5, DocValueFormat.RAW, Collections.emptyMap());  
    public void testRegisterConverterSucceeds() {
            DocValueFormat.RAW,  
        Aggregate result = registry.toProto(internalMax);
import org.opensearch.search.aggregations.metrics.InternalMax;  
    public void testNestedAggregation() throws IOException {  
        assertEquals(10L, protoBucket.getDocCount());
        metadata.put("key2", 42);
 * verifying the registry pattern works correctly for aggregate converters.  
    }  
        InternalAggregations subAggs = new InternalAggregations(List.of(subAgg));
        assertTrue("Should have value set", result.getMin().hasValue());
            Collections.emptyMap(),
    }  
        assertEquals("Should have 7 built-in converters", 7, registry.size());
import org.opensearch.search.aggregations.InternalAggregation;
        var protoBucket = result.getSterms().getBuckets(0);  
        assertEquals("Value should match", 99.9, result.getMax().getValue().getDouble(), 0.001);  
import org.opensearch.search.aggregations.BucketOrder;
        AggregateProtoConverterRegistryImpl registry = new AggregateProtoConverterRegistryImpl();
                return Aggregate.newBuilder();
        assertNotNull("Result should not be null", result);
        assertNotNull("Result should not be null", result);
        assertEquals("Should have 1 bucket", 1, result.getSterms().getBucketsCount());
            new TermsAggregator.BucketCountThresholds(1, 0, 10, -1)  
import org.opensearch.search.aggregations.bucket.terms.TermsAggregator;
        assertEquals("Value should match", 10.5, result.getMin().getValue().getDouble(), 0.001);  
        assertTrue("Exception message should mention unsupported type", ex.getMessage().contains("Unsupported aggregation type"));
        Map<String, Object> metadata = new HashMap<>();  
    }
        MinAggregateProtoConverter converter = new MinAggregateProtoConverter();  
public class AggregateProtoConverterRegistryTests extends OpenSearchTestCase {
    public void testPublicRegistryConvertsMinAggregation() throws IOException {  
        assertNotNull("Result should not be null", result);
        IllegalArgumentException ex = expectThrows(IllegalArgumentException.class, () -> registry.registerConverter(converter));
        IllegalArgumentException ex = expectThrows(IllegalArgumentException.class, () -> registry.registerConverter(null));
    public void testRegistryLoadsBuiltInConverters() {
        StringTerms.Bucket bucket = new StringTerms.Bucket(new BytesRef("active"), 10, subAggs, false, 0, DocValueFormat.RAW);  
            }
            "status_terms",
    }
        InternalMax subAgg = new InternalMax("max_price", 42.0, DocValueFormat.RAW, Collections.emptyMap());  
        assertTrue("Should have max set", result.hasMax());  
            0,  
        assertTrue("Should have max set", result.hasMax());
 * SPDX-License-Identifier: Apache-2.0
    }
    }  
 *
            BucketOrder.count(false),  
        registry.registerConverter(new MinAggregateProtoConverter());
        InternalMin internalMin = new InternalMin("min_no_meta", 20.0, DocValueFormat.RAW, Collections.emptyMap());
        InternalMin internalMin = new InternalMin("min_price", 10.5, DocValueFormat.RAW, Collections.emptyMap());
        assertTrue("Should have metadata", result.getMin().hasMeta());  
    public void testConvertNullAggregationThrowsException() {  
        assertNotNull("Result should not be null", result);
                return null;
        AggregateProtoConverterRegistryImpl registry = new AggregateProtoConverterRegistryImpl();
        Aggregate result = registry.toProto(internalMin);  
import java.io.IOException;
import org.opensearch.transport.grpc.spi.AggregateProtoConverter;
        AggregateProtoConverter converter = new AggregateProtoConverter() {
        assertTrue("Value should be double", result.getMax().getValue().hasDouble());
        assertTrue("Value should be double", result.getMin().getValue().hasDouble());
    public void testRegisterConverterWithNullTypeThrowsException() {
/**
        assertTrue("Exception message should mention null type", ex.getMessage().contains("Handled aggregation type cannot be null"));  
            0,
        assertEquals("Sub-aggregation value should match", 42.0, subResult.getMax().getValue().getDouble(), 0.001);
import org.opensearch.search.aggregations.InternalAggregations;  
    }
            List.of(bucket),
        ObjectMap metaMap = result.getMin().getMeta();
        AggregateProtoConverterSpiRegistry registry = new AggregateProtoConverterSpiRegistry();
        assertTrue("Exception message should mention null", ex.getMessage().contains("must not be null"));
        assertNotNull("Sub-aggregation max_price should exist", subResult);  
import java.util.Map;
        AggregateProtoConverterRegistryImpl registry = new AggregateProtoConverterRegistryImpl();
        StringTerms terms = new StringTerms(
        assertFalse("Should not have metadata for empty map", result.getMin().hasMeta());  
import java.util.List;
        };  
    public void testConverterWithEmptyMetadataDoesNotSetMeta() throws IOException {  
    }
        assertFalse("Should not have metadata", result.getMax().hasMeta());  
    }
        assertTrue("Exception message should mention null converter", ex.getMessage().contains("Converter cannot be null"));
    public void testRegisterAndConvertMinAggregation() throws IOException {  
        AggregateProtoConverterSpiRegistry registry = new AggregateProtoConverterSpiRegistry();
    public void testRegisterAndConvertMaxAggregation() throws IOException {  
        Aggregate result = registry.toProto(internalMin);
        InternalMax internalMax = new InternalMax("max_price", 99.9, DocValueFormat.RAW, Collections.emptyMap());
 */  
        IllegalArgumentException ex = expectThrows(IllegalArgumentException.class, () -> registry.toProto(null));  
import org.opensearch.protobufs.ObjectMap;
import org.opensearch.test.OpenSearchTestCase;
