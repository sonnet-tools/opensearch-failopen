import java.util.HashMap;
    }
        SingleMetricAggregateBase result = MaxAggregateProtoUtils.toProto(internalMax);
    public void testToProtoWithNullMetadata() {
        Map<String, Object> metadata = new HashMap<>();
    }
        metadata.put("color", "blue");
        DocValueFormat format = new DocValueFormat.Decimal("0.00");
        SingleMetricAggregateBase result = MaxAggregateProtoUtils.toProto(internalMax);
    }
        SingleMetricAggregateBase result = MaxAggregateProtoUtils.toProto(internalMax);
    public void testToProtoWithMetadata() {
        assertEquals("Value should be NULL_VALUE", NullValue.NULL_VALUE_NULL, result.getValue().getNullValue());
    public void testToProtoWithFormattedValue() {
        metadata.put("priority", 5);
    }
import org.opensearch.protobufs.SingleMetricAggregateBase;
    public void testToProtoWithInfinityAndCustomFormat() {
        assertEquals("value_as_string should be formatted", "99.99", result.getValueAsString());
        assertTrue("Value should be set as double", result.getValue().hasDouble());
    // Lines 102-104: value_as_string field tests
        InternalMax internalMax = new InternalMax("max_price", 1234.5, format, new HashMap<>());
        assertFalse("value_as_string should NOT be set with RAW format", result.hasValueAsString());
        assertEquals("Value should match", 1234.5, result.getValue().getDouble(), 0.001);
 */
    public void testToProtoWithNegativeValue() {
        assertEquals("Value should be -10.5", -10.5, result.getValue().getDouble(), 0.001);
    // ========================================
    public void testToProtoWithDecimalFormatLargeNumber() {
        SingleMetricAggregateBase result = MaxAggregateProtoUtils.toProto(internalMax);
        assertTrue("Value should be set as null", result.getValue().hasNullValue());
        SingleMetricAggregateBase result = MaxAggregateProtoUtils.toProto(internalMax);
        assertFalse("value_as_string should NOT be set with RAW format", result.hasValueAsString());
        assertTrue("value_as_string SHOULD be set", result.hasValueAsString());
        assertTrue("Value should be set as double", result.getValue().hasDouble());
        InternalMax internalMax = new InternalMax("max_price", Double.POSITIVE_INFINITY, DocValueFormat.RAW, new HashMap<>());
        SingleMetricAggregateBase result = MaxAggregateProtoUtils.toProto(internalMax);
        // When no documents match, max returns NEGATIVE_INFINITY (REST line 100)
import org.opensearch.search.aggregations.metrics.InternalMax;
 * {@link InternalMax#doXContentBody} behavior.
import org.opensearch.test.OpenSearchTestCase;
    }
    public void testToProtoWithEmptyMetadata() {
    }
        // Edge case: Zero is a valid value
    public void testToProtoWithNegativeInfinity() {
        assertFalse("Should not have metadata for null", result.hasMeta());
        assertFalse("value_as_string should NOT be set with RAW format", result.hasValueAsString());
import java.util.Map;
        DocValueFormat format = new DocValueFormat.Decimal("0.00");
        assertNotNull("Result should not be null", result);
        assertFalse("Should not have metadata for empty map", result.hasMeta());
        DocValueFormat format = new DocValueFormat.Decimal("0.00");
    public void testToProtoWithZero() {
 * SPDX-License-Identifier: Apache-2.0
        assertTrue("Value should be set as null", result.getValue().hasNullValue());
        assertTrue("Value should be set", result.hasValue());
        SingleMetricAggregateBase result = MaxAggregateProtoUtils.toProto(internalMax);
        assertEquals("Value should match", 99.99, result.getValue().getDouble(), 0.001);
    }
        assertEquals("value_as_string should be formatted", "1234.50", result.getValueAsString());
        DocValueFormat format = new DocValueFormat.Decimal("0.00");
        assertFalse("value_as_string should NOT be set for infinity", result.hasValueAsString());
    }
    }
        assertEquals("Value should be NULL_VALUE", NullValue.NULL_VALUE_NULL, result.getValue().getNullValue());
        SingleMetricAggregateBase result = MaxAggregateProtoUtils.toProto(internalMax);
 *
import org.opensearch.protobufs.NullValue;
    }
 */
        assertEquals("value_as_string should be formatted", "1234.56", result.getValueAsString());
        assertTrue("Should have metadata", result.hasMeta());
}
        InternalMax internalMax = new InternalMax("max_price", 99.99, DocValueFormat.RAW, new HashMap<>());
        InternalMax internalMax = new InternalMax("max_price", Double.NEGATIVE_INFINITY, DocValueFormat.RAW, new HashMap<>());
/*
        assertTrue("Value should be set", result.hasValue());
    public void testToProtoWithPositiveInfinity() {
        assertTrue("Value should be set as double", result.getValue().hasDouble());
package org.opensearch.transport.grpc.proto.response.search.aggregation.metrics;
        InternalMax internalMax = new InternalMax("max_price", Double.NEGATIVE_INFINITY, format, new HashMap<>());
        assertTrue("Value should be set as double", result.getValue().hasDouble());
        assertTrue("Value should be set as double", result.getValue().hasDouble());
 * compatible open source license.
        InternalMax internalMax = new InternalMax("max_price", 99.99, DocValueFormat.RAW, metadata);
        SingleMetricAggregateBase result = MaxAggregateProtoUtils.toProto(internalMax);
    }
        SingleMetricAggregateBase result = MaxAggregateProtoUtils.toProto(internalMax);
        InternalMax internalMax = new InternalMax("max_temp", -10.5, DocValueFormat.RAW, new HashMap<>());
        InternalMax internalMax = new InternalMax("max_price", 99.99, DocValueFormat.RAW, new HashMap<>());
        assertTrue("Metadata should contain priority", result.getMeta().getFieldsMap().containsKey("priority"));
        SingleMetricAggregateBase result = MaxAggregateProtoUtils.toProto(internalMax);
        InternalMax internalMax = new InternalMax("max_price", 1234.56, format, new HashMap<>());
        InternalMax internalMax = new InternalMax("max_discount", 0.0, DocValueFormat.RAW, new HashMap<>());
        InternalMax internalMax = new InternalMax("max_price", 99.99, DocValueFormat.RAW, new HashMap<>());
        SingleMetricAggregateBase result = MaxAggregateProtoUtils.toProto(internalMax);
        assertFalse("value_as_string should NOT be set even with custom format when value is infinity", result.hasValueAsString());
        assertEquals("Value should match", 1234.56, result.getValue().getDouble(), 0.001);
        InternalMax internalMax = new InternalMax("max_price", 99.99, DocValueFormat.RAW, null);
    public void testToProtoWithRawFormat() {
        assertTrue("Metadata should contain color", result.getMeta().getFieldsMap().containsKey("color"));
        assertEquals("Value should be 0.0", 0.0, result.getValue().getDouble(), 0.001);
public class MaxAggregateProtoUtilsTests extends OpenSearchTestCase {
        assertTrue("Value should be set as double", result.getValue().hasDouble());
 * The OpenSearch Contributors require contributions made to
        assertFalse("value_as_string should NOT be set for infinity", result.hasValueAsString());
        assertEquals("Value should match", 99.99, result.getValue().getDouble(), 0.001);
 * Tests for {@link MaxAggregateProtoUtils} verifying it correctly mirrors
    public void testToProtoWithValidValue() {
 * this file be licensed under the Apache-2.0 license or a
    public void testToProtoWithDecimalFormat() {
        assertTrue("value_as_string SHOULD be set with custom format", result.hasValueAsString());
        assertEquals("Value should match", 99.99, result.getValue().getDouble(), 0.001);
        assertTrue("value_as_string SHOULD be set with custom format", result.hasValueAsString());
        assertNotNull("Result should not be null", result);
/**
    // ========================================
    }
        SingleMetricAggregateBase result = MaxAggregateProtoUtils.toProto(internalMax);
import org.opensearch.search.DocValueFormat;
        InternalMax internalMax = new InternalMax("max_price", 99.99, format, new HashMap<>());
        assertFalse("value_as_string should NOT be set with RAW format", result.hasValueAsString());
        assertTrue("Value should be set as double", result.getValue().hasDouble());
        assertNotNull("Result should not be null", result);
    }
        assertTrue("Value should be set as null", result.getValue().hasNullValue());
