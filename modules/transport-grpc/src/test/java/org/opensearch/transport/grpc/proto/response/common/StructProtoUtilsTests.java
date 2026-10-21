        Value value = StructProtoUtils.toProto(list);
        // Verify nested field
        List<Object> list = new ArrayList<>();
        Value value = StructProtoUtils.toProto(map);
        assertTrue("Value should have null_value set", value.hasNullValue());
        assertNotNull("Value should not be null", value);
        // Verify the result
        assertTrue("Value should have list_value set", value.hasListValue());
        assertEquals("Fourth element should be NULL_VALUE", NullValue.NULL_VALUE, listValue.getValues(3).getNullValue());
        Value value = StructProtoUtils.toProto(null);
        assertEquals("boolean field should match", true, struct.getFieldsOrThrow("boolean").getBoolValue());
import java.util.HashMap;
 */
        Double doubleValue = 3.14159;
import com.google.protobuf.ListValue;
        assertEquals("Number value should match", 42.0, value.getNumberValue(), 0.0);
        Boolean boolValue = true;
        Value value = StructProtoUtils.toProto(doubleValue);
        map.put("nested", nestedMap);
        assertNotNull("Value should not be null", value);
        assertTrue("nested field should be a struct", struct.getFieldsOrThrow("nested").hasStructValue());
        // Create a nested map
        assertTrue("Value should have number_value set", value.hasNumberValue());
        // Convert Map to protobuf Value
        list.add(true);
        assertEquals("Null value should be NULL_VALUE", NullValue.NULL_VALUE, value.getNullValue());
        Struct struct = value.getStructValue();
        expectThrows(IllegalArgumentException.class, () -> StructProtoUtils.toProto(customObject));
import com.google.protobuf.Struct;
    public void testToProtoWithInteger() {
        assertEquals("nestedKey field should match", "nestedValue", nestedStruct.getFieldsOrThrow("nestedKey").getStringValue());
        assertTrue("null field should be null", struct.getFieldsOrThrow("null").hasNullValue());
        // Verify the result
        assertTrue("boolean field should be a boolean", struct.getFieldsOrThrow("boolean").hasBoolValue());
        // Create a map with mixed types
}
        // Verify each field
import java.util.Map;
        assertTrue("Third element should be a boolean", listValue.getValues(2).hasBoolValue());
public class StructProtoUtilsTests extends OpenSearchTestCase {
        // Convert Boolean to protobuf Value
    }
        // Verify the result
import com.google.protobuf.NullValue;
    }
        assertTrue("Value should have struct_value set", value.hasStructValue());
import java.util.List;
        assertEquals("Struct should have 1 field", 1, struct.getFieldsCount());
        // Verify the result
 * compatible open source license.
    }
        list.add(42);
        // Verify the result
        // Verify the result
import java.util.ArrayList;
import com.google.protobuf.Value;
        assertEquals("string field should match", "value", struct.getFieldsOrThrow("string").getStringValue());
        // Create an unsupported type (e.g., a custom class)
    }
        assertNotNull("Value should not be null", value);
package org.opensearch.transport.grpc.proto.response.common;
        assertEquals("Nested struct should have 1 field", 1, nestedStruct.getFieldsCount());
import org.opensearch.test.OpenSearchTestCase;
        list.add("string");
        // Convert Double to protobuf Value
    public void testToProtoWithString() {
        Value value = StructProtoUtils.toProto(map);
        // Convert List to protobuf Value
        nestedMap.put("nestedKey", "nestedValue");
        // Verify the result
        assertEquals("number field should match", 42.0, struct.getFieldsOrThrow("number").getNumberValue(), 0.0);
 * The OpenSearch Contributors require contributions made to
        assertEquals("Third element should match", true, listValue.getValues(2).getBoolValue());
        assertEquals("Second element should match", 42.0, listValue.getValues(1).getNumberValue(), 0.0);
        // Convert Map to protobuf Value
        assertNotNull("Value should not be null", value);
        list.add(null);
        assertTrue("number field should be a number", struct.getFieldsOrThrow("number").hasNumberValue());
        // Verify each element
        assertEquals("Boolean value should match", true, value.getBoolValue());
        assertEquals("null field should be NULL_VALUE", NullValue.NULL_VALUE, struct.getFieldsOrThrow("null").getNullValue());
        assertEquals("List should have 4 elements", 4, listValue.getValuesCount());
 *
    public void testToProtoWithDouble() {
        assertEquals("First element should match", "string", listValue.getValues(0).getStringValue());
        // Verify the result
        assertEquals("Number value should match", 3.14159, value.getNumberValue(), 0.0);
    }
        class CustomClass {}
        assertTrue("nestedKey field should be a string", nestedStruct.getFieldsOrThrow("nestedKey").hasStringValue());
        map.put("boolean", true);
        map.put("string", "value");
        String stringValue = "Hello, World!";
        ListValue listValue = value.getListValue();
 * SPDX-License-Identifier: Apache-2.0
        CustomClass customObject = new CustomClass();
        Map<String, Object> map = new HashMap<>();
    }
        assertEquals("Struct should have 4 fields", 4, struct.getFieldsCount());
        assertTrue("Second element should be a number", listValue.getValues(1).hasNumberValue());
        Map<String, Object> nestedMap = new HashMap<>();
        // Convert String to protobuf Value
        // Attempt to convert to protobuf Value, should throw IllegalArgumentException
    public void testToProtoWithNull() {
        assertTrue("Fourth element should be null", listValue.getValues(3).hasNullValue());
        assertEquals("String value should match", "Hello, World!", value.getStringValue());
        assertTrue("First element should be a string", listValue.getValues(0).hasStringValue());
        assertTrue("Value should have struct_value set", value.hasStructValue());
    }
        map.put("number", 42);
        // Convert null to protobuf Value
    public void testToProtoWithBoolean() {
        assertNotNull("Value should not be null", value);
    public void testToProtoWithNestedMap() {
        assertNotNull("Value should not be null", value);
        assertNotNull("Value should not be null", value);
        Value value = StructProtoUtils.toProto(boolValue);
    public void testToProtoWithMap() {
        assertNotNull("Value should not be null", value);
        Struct struct = value.getStructValue();
        assertTrue("Value should have string_value set", value.hasStringValue());
        assertTrue("string field should be a string", struct.getFieldsOrThrow("string").hasStringValue());
        // Create a list with mixed types
        assertTrue("Value should have bool_value set", value.hasBoolValue());
    public void testToProtoWithUnsupportedType() {
        Value value = StructProtoUtils.toProto(stringValue);
        map.put("null", null);
        Map<String, Object> map = new HashMap<>();
    }
    public void testToProtoWithList() {
    }
        Integer intValue = 42;
/*
 * this file be licensed under the Apache-2.0 license or a
        Value value = StructProtoUtils.toProto(intValue);
        // Convert Integer to protobuf Value
        Struct nestedStruct = struct.getFieldsOrThrow("nested").getStructValue();
        assertTrue("Value should have number_value set", value.hasNumberValue());
