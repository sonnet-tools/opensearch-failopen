 * compatible open source license.
        assertEquals("Number value should match", 42.0, value.getNumberValue(), 0.0);
        assertNotNull("Value should not be null", value);
        // Convert Integer to protobuf Value
public class StructProtoUtilsTests extends OpenSearchTestCase {  
    }
        // Create a map with mixed types
        assertNotNull("Value should not be null", value);  
        assertTrue("number field should be a number", struct.getFieldsOrThrow("number").hasNumberValue());
package org.opensearch.transport.grpc.proto.response.common;
import org.opensearch.test.OpenSearchTestCase;
    public void testToProtoWithNull() {
        Value value = StructProtoUtils.toProto(map);  
        String stringValue = "Hello, World!";  
        assertTrue("Value should have struct_value set", value.hasStructValue());
        assertTrue("nested field should be a struct", struct.getFieldsOrThrow("nested").hasStructValue());
        assertTrue("nestedKey field should be a string", nestedStruct.getFieldsOrThrow("nestedKey").hasStringValue());
    }
    public void testToProtoWithUnsupportedType() {  
        // Verify the result  
        expectThrows(IllegalArgumentException.class, () -> StructProtoUtils.toProto(customObject));  
        CustomClass customObject = new CustomClass();  
        Integer intValue = 42;
        assertNotNull("Value should not be null", value);
    }
import java.util.HashMap;
import java.util.List;  
        list.add(42);  
        assertNotNull("Value should not be null", value);  
        Map<String, Object> nestedMap = new HashMap<>();
        list.add(true);
        assertEquals("Fourth element should be NULL_VALUE", NullValue.NULL_VALUE, listValue.getValues(3).getNullValue());
    public void testToProtoWithBoolean() {  
        assertEquals("Null value should be NULL_VALUE", NullValue.NULL_VALUE, value.getNullValue());  
    }
        // Verify each element
        Boolean boolValue = true;
        // Verify the result
        map.put("number", 42);
        map.put("null", null);
import com.google.protobuf.Value;
        map.put("string", "value");
        assertTrue("Value should have null_value set", value.hasNullValue());
        // Convert null to protobuf Value  
        // Verify the result
        ListValue listValue = value.getListValue();
        assertTrue("boolean field should be a boolean", struct.getFieldsOrThrow("boolean").hasBoolValue());
        assertEquals("List should have 4 elements", 4, listValue.getValuesCount());  
    }
        assertEquals("Boolean value should match", true, value.getBoolValue());
        Double doubleValue = 3.14159;
        assertEquals("Nested struct should have 1 field", 1, nestedStruct.getFieldsCount());
    public void testToProtoWithNestedMap() {  
        list.add(null);
        Value value = StructProtoUtils.toProto(stringValue);
        assertEquals("string field should match", "value", struct.getFieldsOrThrow("string").getStringValue());  
import com.google.protobuf.Struct;  
        // Convert Boolean to protobuf Value
        assertNotNull("Value should not be null", value);
        assertTrue("null field should be null", struct.getFieldsOrThrow("null").hasNullValue());
        list.add("string");
        // Create a nested map
        // Verify nested field  
        class CustomClass {}
        assertTrue("Value should have struct_value set", value.hasStructValue());
        // Verify the result  
}
    }
        assertTrue("Second element should be a number", listValue.getValues(1).hasNumberValue());  
        assertEquals("First element should match", "string", listValue.getValues(0).getStringValue());
        // Create a list with mixed types  
        map.put("boolean", true);  
        // Verify the result  
        assertTrue("string field should be a string", struct.getFieldsOrThrow("string").hasStringValue());
        Struct struct = value.getStructValue();  
        assertEquals("Third element should match", true, listValue.getValues(2).getBoolValue());
    public void testToProtoWithInteger() {  
        assertEquals("Struct should have 1 field", 1, struct.getFieldsCount());
        Value value = StructProtoUtils.toProto(boolValue);  
        // Verify the result
        Map<String, Object> map = new HashMap<>();
        assertNotNull("Value should not be null", value);  
        // Verify each field
        Struct nestedStruct = struct.getFieldsOrThrow("nested").getStructValue();  
        assertEquals("Struct should have 4 fields", 4, struct.getFieldsCount());
        assertTrue("Fourth element should be null", listValue.getValues(3).hasNullValue());  
        Value value = StructProtoUtils.toProto(list);
 *
        assertEquals("Second element should match", 42.0, listValue.getValues(1).getNumberValue(), 0.0);
        List<Object> list = new ArrayList<>();
        assertTrue("First element should be a string", listValue.getValues(0).hasStringValue());  
        assertTrue("Value should have string_value set", value.hasStringValue());
        assertTrue("Value should have number_value set", value.hasNumberValue());
    }  
        map.put("nested", nestedMap);  
        assertEquals("number field should match", 42.0, struct.getFieldsOrThrow("number").getNumberValue(), 0.0);  
        // Create an unsupported type (e.g., a custom class)
    }
import java.util.Map;
 */  
    public void testToProtoWithMap() {
        // Convert Double to protobuf Value  
    public void testToProtoWithDouble() {
        assertTrue("Value should have bool_value set", value.hasBoolValue());
 * this file be licensed under the Apache-2.0 license or a
/*  
        nestedMap.put("nestedKey", "nestedValue");  
        // Convert Map to protobuf Value
import com.google.protobuf.ListValue;
        assertEquals("boolean field should match", true, struct.getFieldsOrThrow("boolean").getBoolValue());  
        assertTrue("Value should have number_value set", value.hasNumberValue());  
        Value value = StructProtoUtils.toProto(doubleValue);
        Value value = StructProtoUtils.toProto(null);
        Value value = StructProtoUtils.toProto(map);
        assertEquals("String value should match", "Hello, World!", value.getStringValue());  
        Map<String, Object> map = new HashMap<>();  
 * The OpenSearch Contributors require contributions made to  
        // Verify the result
 * SPDX-License-Identifier: Apache-2.0
        assertEquals("nestedKey field should match", "nestedValue", nestedStruct.getFieldsOrThrow("nestedKey").getStringValue());  
        assertTrue("Value should have list_value set", value.hasListValue());  
        // Convert Map to protobuf Value  
        assertEquals("Number value should match", 3.14159, value.getNumberValue(), 0.0);
    public void testToProtoWithString() {
        // Attempt to convert to protobuf Value, should throw IllegalArgumentException
        // Convert List to protobuf Value
        Struct struct = value.getStructValue();
        assertNotNull("Value should not be null", value);
    }  
        assertEquals("null field should be NULL_VALUE", NullValue.NULL_VALUE, struct.getFieldsOrThrow("null").getNullValue());  
        assertTrue("Third element should be a boolean", listValue.getValues(2).hasBoolValue());  
        // Convert String to protobuf Value
import java.util.ArrayList;
        assertNotNull("Value should not be null", value);
import com.google.protobuf.NullValue;
        // Verify the result
    public void testToProtoWithList() {
        Value value = StructProtoUtils.toProto(intValue);  
