    }
        assertEquals(0.0, result.missing());  
        assertEquals("price", result.field());
}  
import org.opensearch.protobufs.MaxAggregation;
public class MaxAggregationProtoUtilsTests extends OpenSearchTestCase {  
        FieldValue missingValue = FieldValue.newBuilder()
        assertEquals(org.opensearch.search.aggregations.support.ValueType.UNSIGNED_LONG, result.userValueTypeHint());
    public void testFromProtoWithField() {
    public void testFromProtoWithoutFieldOrScript() {
        MaxAggregation proto = MaxAggregation.newBuilder().build();  
        assertNull(result.userValueTypeHint());
 */  
        MaxAggregation proto = MaxAggregation.newBuilder().setField("price").setFormat("0.00").build();
            .build();
        MaxAggregationBuilder result = MaxAggregationProtoUtils.fromProto("max_price", proto);  
        MaxAggregation proto = MaxAggregation.newBuilder().setField("price").build();  
import org.opensearch.protobufs.FieldValue;  
        MaxAggregation proto = MaxAggregation.newBuilder().setField("count").setValueType(ValueType.VALUE_TYPE_LONG).build();
        assertEquals("unknown", result.missing());
        MaxAggregationBuilder result = MaxAggregationProtoUtils.fromProto("max_price", proto);
            .build();  
package org.opensearch.transport.grpc.proto.request.search.aggregation.metrics;
        assertEquals("price", result.field());  
        MaxAggregationBuilder result = MaxAggregationProtoUtils.fromProto("max_rating", proto);
 * The OpenSearch Contributors require contributions made to  
    public void testFromProtoWithStringMissingValue() {  
    public void testFromProtoWithoutValueType() {
 * compatible open source license.
 *
    }
        MaxAggregationBuilder result = MaxAggregationProtoUtils.fromProto("max_count", proto);
        MaxAggregation proto = MaxAggregation.newBuilder().setField("price").setValueType(ValueType.VALUE_TYPE_UNSIGNED_LONG).build();  
            .setGeneralNumber(org.opensearch.protobufs.GeneralNumber.newBuilder().setDoubleValue(0.0).build())
        assertEquals("0.00", result.format());  
    }
        assertEquals(org.opensearch.search.aggregations.support.ValueType.DOUBLE, result.userValueTypeHint());
        assertEquals("count", result.field());  
    public void testFromProtoWithValueTypeUnsignedLong() {
    }
        MaxAggregation proto = MaxAggregation.newBuilder()
        assertTrue(ex.getMessage().contains("field") || ex.getMessage().contains("script"));  
    }  
    }
 * SPDX-License-Identifier: Apache-2.0
    public void testFromProtoWithValueTypeDouble() {
        MaxAggregation proto = MaxAggregation.newBuilder().setField("rating").setValueType(ValueType.VALUE_TYPE_DOUBLE).build();
        assertEquals("price", result.field());
 * this file be licensed under the Apache-2.0 license or a
        assertNotNull(result.userValueTypeHint());  
        assertEquals(org.opensearch.search.aggregations.support.ValueType.LONG, result.userValueTypeHint());
        assertNotNull(result);
        IllegalArgumentException ex = expectThrows(IllegalArgumentException.class, () -> MaxAggregationProtoUtils.fromProto("test", proto));
        assertEquals("max_price", result.getName());
        IllegalArgumentException ex = expectThrows(IllegalArgumentException.class, () -> MaxAggregationProtoUtils.fromProto("test", null));
    }
    public void testFromProtoWithMissingValue() {  
        assertEquals("rating", result.field());  
        MaxAggregation proto = MaxAggregation.newBuilder().setField("price").build();
import org.opensearch.search.aggregations.metrics.MaxAggregationBuilder;  
        MaxAggregationBuilder result = MaxAggregationProtoUtils.fromProto("max_price", proto);
/*  
    public void testFromProtoWithFieldAndFormat() {  
    public void testFromProtoWithNullProto() {  
import org.opensearch.test.OpenSearchTestCase;
    }
            .setField("status")
        assertTrue(ex.getMessage().contains("must not be null"));
        assertEquals("price", result.field());  
import org.opensearch.protobufs.ValueType;
        assertNotNull(result);
        MaxAggregation proto = MaxAggregation.newBuilder().setField("price").setMissing(missingValue).build();
        MaxAggregationBuilder result = MaxAggregationProtoUtils.fromProto("max_price", proto);
        MaxAggregationBuilder result = MaxAggregationProtoUtils.fromProto("max_price", proto);
    }
        MaxAggregationBuilder result = MaxAggregationProtoUtils.fromProto("max_status", proto);  
    public void testFromProtoWithValueTypeLong() {
            .setMissing(FieldValue.newBuilder().setString("unknown").build())  
    }  
