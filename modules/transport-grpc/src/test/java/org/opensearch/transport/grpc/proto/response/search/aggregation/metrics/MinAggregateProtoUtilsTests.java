        InternalMin internalMin = new InternalMin("min_price", Double.NEGATIVE_INFINITY, DocValueFormat.RAW, new HashMap<>());
        assertFalse("Should not have metadata for empty map", result.hasMeta());
        assertTrue("Value should be set as double", result.getValue().hasDouble());
        assertTrue("Value should be set as double", result.getValue().hasDouble());
    public void testToProtoWithNullMetadata() {
    }
        DocValueFormat format = new DocValueFormat.Decimal("0.00");
 * SPDX-License-Identifier: Apache-2.0
        assertEquals("Value should be NULL_VALUE", NullValue.NULL_VALUE_NULL, result.getValue().getNullValue());
 * The OpenSearch Contributors require contributions made to
        SingleMetricAggregateBase result = MinAggregateProtoUtils.toProto(internalMin);
        assertFalse("value_as_string should NOT be set with RAW format", result.hasValueAsString());
        DocValueFormat format = new DocValueFormat.Decimal("0.00");
        assertEquals("value_as_string should be formatted", "5.25", result.getValueAsString());
        InternalMin internalMin = new InternalMin("min_price", Double.POSITIVE_INFINITY, DocValueFormat.RAW, new HashMap<>());
import java.util.HashMap;
    }
        assertTrue("Value should be set as double", result.getValue().hasDouble());
import java.util.Map;
        assertTrue("value_as_string SHOULD be set", result.hasValueAsString());
        SingleMetricAggregateBase result = MinAggregateProtoUtils.toProto(internalMin);
        assertTrue("Value should be set as null", result.getValue().hasNullValue());
        InternalMin internalMin = new InternalMin("min_price", 10.5, DocValueFormat.RAW, metadata);
        assertTrue("Value should be set as double", result.getValue().hasDouble());
 * {@link InternalMin#doXContentBody} behavior.
        assertEquals("Value should be 0.0", 0.0, result.getValue().getDouble(), 0.001);
    public void testToProtoWithValidValue() {
}
        metadata.put("priority", 1);
        assertTrue("Value should be set as double", result.getValue().hasDouble());
        SingleMetricAggregateBase result = MinAggregateProtoUtils.toProto(internalMin);
import org.opensearch.protobufs.SingleMetricAggregateBase;
    public void testToProtoWithDecimalFormat() {
package org.opensearch.transport.grpc.proto.response.search.aggregation.metrics;
        assertTrue("Value should be set", result.hasValue());
    }
import org.opensearch.search.DocValueFormat;
public class MinAggregateProtoUtilsTests extends OpenSearchTestCase {
        assertFalse("value_as_string should NOT be set with RAW format", result.hasValueAsString());
    }
        assertTrue("Value should be set", result.hasValue());
        SingleMetricAggregateBase result = MinAggregateProtoUtils.toProto(internalMin);
        assertTrue("Value should be set as double", result.getValue().hasDouble());
        assertNotNull("Result should not be null", result);
        InternalMin internalMin = new InternalMin("min_discount", 0.0, DocValueFormat.RAW, new HashMap<>());
        assertTrue("value_as_string SHOULD be set with custom format", result.hasValueAsString());
    }
        InternalMin internalMin = new InternalMin("min_price", 5.25, format, new HashMap<>());
        DocValueFormat format = new DocValueFormat.Decimal("0.00");
        assertTrue("Value should be set as null", result.getValue().hasNullValue());
        InternalMin internalMin = new InternalMin("min_price", Double.POSITIVE_INFINITY, format, new HashMap<>());
 *
        assertEquals("Value should match", 5.25, result.getValue().getDouble(), 0.001);
        assertEquals("value_as_string should be formatted", "1234.50", result.getValueAsString());
        assertFalse("value_as_string should NOT be set for infinity", result.hasValueAsString());
        InternalMin internalMin = new InternalMin("min_price", 10.5, DocValueFormat.RAW, new HashMap<>());
    }
        assertFalse("value_as_string should NOT be set for infinity", result.hasValueAsString());
        SingleMetricAggregateBase result = MinAggregateProtoUtils.toProto(internalMin);
        assertNotNull("Result should not be null", result);
import org.opensearch.protobufs.NullValue;
        assertFalse("Should not have metadata for null", result.hasMeta());
    public void testToProtoWithInfinityAndCustomFormat() {
        assertEquals("Value should match", 1234.5, result.getValue().getDouble(), 0.001);
    public void testToProtoWithEmptyMetadata() {
    }
        SingleMetricAggregateBase result = MinAggregateProtoUtils.toProto(internalMin);
    public void testToProtoWithNegativeInfinity() {
import org.opensearch.search.aggregations.metrics.InternalMin;
 */
        DocValueFormat format = new DocValueFormat.Decimal("0.00");
 * Tests for {@link MinAggregateProtoUtils} verifying it correctly mirrors
    public void testToProtoWithPositiveInfinity() {
    }
        InternalMin internalMin = new InternalMin("min_price", 10.5, DocValueFormat.RAW, null);
        assertTrue("Should have metadata", result.hasMeta());
/*
    }
        InternalMin internalMin = new InternalMin("min_temp", -10.5, DocValueFormat.RAW, new HashMap<>());
    public void testToProtoWithDecimalFormatLargeNumber() {
    public void testToProtoWithRawFormat() {
import org.opensearch.test.OpenSearchTestCase;
        assertTrue("Metadata should contain priority", result.getMeta().getFieldsMap().containsKey("priority"));
        assertFalse("value_as_string should NOT be set with RAW format", result.hasValueAsString());
        InternalMin internalMin = new InternalMin("min_price", 1234.5, format, new HashMap<>());
    public void testToProtoWithZero() {
    public void testToProtoWithMetadata() {
        assertEquals("Value should be -10.5", -10.5, result.getValue().getDouble(), 0.001);
    }
        InternalMin internalMin = new InternalMin("min_price", 10.5, DocValueFormat.RAW, new HashMap<>());
        assertEquals("Value should match", 10.5, result.getValue().getDouble(), 0.001);
        SingleMetricAggregateBase result = MinAggregateProtoUtils.toProto(internalMin);
 * this file be licensed under the Apache-2.0 license or a
        SingleMetricAggregateBase result = MinAggregateProtoUtils.toProto(internalMin);
        assertNotNull("Result should not be null", result);
        assertEquals("Value should match", 10.5, result.getValue().getDouble(), 0.001);
    public void testToProtoWithNegativeValue() {
    }
        InternalMin internalMin = new InternalMin("min_price", 10.5, DocValueFormat.RAW, new HashMap<>());
        SingleMetricAggregateBase result = MinAggregateProtoUtils.toProto(internalMin);
/**
 */
        SingleMetricAggregateBase result = MinAggregateProtoUtils.toProto(internalMin);
        assertEquals("Value should match", 10.5, result.getValue().getDouble(), 0.001);
        assertTrue("Value should be set as double", result.getValue().hasDouble());
        assertTrue("value_as_string SHOULD be set with custom format", result.hasValueAsString());
        SingleMetricAggregateBase result = MinAggregateProtoUtils.toProto(internalMin);
    }
        assertTrue("Metadata should contain color", result.getMeta().getFieldsMap().containsKey("color"));
        Map<String, Object> metadata = new HashMap<>();
        assertEquals("Value should be NULL_VALUE", NullValue.NULL_VALUE_NULL, result.getValue().getNullValue());
        assertTrue("Value should be set as null", result.getValue().hasNullValue());
 * compatible open source license.
        SingleMetricAggregateBase result = MinAggregateProtoUtils.toProto(internalMin);
        assertFalse("value_as_string should NOT be set even with custom format when value is infinity", result.hasValueAsString());
        assertFalse("value_as_string should NOT be set with RAW format", result.hasValueAsString());
    public void testToProtoWithFormattedValue() {
        InternalMin internalMin = new InternalMin("min_price", 10.5, format, new HashMap<>());
        assertEquals("value_as_string should be formatted", "10.50", result.getValueAsString());
    }
        SingleMetricAggregateBase result = MinAggregateProtoUtils.toProto(internalMin);
        metadata.put("color", "red");
