        assertEquals(0.0, result.missing());  
import org.opensearch.test.OpenSearchTestCase;
        MinAggregation proto = MinAggregation.newBuilder().setField("price").setFormat("0.00").build();
        assertEquals("price", result.field());  
    public void testFromProtoWithoutFieldOrScript() {
    }
        IllegalArgumentException ex = expectThrows(IllegalArgumentException.class, () -> MinAggregationProtoUtils.fromProto("test", null));
        MinAggregation proto = MinAggregation.newBuilder()
        IllegalArgumentException ex = expectThrows(IllegalArgumentException.class, () -> MinAggregationProtoUtils.fromProto("test", proto));
import org.opensearch.protobufs.MinAggregation;
        assertNull(result.userValueTypeHint());
 * The OpenSearch Contributors require contributions made to  
            .setField("status")
            .setGeneralNumber(org.opensearch.protobufs.GeneralNumber.newBuilder().setDoubleValue(0.0).build())
    public void testFromProtoWithStringMissingValue() {  
        assertEquals("price", result.field());  
        MinAggregationBuilder result = MinAggregationProtoUtils.fromProto("min_count", proto);
        assertEquals(org.opensearch.search.aggregations.support.ValueType.LONG, result.userValueTypeHint());
        MinAggregation proto = MinAggregation.newBuilder().setField("price").build();  
        MinAggregationBuilder result = MinAggregationProtoUtils.fromProto("min_price", proto);
        MinAggregationBuilder result = MinAggregationProtoUtils.fromProto("min_price", proto);
 *
        MinAggregation proto = MinAggregation.newBuilder().setField("price").setMissing(missingValue).build();
        assertNotNull(result.userValueTypeHint());  
    public void testFromProtoWithMissingValue() {  
        assertTrue(ex.getMessage().contains("field") || ex.getMessage().contains("script"));  
    }
    public void testFromProtoWithFieldAndFormat() {  
 * compatible open source license.
        MinAggregation proto = MinAggregation.newBuilder().build();  
        MinAggregation proto = MinAggregation.newBuilder().setField("count").setValueType(ValueType.VALUE_TYPE_LONG).build();
        assertEquals(org.opensearch.search.aggregations.support.ValueType.UNSIGNED_LONG, result.userValueTypeHint());
            .build();
import org.opensearch.protobufs.FieldValue;  
public class MinAggregationProtoUtilsTests extends OpenSearchTestCase {  
import org.opensearch.search.aggregations.metrics.MinAggregationBuilder;  
    }
        assertNotNull(result);
import org.opensearch.protobufs.ValueType;
package org.opensearch.transport.grpc.proto.request.search.aggregation.metrics;
 */  
        assertNotNull(result);
    }
    public void testFromProtoWithField() {
    public void testFromProtoWithValueTypeLong() {
 * this file be licensed under the Apache-2.0 license or a
        MinAggregationBuilder result = MinAggregationProtoUtils.fromProto("min_price", proto);  
        assertTrue(ex.getMessage().contains("must not be null"));
 * SPDX-License-Identifier: Apache-2.0
            .build();  
    public void testFromProtoWithoutValueType() {
        MinAggregation proto = MinAggregation.newBuilder().setField("price").setValueType(ValueType.VALUE_TYPE_UNSIGNED_LONG).build();  
        assertEquals("count", result.field());  
    }
    public void testFromProtoWithValueTypeUnsignedLong() {
            .setMissing(FieldValue.newBuilder().setString("unknown").build())  
        assertEquals("price", result.field());
    }  
        MinAggregation proto = MinAggregation.newBuilder().setField("rating").setValueType(ValueType.VALUE_TYPE_DOUBLE).build();
/*  
    }  
    public void testFromProtoWithValueTypeDouble() {
        MinAggregationBuilder result = MinAggregationProtoUtils.fromProto("min_price", proto);
    }
        assertEquals(org.opensearch.search.aggregations.support.ValueType.DOUBLE, result.userValueTypeHint());
        assertEquals("price", result.field());
        assertEquals("0.00", result.format());  
}  
        MinAggregationBuilder result = MinAggregationProtoUtils.fromProto("min_price", proto);
        MinAggregationBuilder result = MinAggregationProtoUtils.fromProto("min_status", proto);  
    }
    }
    public void testFromProtoWithNullProto() {  
        assertEquals("unknown", result.missing());
        MinAggregationBuilder result = MinAggregationProtoUtils.fromProto("min_rating", proto);
        FieldValue missingValue = FieldValue.newBuilder()
        assertEquals("rating", result.field());  
        MinAggregation proto = MinAggregation.newBuilder().setField("price").build();
        assertEquals("min_price", result.getName());
