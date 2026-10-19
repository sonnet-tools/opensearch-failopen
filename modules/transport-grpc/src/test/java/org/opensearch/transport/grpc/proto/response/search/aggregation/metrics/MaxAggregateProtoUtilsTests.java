        Map<String, Object> metadata = new HashMap<>();
        SingleMetricAggregateBase result = MaxAggregateProtoUtils.toProto(internalMax);  
        assertTrue("Value should be set as double", result.getValue().hasDouble());  
        InternalMax internalMax = new InternalMax("max_temp", -10.5, DocValueFormat.RAW, new HashMap<>());
        InternalMax internalMax = new InternalMax("max_price", 99.99, DocValueFormat.RAW, new HashMap<>());
        InternalMax internalMax = new InternalMax("max_price", 99.99, format, new HashMap<>());
        SingleMetricAggregateBase result = MaxAggregateProtoUtils.toProto(internalMax);  
        assertFalse("Should not have metadata for null", result.hasMeta());  
        assertEquals("value_as_string should be formatted", "99.99", result.getValueAsString());  
        InternalMax internalMax = new InternalMax("max_price", 1234.5, format, new HashMap<>());
        SingleMetricAggregateBase result = MaxAggregateProtoUtils.toProto(internalMax);
        SingleMetricAggregateBase result = MaxAggregateProtoUtils.toProto(internalMax);  
        InternalMax internalMax = new InternalMax("max_price", 99.99, DocValueFormat.RAW, null);
    }  
        assertTrue("Value should be set as null", result.getValue().hasNullValue());
        assertFalse("value_as_string should NOT be set with RAW format", result.hasValueAsString());
        assertEquals("Value should match", 99.99, result.getValue().getDouble(), 0.001);
        // When no documents match, max returns NEGATIVE_INFINITY (REST line 100)  
        SingleMetricAggregateBase result = MaxAggregateProtoUtils.toProto(internalMax);  
    }  
        assertFalse("value_as_string should NOT be set for infinity", result.hasValueAsString());
 * {@link InternalMax#doXContentBody} behavior.
        assertTrue("value_as_string SHOULD be set with custom format", result.hasValueAsString());
        assertTrue("Metadata should contain priority", result.getMeta().getFieldsMap().containsKey("priority"));  
        assertFalse("value_as_string should NOT be set with RAW format", result.hasValueAsString());
 */  
    }
        InternalMax internalMax = new InternalMax("max_price", 1234.56, format, new HashMap<>());
        InternalMax internalMax = new InternalMax("max_price", Double.NEGATIVE_INFINITY, DocValueFormat.RAW, new HashMap<>());
package org.opensearch.transport.grpc.proto.response.search.aggregation.metrics;
        assertTrue("Metadata should contain color", result.getMeta().getFieldsMap().containsKey("color"));
        assertTrue("Value should be set", result.hasValue());
        assertEquals("Value should be NULL_VALUE", NullValue.NULL_VALUE_NULL, result.getValue().getNullValue());  
        assertEquals("Value should match", 1234.56, result.getValue().getDouble(), 0.001);
        assertTrue("Should have metadata", result.hasMeta());
/**  
        assertTrue("Value should be set as null", result.getValue().hasNullValue());  
        SingleMetricAggregateBase result = MaxAggregateProtoUtils.toProto(internalMax);
        assertTrue("Value should be set as double", result.getValue().hasDouble());  
        DocValueFormat format = new DocValueFormat.Decimal("0.00");
    }  
import org.opensearch.search.DocValueFormat;
    }
        SingleMetricAggregateBase result = MaxAggregateProtoUtils.toProto(internalMax);
        InternalMax internalMax = new InternalMax("max_discount", 0.0, DocValueFormat.RAW, new HashMap<>());
 * compatible open source license.
    public void testToProtoWithNegativeInfinity() {
 * SPDX-License-Identifier: Apache-2.0
        InternalMax internalMax = new InternalMax("max_price", Double.POSITIVE_INFINITY, DocValueFormat.RAW, new HashMap<>());
        assertFalse("value_as_string should NOT be set even with custom format when value is infinity", result.hasValueAsString());
        assertEquals("value_as_string should be formatted", "1234.50", result.getValueAsString());  
    }
import java.util.Map;
        metadata.put("color", "blue");  
        assertTrue("Value should be set as null", result.getValue().hasNullValue());  
 */  
/*  
    }  
        assertTrue("value_as_string SHOULD be set", result.hasValueAsString());
        assertTrue("value_as_string SHOULD be set with custom format", result.hasValueAsString());
    public void testToProtoWithValidValue() {  
    }
    public void testToProtoWithZero() {
        assertTrue("Value should be set as double", result.getValue().hasDouble());  
        assertNotNull("Result should not be null", result);
    public void testToProtoWithEmptyMetadata() {  
        assertEquals("Value should match", 99.99, result.getValue().getDouble(), 0.001);
 * this file be licensed under the Apache-2.0 license or a
        assertTrue("Value should be set as double", result.getValue().hasDouble());  
    // ========================================
        assertFalse("value_as_string should NOT be set for infinity", result.hasValueAsString());
import java.util.HashMap;  
import org.opensearch.test.OpenSearchTestCase;
        assertEquals("Value should match", 1234.5, result.getValue().getDouble(), 0.001);
        assertNotNull("Result should not be null", result);
        // Edge case: Zero is a valid value  
    }
        SingleMetricAggregateBase result = MaxAggregateProtoUtils.toProto(internalMax);
    public void testToProtoWithNegativeValue() {
        DocValueFormat format = new DocValueFormat.Decimal("0.00");
    }
        assertEquals("Value should be -10.5", -10.5, result.getValue().getDouble(), 0.001);
        assertFalse("value_as_string should NOT be set with RAW format", result.hasValueAsString());
        SingleMetricAggregateBase result = MaxAggregateProtoUtils.toProto(internalMax);
    }
    }
        InternalMax internalMax = new InternalMax("max_price", 99.99, DocValueFormat.RAW, metadata);  
        assertFalse("Should not have metadata for empty map", result.hasMeta());  
        assertFalse("value_as_string should NOT be set with RAW format", result.hasValueAsString());
    // ========================================
 * The OpenSearch Contributors require contributions made to  
        SingleMetricAggregateBase result = MaxAggregateProtoUtils.toProto(internalMax);
}
        assertTrue("Value should be set", result.hasValue());
        DocValueFormat format = new DocValueFormat.Decimal("0.00");
        assertTrue("Value should be set as double", result.getValue().hasDouble());
    // Lines 102-104: value_as_string field tests  
    public void testToProtoWithRawFormat() {  
    public void testToProtoWithMetadata() {
 *
    public void testToProtoWithInfinityAndCustomFormat() {  
        SingleMetricAggregateBase result = MaxAggregateProtoUtils.toProto(internalMax);  
        SingleMetricAggregateBase result = MaxAggregateProtoUtils.toProto(internalMax);  
public class MaxAggregateProtoUtilsTests extends OpenSearchTestCase {
import org.opensearch.search.aggregations.metrics.InternalMax;  
    }
import org.opensearch.protobufs.SingleMetricAggregateBase;
        InternalMax internalMax = new InternalMax("max_price", Double.NEGATIVE_INFINITY, format, new HashMap<>());
import org.opensearch.protobufs.NullValue;  
        metadata.put("priority", 5);
        assertEquals("Value should be NULL_VALUE", NullValue.NULL_VALUE_NULL, result.getValue().getNullValue());
        assertEquals("Value should match", 99.99, result.getValue().getDouble(), 0.001);
    public void testToProtoWithDecimalFormatLargeNumber() {  
        assertTrue("Value should be set as double", result.getValue().hasDouble());  
        SingleMetricAggregateBase result = MaxAggregateProtoUtils.toProto(internalMax);  
        DocValueFormat format = new DocValueFormat.Decimal("0.00");  
        assertEquals("Value should be 0.0", 0.0, result.getValue().getDouble(), 0.001);  
    public void testToProtoWithNullMetadata() {  
 * Tests for {@link MaxAggregateProtoUtils} verifying it correctly mirrors
        assertNotNull("Result should not be null", result);
    public void testToProtoWithDecimalFormat() {
        InternalMax internalMax = new InternalMax("max_price", 99.99, DocValueFormat.RAW, new HashMap<>());
        assertEquals("value_as_string should be formatted", "1234.56", result.getValueAsString());  
        assertTrue("Value should be set as double", result.getValue().hasDouble());  
    public void testToProtoWithFormattedValue() {  
        InternalMax internalMax = new InternalMax("max_price", 99.99, DocValueFormat.RAW, new HashMap<>());
    public void testToProtoWithPositiveInfinity() {
