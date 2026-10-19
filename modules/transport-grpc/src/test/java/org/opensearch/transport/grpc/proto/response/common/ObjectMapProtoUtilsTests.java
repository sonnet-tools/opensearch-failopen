    /*
import java.util.Arrays;
        // Verify nested map
    }
        // Verify the conversion
    */
        assertTrue("Should have double value", value.hasDouble());
        assertNotNull("Value should not be null", value);
        List<Object> innerList = Arrays.asList(1, 2, 3);
        // Verify the exception message contains the object's toString
        // Convert Map to Protocol Buffer
        assertTrue("Should have int64 value", value.hasInt64());
        assertNotNull("Value should not be null", value);
    public void testToProtoWithEmptyList() {
        assertEquals("String value should match enum name", enumValue.toString(), value.getString());
            "Nested list should have correct size",
        // Verify the conversion
        assertNotNull("Value should not be null", value);
        Map<String, Object> outerMap = new HashMap<>();
        );
        // Verify the conversion
            "Nested list second element should match",
        IllegalArgumentException exception = expectThrows(
        assertNotNull("Value should not be null", value);
        assertNotNull("Value should not be null", value);
            2,
        outerMap.put("list", innerList);
    }
        List<Object> listValue = Arrays.asList();
        assertEquals("Double value should match", doubleValue, value.getDouble(), 0.0);
        assertTrue("Should have int32 value", value.hasInt32());
    */
        );
 * this file be licensed under the Apache-2.0 license or a
        // Verify the conversion
        assertTrue("Nested list should exist", value.getObjectMap().containsFields("list"));
            "value",
        assertEquals("List should be empty", 0, value.getListValue().getValueCount());
        UnsupportedType unsupportedValue = new UnsupportedType();
        // Convert Boolean to Protocol Buffer
        innerMap.put("key", "value");
        assertNotNull("Value should not be null", value);
        assertTrue("Should have object map", value.hasObjectMap());
        );
 */
        // Verify the conversion
            "Nested map value should match",
        assertTrue("Nested map key should exist", value.getObjectMap().getFieldsOrThrow("map").getObjectMap().containsFields("key"));
        assertNotNull("Value should not be null", value);
    public void testToProtoWithList() {
        assertTrue("Nested list should be list value", value.getObjectMap().getFieldsOrThrow("list").hasListValue());
        ObjectMap.Value value = ObjectMapProtoUtils.toProto(doubleValue);
    }
    /*
        ObjectMap.Value value = ObjectMapProtoUtils.toProto(boolValue);
 *
        );
        assertTrue("Nested map should be object map", value.getObjectMap().getFieldsOrThrow("map").hasObjectMap());
        // Convert null to Protocol Buffer
        ObjectMap.Value value = ObjectMapProtoUtils.toProto(null);
        // Verify map entries
        VALUE_3
            value.getObjectMap().getFieldsOrThrow("list").getListValue().getValue(1).getInt32()
        assertEquals("Bool value should match", boolValue, value.getBool());
        assertEquals(
    public void testToProtoWithLong() {
        // Verify the conversion
        );
        ObjectMap.Value value = ObjectMapProtoUtils.toProto(longValue);
        @Override
    public void testToProtoWithInteger() {
        // Convert String to Protocol Buffer
        assertEquals("Int32 value should match", intValue.intValue(), value.getInt32());
        // Convert empty List to Protocol Buffer
        assertEquals("First element should match", "string", value.getListValue().getValue(0).getString());
    }
        ObjectMap.Value value = ObjectMapProtoUtils.toProto(mapValue);
        assertTrue("Should have object map", value.hasObjectMap());
        // Convert List to Protocol Buffer
            3,
        // Verify the conversion
    */
    }
 * compatible open source license.
        assertEquals(
        // Create an unsupported type (a custom class)
    public void testToProtoWithNestedStructures() {
            "Nested list first element should match",
        Integer intValue = 42;
    public void testToProtoWithMap() {
            value.getObjectMap().getFieldsOrThrow("map").getObjectMap().getFieldsCount()
        assertTrue("Should have list value", value.hasListValue());
        Map<String, Object> innerMap = new HashMap<>();
        // Verify the conversion
        assertTrue("Int entry should be int32", value.getObjectMap().getFieldsOrThrow("int").hasInt32());
    public void testToProtoWithEmptyMap() {
        assertEquals("Second element should match", 42, value.getListValue().getValue(1).getInt32());
        TestEnum enumValue = TestEnum.VALUE_2;
        String stringValue = "test string";
        assertTrue("Should have string value", value.hasString());
        assertEquals("List should have correct size", 3, value.getListValue().getValueCount());
            () -> ObjectMapProtoUtils.toProto(unsupportedValue)
        VALUE_2,
import org.opensearch.test.OpenSearchTestCase;
    }
        assertTrue("Exception message should contain object's toString", exception.getMessage().contains(unsupportedValue.toString()));
    private enum TestEnum {
        );
        // Verify the conversion
    public void testToProtoWithDouble() {
        assertTrue("Nested map should exist", value.getObjectMap().containsFields("map"));
    }
        // Verify nested list
        assertNotNull("Value should not be null", value);
        // Verify list elements
        assertNotNull("Value should not be null", value);
    }
        assertEquals("Map should be empty", 0, value.getObjectMap().getFieldsCount());
        assertTrue("Should have float value", value.hasFloat());
        assertTrue("Should have object map", value.hasObjectMap());
        // Verify the conversion
        }
        Double doubleValue = 3.14159;
        assertEquals("Bool entry should match", true, value.getObjectMap().getFieldsOrThrow("bool").getBoolValue());
        assertEquals(
        assertTrue("Bool entry should exist", value.getObjectMap().containsFields("bool"));
        assertEquals(
    }
        ObjectMap.Value value = ObjectMapProtoUtils.toProto(listValue);
    // TODO: ObjectMap functionality changed in protobufs 0.8.0
        assertNotNull("Value should not be null", value);
        assertNotNull("Value should not be null", value);
            "Nested map should have correct size",
        // Verify the conversion
        // Verify the conversion
    public void testToProtoWithBoolean() {
        assertTrue("Should have bool value", value.hasBool());
    }
        Boolean boolValue = true;
    private static class UnsupportedType {
    }
        mapValue.put("bool", true);
        assertEquals("String value should match", stringValue, value.getString());
        // Convert Long to Protocol Buffer
        // Attempt to convert to Protocol Buffer, should throw IllegalArgumentException
        ObjectMap.Value value = ObjectMapProtoUtils.toProto(listValue);
        );
        assertTrue("Bool entry should be bool", value.getObjectMap().getFieldsOrThrow("bool").hasBoolValue());
            "Nested list third element should match",
        assertEquals("Float value should match", floatValue, value.getFloat(), 0.0f);
        ObjectMap.Value value = ObjectMapProtoUtils.toProto(intValue);
        List<Object> listValue = Arrays.asList("string", 42, true);
import java.util.List;
 * The OpenSearch Contributors require contributions made to
        // Convert empty Map to Protocol Buffer
public class ObjectMapProtoUtilsTests extends OpenSearchTestCase {
        // Convert Integer to Protocol Buffer
        // Convert Double to Protocol Buffer
            value.getObjectMap().getFieldsOrThrow("list").getListValue().getValue(0).getInt32()
        assertEquals("Null value should be NULL_VALUE_NULL", NullValue.NULL_VALUE_NULL, value.getNullValue());
        ObjectMap.Value value = ObjectMapProtoUtils.toProto(outerMap);
        assertTrue("Should have string value", value.hasString());
    // Helper class for testing unsupported types
        // Convert to Protocol Buffer
        Map<String, Object> mapValue = new HashMap<>();
            3,
    // Helper enum for testing
        assertEquals("Map should have correct size", 2, value.getObjectMap().getFieldsCount());
/*
    }
        assertEquals(
    }
import org.opensearch.protobufs.ObjectMap;
        assertEquals(
        assertEquals("Map should have correct size", 3, value.getObjectMap().getFieldsCount());
        mapValue.put("string", "value");
            IllegalArgumentException.class,
        // Create a nested structure
        assertEquals("Int64 value should match", longValue.longValue(), value.getInt64());
        assertTrue("String entry should exist", value.getObjectMap().containsFields("string"));
            1,
    public void testToProtoWithString() {
    public void testToProtoWithFloat() {
        outerMap.put("map", innerMap);
        assertTrue("First element should be string", value.getListValue().getValue(0).hasString());
        assertNotNull("Value should not be null", value);
        // Verify the conversion
        ObjectMap.Value value = ObjectMapProtoUtils.toProto(mapValue);
    }
        assertTrue("Second element should be int32", value.getListValue().getValue(1).hasInt32());
package org.opensearch.transport.grpc.proto.response.common;
    public void testToProtoWithNull() {
        assertTrue("Third element should be bool", value.getListValue().getValue(2).hasBool());
        ObjectMap.Value value = ObjectMapProtoUtils.toProto(stringValue);
import org.opensearch.protobufs.NullValue;
        assertTrue("String entry should be string", value.getObjectMap().getFieldsOrThrow("string").hasStringValue());
            value.getObjectMap().getFieldsOrThrow("list").getListValue().getValue(2).getInt32()
        ObjectMap.Value value = ObjectMapProtoUtils.toProto(enumValue);
        Map<String, Object> mapValue = new HashMap<>();
        assertTrue("Should have null value", value.hasNullValue());
            value.getObjectMap().getFieldsOrThrow("map").getObjectMap().getFieldsOrThrow("key").getStringValue()
    public void testToProtoWithUnsupportedType() {
        mapValue.put("int", 42);
            return "UnsupportedType";
        ObjectMap.Value value = ObjectMapProtoUtils.toProto(floatValue);
        assertTrue("Int entry should exist", value.getObjectMap().containsFields("int"));
 * SPDX-License-Identifier: Apache-2.0
        assertEquals("String entry should match", "value", value.getObjectMap().getFieldsOrThrow("string").getStringValue());
    public void testToProtoWithEnum() {
            value.getObjectMap().getFieldsOrThrow("list").getListValue().getValueCount()
        assertEquals("Third element should match", true, value.getListValue().getValue(2).getBool());
        // Convert Enum to Protocol Buffer
    }
        Float floatValue = 2.71828f;
    /*
        Long longValue = 9223372036854775807L;
    }
        assertNotNull("Value should not be null", value);
        VALUE_1,
}
        assertEquals("Int entry should match", 42, value.getObjectMap().getFieldsOrThrow("int").getInt32());
        public String toString() {
            1,
        // Convert Float to Protocol Buffer
        assertTrue("Should have list value", value.hasListValue());
