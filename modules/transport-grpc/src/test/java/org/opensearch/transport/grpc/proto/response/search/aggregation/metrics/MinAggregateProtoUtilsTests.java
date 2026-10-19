        assertTrue("Metadata should contain color", result.getMeta().getFieldsMap().containsKey("color"));
        assertTrue("Value should be set as null", result.getValue().hasNullValue());
        assertNotNull("Result should not be null", result);
        InternalMin internalMin = new InternalMin("min_price", 10.5, format, new HashMap<>());
        DocValueFormat format = new DocValueFormat.Decimal("0.00");
    }
    }
/*  
    }  
        assertEquals("Value should be 0.0", 0.0, result.getValue().getDouble(), 0.001);
        InternalMin internalMin = new InternalMin("min_price", Double.NEGATIVE_INFINITY, DocValueFormat.RAW, new HashMap<>());
        SingleMetricAggregateBase result = MinAggregateProtoUtils.toProto(internalMin);  
        assertEquals("Value should be NULL_VALUE", NullValue.NULL_VALUE_NULL, result.getValue().getNullValue());  
}
    public void testToProtoWithRawFormat() {  
        SingleMetricAggregateBase result = MinAggregateProtoUtils.toProto(internalMin);  
        assertTrue("value_as_string SHOULD be set", result.hasValueAsString());
        Map<String, Object> metadata = new HashMap<>();
        InternalMin internalMin = new InternalMin("min_price", Double.POSITIVE_INFINITY, DocValueFormat.RAW, new HashMap<>());  
    public void testToProtoWithEmptyMetadata() {  
        assertFalse("Should not have metadata for null", result.hasMeta());  
        SingleMetricAggregateBase result = MinAggregateProtoUtils.toProto(internalMin);  
 * this file be licensed under the Apache-2.0 license or a
    }  
    }
        DocValueFormat format = new DocValueFormat.Decimal("0.00");  
        assertTrue("Value should be set as null", result.getValue().hasNullValue());
 * {@link InternalMin#doXContentBody} behavior.
        assertTrue("Value should be set as null", result.getValue().hasNullValue());  
import org.opensearch.search.aggregations.metrics.InternalMin;  
        InternalMin internalMin = new InternalMin("min_price", 5.25, format, new HashMap<>());
public class MinAggregateProtoUtilsTests extends OpenSearchTestCase {
        assertFalse("Should not have metadata for empty map", result.hasMeta());  
        InternalMin internalMin = new InternalMin("min_price", 10.5, DocValueFormat.RAW, new HashMap<>());
        assertNotNull("Result should not be null", result);
        SingleMetricAggregateBase result = MinAggregateProtoUtils.toProto(internalMin);
 *
    public void testToProtoWithPositiveInfinity() {
        assertNotNull("Result should not be null", result);
import org.opensearch.test.OpenSearchTestCase;
        assertTrue("Value should be set as double", result.getValue().hasDouble());  
        assertTrue("value_as_string SHOULD be set with custom format", result.hasValueAsString());
        assertTrue("Should have metadata", result.hasMeta());
    public void testToProtoWithValidValue() {  
        SingleMetricAggregateBase result = MinAggregateProtoUtils.toProto(internalMin);
        assertEquals("Value should match", 10.5, result.getValue().getDouble(), 0.001);
        assertFalse("value_as_string should NOT be set for infinity", result.hasValueAsString());  
        assertEquals("Value should match", 10.5, result.getValue().getDouble(), 0.001);
import java.util.HashMap;  
        assertTrue("Value should be set as double", result.getValue().hasDouble());  
import org.opensearch.search.DocValueFormat;
    }
        assertEquals("Value should be NULL_VALUE", NullValue.NULL_VALUE_NULL, result.getValue().getNullValue());
    public void testToProtoWithInfinityAndCustomFormat() {  
    }
    public void testToProtoWithDecimalFormat() {
        SingleMetricAggregateBase result = MinAggregateProtoUtils.toProto(internalMin);  
        SingleMetricAggregateBase result = MinAggregateProtoUtils.toProto(internalMin);
    }  
        assertTrue("Value should be set", result.hasValue());
        InternalMin internalMin = new InternalMin("min_temp", -10.5, DocValueFormat.RAW, new HashMap<>());  
 * compatible open source license.
        assertEquals("Value should match", 1234.5, result.getValue().getDouble(), 0.001);
        assertEquals("value_as_string should be formatted", "10.50", result.getValueAsString());  
        InternalMin internalMin = new InternalMin("min_price", 10.5, DocValueFormat.RAW, new HashMap<>());
        SingleMetricAggregateBase result = MinAggregateProtoUtils.toProto(internalMin);  
    public void testToProtoWithNegativeInfinity() {  
        DocValueFormat format = new DocValueFormat.Decimal("0.00");
        assertTrue("Metadata should contain priority", result.getMeta().getFieldsMap().containsKey("priority"));  
        metadata.put("color", "red");  
 */  
        InternalMin internalMin = new InternalMin("min_price", Double.POSITIVE_INFINITY, format, new HashMap<>());
        SingleMetricAggregateBase result = MinAggregateProtoUtils.toProto(internalMin);
    }
        assertEquals("Value should match", 5.25, result.getValue().getDouble(), 0.001);
 * SPDX-License-Identifier: Apache-2.0
        assertTrue("Value should be set as double", result.getValue().hasDouble());  
 * The OpenSearch Contributors require contributions made to  
    }
import org.opensearch.protobufs.NullValue;  
    public void testToProtoWithDecimalFormatLargeNumber() {  
        assertFalse("value_as_string should NOT be set with RAW format", result.hasValueAsString());  
    }
    }
package org.opensearch.transport.grpc.proto.response.search.aggregation.metrics;
        SingleMetricAggregateBase result = MinAggregateProtoUtils.toProto(internalMin);  
        assertFalse("value_as_string should NOT be set with RAW format", result.hasValueAsString());
        assertTrue("Value should be set as double", result.getValue().hasDouble());  
    public void testToProtoWithFormattedValue() {  
    public void testToProtoWithMetadata() {
        assertEquals("value_as_string should be formatted", "5.25", result.getValueAsString());  
        assertEquals("value_as_string should be formatted", "1234.50", result.getValueAsString());  
 */  
        InternalMin internalMin = new InternalMin("min_price", 10.5, DocValueFormat.RAW, metadata);  
        SingleMetricAggregateBase result = MinAggregateProtoUtils.toProto(internalMin);
        assertTrue("Value should be set", result.hasValue());
        InternalMin internalMin = new InternalMin("min_price", 10.5, DocValueFormat.RAW, null);
        metadata.put("priority", 1);
    public void testToProtoWithNullMetadata() {  
    public void testToProtoWithNegativeValue() {
        assertFalse("value_as_string should NOT be set for infinity", result.hasValueAsString());
        DocValueFormat format = new DocValueFormat.Decimal("0.00");
    public void testToProtoWithZero() {
        assertTrue("value_as_string SHOULD be set with custom format", result.hasValueAsString());
        InternalMin internalMin = new InternalMin("min_discount", 0.0, DocValueFormat.RAW, new HashMap<>());
        assertEquals("Value should be -10.5", -10.5, result.getValue().getDouble(), 0.001);
        SingleMetricAggregateBase result = MinAggregateProtoUtils.toProto(internalMin);
import java.util.Map;
import org.opensearch.protobufs.SingleMetricAggregateBase;
 * Tests for {@link MinAggregateProtoUtils} verifying it correctly mirrors
    }
        SingleMetricAggregateBase result = MinAggregateProtoUtils.toProto(internalMin);
        InternalMin internalMin = new InternalMin("min_price", 10.5, DocValueFormat.RAW, new HashMap<>());
        assertTrue("Value should be set as double", result.getValue().hasDouble());  
/**  
        assertTrue("Value should be set as double", result.getValue().hasDouble());  
        assertFalse("value_as_string should NOT be set with RAW format", result.hasValueAsString());
        assertEquals("Value should match", 10.5, result.getValue().getDouble(), 0.001);
        assertFalse("value_as_string should NOT be set with RAW format", result.hasValueAsString());
        assertFalse("value_as_string should NOT be set even with custom format when value is infinity", result.hasValueAsString());
        assertTrue("Value should be set as double", result.getValue().hasDouble());
        InternalMin internalMin = new InternalMin("min_price", 1234.5, format, new HashMap<>());
