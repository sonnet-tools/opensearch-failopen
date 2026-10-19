            }  
                return null;
        assertTrue("Should have metadata", result.getMin().hasMeta());
        };  
    public void testToProtoWithMetadata() throws IOException {  
        assertNotNull("Result should not be null", result);  
 * and common helper methods work correctly for Min/Max metric aggregations.
            protected boolean mustReduceOnSingleInternalAgg() {
                return null;  
 *
        Aggregate result = AggregateProtoUtils.toProto(internalMin, registry);
        IllegalArgumentException ex = expectThrows(
import org.opensearch.test.OpenSearchTestCase;  
    public void testToProtoWithNullThrowsException() {
        assertTrue("Should have max set", result.hasMax());
        InternalMax internalMax = new InternalMax("max_price", 99.9, DocValueFormat.RAW, Collections.emptyMap());  
            }
        assertTrue("Exception message should mention null", ex.getMessage().contains("must not be null"));
        assertNotNull("Result should not be null", result);  
        Map<String, Object> metadata = new HashMap<>();
import org.opensearch.search.aggregations.metrics.InternalMin;
import org.opensearch.protobufs.ObjectMap;
/**  
            @Override  
    public void testToProtoWithUnsupportedTypeThrowsException() throws IOException {
        InternalAggregation unsupported = new InternalAggregation("unsupported", Collections.emptyMap()) {
        assertTrue("Should have min set", result.hasMin());
    public void testToProtoWithInternalMin() throws IOException {
import org.opensearch.search.aggregations.metrics.InternalMax;
 * The OpenSearch Contributors require contributions made to  
 */  
            IllegalArgumentException.class,  
            public Object getProperty(List<String> path) {
            @Override
                return false;
        assertTrue("Metadata should contain key2", metaMap.getFieldsMap().containsKey("key2"));
                return builder;
        Aggregate result = AggregateProtoUtils.toProto(internalMin, registry);
        IllegalArgumentException ex = expectThrows(IllegalArgumentException.class, () -> AggregateProtoUtils.toProto(null, registry));  
import java.util.HashMap;
package org.opensearch.transport.grpc.proto.response.search.aggregation;
        ObjectMap metaMap = result.getMin().getMeta();
import java.util.List;  
    }  
        metadata.put("key1", "value1");
    }
 * compatible open source license.
        Aggregate result = AggregateProtoUtils.toProto(internalMax, registry);
        metadata.put("key2", 42);  
            }
    public void testToProtoWithEmptyMetadataDoesNotSetMeta() throws IOException {
import org.opensearch.search.aggregations.InternalAggregation;  
            ) throws IOException {  
            }
public class AggregateProtoUtilsTests extends OpenSearchTestCase {
 * this file be licensed under the Apache-2.0 license or a
    public void testToProtoWithInternalMax() throws IOException {
 * Tests for {@link AggregateProtoUtils} verifying the central dispatcher
        assertTrue("Metadata should contain key1", metaMap.getFieldsMap().containsKey("key1"));  
    private final AggregateProtoConverterRegistry registry = new AggregateProtoConverterRegistryImpl();  
        Aggregate result = AggregateProtoUtils.toProto(internalMin, registry);
        assertTrue("Exception message should mention unsupported", ex.getMessage().contains("Unsupported"));  
            protected void doWriteTo(org.opensearch.core.common.io.stream.StreamOutput out) throws IOException {}
            public String getWriteableName() {
/*  
    }  
            @Override  
        );
import org.opensearch.protobufs.Aggregate;  
        assertFalse("Should not have metadata", result.getMin().hasMeta());
import org.opensearch.transport.grpc.spi.AggregateProtoConverterRegistry;
        assertNotNull("Result should not be null", result);
import org.opensearch.search.DocValueFormat;
            @Override
                org.opensearch.core.xcontent.ToXContent.Params params
import java.util.Collections;
            @Override
        assertTrue("Value should be double", result.getMin().getValue().hasDouble());  
        InternalMin internalMin = new InternalMin("min_price", 10.5, DocValueFormat.RAW, Collections.emptyMap());  
 */  
        InternalMin internalMin = new InternalMin("min_with_meta", 15.5, DocValueFormat.RAW, metadata);
    }
        assertEquals("Value should match", 99.9, result.getMax().getValue().getDouble(), 0.001);
}  
        assertFalse("Should not have metadata for empty map", result.getMin().hasMeta());
    }
                return "unsupported";
        assertTrue("Value should be double", result.getMax().getValue().hasDouble());  
        assertNotNull("Result should not be null", result);
    }
            public InternalAggregation reduce(List<InternalAggregation> aggregations, InternalAggregation.ReduceContext reduceContext) {  
import java.io.IOException;  
            () -> AggregateProtoUtils.toProto(unsupported, registry)
                org.opensearch.core.xcontent.XContentBuilder builder,
 * SPDX-License-Identifier: Apache-2.0
import java.util.Map;
            @Override
        assertFalse("Should not have metadata", result.getMax().hasMeta());
            public org.opensearch.core.xcontent.XContentBuilder doXContentBody(  
        assertEquals("Value should match", 10.5, result.getMin().getValue().getDouble(), 0.001);
            }  
        InternalMin internalMin = new InternalMin("min_no_meta", 20.0, DocValueFormat.RAW, Collections.emptyMap());
